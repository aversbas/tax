
import dao.daoImpl.UserDaoImpl;
import org.junit.Before;
import org.junit.Test;
import servlet.LoginServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.mockito.Mockito.*;

public class LoginServletTest extends UserDaoImpl {
    private LoginServlet loginServlet;

    @Before
    public void setUp(){
        this.loginServlet = new LoginServlet();
    }

    @Test
    public void doGet() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        final ServletContext servletContext = mock(ServletContext.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        when(servletContext.getRequestDispatcher("/login.jsp")).thenReturn(dispatcher);

        loginServlet.doGet(request,response);

        verify(dispatcher).forward(request,response); //dispatcher.forward(request,response);

    }

    @Test
    public void doPost() throws ServletException, IOException {
//        HttpServletRequest request = mock(HttpServletRequest.class);
//        HttpServletResponse response = mock(HttpServletResponse.class);
//        HttpSession session = mock(HttpSession.class);
//        session.setAttribute("user", "vova");
//        when(request.getSession()).thenReturn(session);
//
//
//
//        when(request.getParameter("userName")).thenReturn("vova");
//        when(request.getParameter("password")).thenReturn("pass");
//
//        new LoginServlet().doPost(request, response);
//
//        verify(request, atLeast(1)).getParameter("vova");
//        verify(request, atLeast(1)).getParameter("pass");

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        HttpSession session = mock(HttpSession.class);
        session.setAttribute("user", "Petryk");
        when(request.getSession()).thenReturn(session);

        when(request.getParameter("userName")).thenReturn("Petryk");
        when(request.getParameter("password")).thenReturn("Petryk");

        final ServletContext servletContext = mock(ServletContext.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        when(servletContext.getRequestDispatcher("/home")).thenReturn(dispatcher);

        loginServlet.doPost(request, response);



        verify(response).sendRedirect("/login.jsp");
    }

    @Test(expected = NullPointerException.class)
    public final void testDoPostPositive() throws ServletException, IOException {
        loginServlet.doPost(null, null);
    }

}
