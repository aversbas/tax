package dao.daoImpl;

import dao.util.ConnectionFactory;
import dao.idao.*;
import entyties.*;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingDaoImpl implements IBookingDao {

    Logger log = Logger.getLogger(BookingDaoImpl.class);

    private IStreetDao streetDao = new StreetDaoImpl();
    private IActionDao actionDao = new ActionDaoImpl();
    private ITaxiDao carDao = new TaxiDaoImpl();
    private IUserActionDao userActionDao = new UserActionDaoImpl();

    @Override
    public void book(Booking booking) {

        long userId = booking.getUser().getId();
        long home = booking.getStartAddress().getId();
        long dest = booking.getEndAddress().getId();
        long car = booking.getTaxi().getId();
        long action = booking.getAction().getId();
        double price = booking.getPrice();

        String sql = "INSERT INTO booking (user,start_address, end_address, action, taxi, price) VALUES (?,?,?,?,?,?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, userId);
            stmt.setLong(2, home);
            stmt.setLong(3, dest);
            stmt.setLong(4, car);
            stmt.setLong(5, action);
            stmt.setDouble(6, price);
            stmt.executeUpdate();
            log.info("user saved");
            log.info("BookingDaoImpl: booked successfully");
        }catch (SQLException e){
            log.error(e);
        }
    }

    @Override
    public void cancelBook(Booking booking) {

    }

    @Override
    public List<Booking> getAllBookings(User user) {
        List<Booking> bookingList = new ArrayList<Booking>();
        String sql = "SELECT * FROM booking WHERE user=?";
        ResultSet rs = null;
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1,user.getId());
            rs = stmt.executeQuery();
            while (rs.next()) {

                Booking booking = new Booking();
                long id = rs.getLong(1);
                int userId = rs.getInt(2);
                int home = rs.getInt(3);
                int dest = rs.getInt(4);

                Street startAddress = streetDao.getById(home);
                Street endAddress = streetDao.getById(dest);

                Action action = actionDao.getUserAction(user);
                int actionId = rs.getInt(6);

                UserAction userAction = userActionDao.getUserActionByAction(action);

                int carId = rs.getInt(5);
                Taxi taxi = carDao.getCarById(carId);

                double price = rs.getDouble(7);
                //build booking
                booking.setId(id);
                booking.setUser(user);
                booking.setStartAddress(startAddress);
                booking.setEndAddress(endAddress);
                booking.setAction(userAction);
                booking.setTaxi(taxi);
                booking.setPrice(price);

                bookingList.add(booking);

            }
            return bookingList;
        } catch (SQLException e) {
            e.getMessage();
        }
        return bookingList;
    }

    @Override
    public Booking getBooking(int id) {
        return null;
    }

}
