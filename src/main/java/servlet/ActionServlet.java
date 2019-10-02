package servlet;

import dao.daoImpl.ActionDaoImpl;
import dao.daoImpl.BookingDaoImpl;
import dao.daoImpl.UserActionDaoImpl;
import dao.daoImpl.UserDaoImpl;
import dao.idao.IActionDao;
import dao.idao.IBookingDao;
import dao.idao.IUserActionDao;
import dao.idao.IUserDao;
import entyties.Action;
import entyties.Booking;
import entyties.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by alexm on 21.09.2019.
 */

@WebServlet("/actions")
public class ActionServlet extends HttpServlet {
    IActionDao actionDao = new ActionDaoImpl();
    IUserDao userDao = new UserDaoImpl();
    IUserActionDao userActionDao = new UserActionDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Get user and his action
        HttpSession session = req.getSession();
        String userName = session.getAttribute("user").toString();

        User user = new User();
        user.setUserName(userName);
        user.setUserId((long) userDao.getIdByUserName(userName));

        Action action = actionDao.getUserAction(user);
        req.setAttribute("action", action.getDiscount());

        RequestDispatcher rd = req.getRequestDispatcher("/actionForUser.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IBookingDao iBookingDao = new BookingDaoImpl();
        Booking booking = new Booking();
        iBookingDao.book(booking);
    }

}
