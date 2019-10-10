package dao.idao;

import entyties.Booking;
import entyties.User;

import java.util.List;

/**
 * Created by alexm on 20.09.2019.
 */
public interface IBookingDao {
    /**
     * @param booking
     */
    public void book(Booking booking);

    /**
     * @param booking
     */
    public void cancelBook(Booking booking);

    /**
     * @param user
     * @return
     */
    public List<Booking> getAllBookings(User user);

    /**
     * @param id
     * @return
     */
    public Booking getBooking(int id);
}
