package servlet;

import dao.daoImpl.*;
import dao.idao.*;
import entyties.*;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by alexm on 21.09.2019.
 */
@WebServlet("/booking")
public class BookingServlet extends HttpServlet {

    Logger log = Logger.getLogger(BookingServlet.class);
    private final double timeFor1KM = 2.5;
    private final double priceFor1KM = 11;
    private final double minDiscountValue= 20;
    private IUserDao userDao = new UserDaoImpl();
    private IStreetDao streetDao = new StreetDaoImpl();
    private ITaxiDao taxiDao = new TaxiDaoImpl();
    private ITaxiRideDao wayDao = new TaxiRideDaoImpl();
    private IBookingDao bookingDao = new BookingDaoImpl();
    private IActionDao actionDao = new ActionDaoImpl();
    private IUserActionDao userActionDao = new UserActionDaoImpl();



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Street> streets = streetDao.getAllStreets();
        req.setAttribute("streets", streets);

        String userName = req.getParameter("userName");
        req.setAttribute("userName", userName);
        log.info("username booking: " + userName);

        List<Taxi> taxis = taxiDao.getAllAvailableCars();
        req.setAttribute("taxis", taxis);

        HttpSession session = req.getSession();
        String usName = session.getAttribute("user").toString();

        User user = new User();
        user.setUserId((long) userDao.getIdByUserName(usName));
        user.setUserName(usName);

        List<Booking> bookingList = bookingDao.getAllBookings(user);
        req.setAttribute("bookingList", bookingList);

        RequestDispatcher rd = req.getRequestDispatcher("/bookingtaxi.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Street> streets = streetDao.getAllStreets();
        req.setAttribute("streets", streets);

        List<Taxi> taxis = taxiDao.getAllAvailableCars();
        req.setAttribute("taxis", taxis);

        //userName isn't working here
        String userName = req.getParameter("userName");
        req.setAttribute("userName", userName);
        log.info("username booking: " + userName);

        HttpSession session = req.getSession();
        String usName = session.getAttribute("user").toString();

        User user = new User();
        user.setUserId((long) userDao.getIdByUserName(usName));
        user.setUserName(usName);

        String home = req.getParameter("startAddress");
        String dest = req.getParameter("endAddress");
        //TODO if there are no available cars don't allow booking
        String car = req.getParameter("carClass");
//        if(car.length() != 0){
//        work here booking
//        }
        //Get available car
        final Taxi taxi = taxiDao.getCarByCarType(car);
        //Get streets home and dest
        Street homeStreet = new Street(home);
        homeStreet.setId((long) streetDao.getStreetIdByName(home));
        Street destStreet = new Street(dest);
        destStreet.setId((long) streetDao.getStreetIdByName(dest));

        log.info(home);
        log.info(dest);
        log.info(car);
        log.info("home street id = " + homeStreet.toString());
        log.info("dest street id = " + destStreet.toString());
        //get sum km of way
        double km = wayDao.getSumKm(homeStreet,destStreet);

        log.info(km + "km");
        log.info("USER DETAILS: " + user.toString());
        //TODO (sum of km is calculated right,
        // need to calculate the price and wait
        // and book booking
        // and set taxi to not free and after some time to free
        // add Action for user
        Action action = actionDao.getUserAction(user);
        //get right userAction
        UserAction userAction = userActionDao.getUserActionByAction(action);
        log.info(userAction.toString());
        //get user discount

        //working here
        //get id's streets and sum(km) and price and maybe coef and time arrival
        //book a taxi and after some time of booking set isFree taxi = true;
        //Get price
        double price = km * priceFor1KM;
        if(action.getDiscount() > minDiscountValue){
            price = price- action.getDiscount();
        }else{
            actionDao.addSumToAction(user, action, price%10);
        }
        log.info("price before discount is: " + price);
        // price = km * 11 - action.getDiscount();
        log.info("PRICE AFTER DISCOUNT: " + price);
        log.info("Taxi Details: " + taxi.toString());
        //WAITING TIME
        final double waitTime = wayDao.getSumKm(homeStreet, taxi.getCurr_pos()) * timeFor1KM;
        int time = (int) waitTime;
        //waiting ride time
        double rideTime = km*5;
        req.setAttribute("waitingTime", time);
        log.info("Wait time for your car is: " + waitTime + " min");
        //Booking handling
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setStartAddress(homeStreet);
        booking.setEndAddress(destStreet);
        booking.setTaxi(taxi);
        booking.setAction(userAction);
        booking.setPrice(price);
        bookingDao.book(booking);
        //set car is not free, change car position, in time set car to free
        taxi.setIs_free(false);
        taxiDao.setCarBusy(taxi);
        taxiDao.changeCurrentPos(taxi, destStreet);
        Thread t = new Thread(new Runnable() {
            public void run() {
                synchronized (this) {
                    try {
                        Thread.sleep(30000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    taxiDao.setCarFree(taxi);
                }
            }
        });
        t.start();
        //taxiDao.setCarFree(taxi);


        List<Booking> bookingList = bookingDao.getAllBookings(user);
        req.setAttribute("bookingList", bookingList);

        RequestDispatcher rd = req.getRequestDispatcher("/bookingtaxi.jsp");
        rd.forward(req, resp);
    }
}
