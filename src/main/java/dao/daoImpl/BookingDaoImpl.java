package dao.daoImpl;

import dao.ConnectionFactory;
import dao.idao.*;
import entyties.*;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexm on 20.09.2019.
 */
public class BookingDaoImpl implements IBookingDao {

    Logger log = Logger.getLogger(BookingDaoImpl.class);

    private IStreetDao streetDao = new StreetDaoImpl();
    private IActionDao actionDao = new ActionDaoImpl();
    private ITaxiDao carDao = new TaxiDaoImpl();
    private IUserActionDao userActionDao = new UserActionDaoImpl();

    @Override
    public void book(Booking booking) {
        long user = booking.getUser().getId();
        long startAddress = booking.getStartAddress().getId();
        long endAddress = booking.getEndAddress().getId();
        long taxi = booking.getTaxi().getId();
        long action = booking.getAction().getId();
        double price = booking.getPrice();
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement("INSERT INTO booking (user, start_address, end_address, action, taxi, price) VALUES (?,?,?,?,?,?)");
            stmt.setLong(1, user);
            stmt.setLong(2, startAddress);
            stmt.setLong(3, endAddress);
            stmt.setLong(4, action);
            stmt.setLong(5, taxi);
            stmt.setDouble(6, price);
            stmt.executeUpdate();
            System.out.println("user saved");
            log.info("BookingDaoImpl: booked successfully");
        }catch (SQLException e){
            e.getMessage();
        }
        finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    log.error("Cannot book" + e.getMessage());
                    e.getMessage();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    log.error("Connection exception: " + e.getMessage());
                    e.getMessage();
                }
            }
        }
    }

    @Override
    public void cancelBook(Booking booking) {

    }

    @Override
    public List<Booking> getAllBookings(User user) {
        List<Booking> bookingList = new ArrayList<Booking>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM booking where id=?");
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
                int actionId = rs.getInt(5);

                UserAction userAction = userActionDao.getUserActionByAction(action);
                int carId = rs.getInt(6);

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
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.getMessage();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.getMessage();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.getMessage();
                }
            }
        }

        return null;
    }

    @Override
    public Booking getBooking(int id) {
        return null;
    }
}
