import dao.daoImpl.UserDaoImpl;
import org.junit.Before;
import org.junit.Test;
import servlet.BookingServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.mockito.Mockito.*;

public class BookingServletTest extends UserDaoImpl {
    private BookingServlet bookingServlet;

    @Before
    public void setUp(){
        this.bookingServlet = new BookingServlet();
    }

    @Test
    public void doGet() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        session.setAttribute("user", "user");
        when(request.getParameter("user")).thenReturn("user");

        bookingServlet.doGet(request, response);

        verify(request, atLeast(1)).getParameter("user");

    }

    @Test
    public void doPost() {
    }
}
