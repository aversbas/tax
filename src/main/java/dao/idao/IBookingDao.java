package dao.idao;

import entyties.Booking;
import entyties.User;

import java.util.List;

/**
 * Created by alexm on 20.09.2019.
 */
public interface IBookingDao {
    public void book(Booking booking);
    public void cancelBook(Booking booking);
    public List<Booking> getAllBookings(User user);
    public Booking getBooking(int id);
}
