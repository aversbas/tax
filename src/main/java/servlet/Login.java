package servlet;

import service.authorization.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by alexm on 18.09.2019.
 */
@WebServlet(name = "Login", urlPatterns = "/login.do")
public class Login extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/webapp/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LoginService service = new LoginService();

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        boolean isValidUser = service.validateUser(name, password);

        if (isValidUser) {
            request.setAttribute("name", name);
            request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Invalid Credentials!!");
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        }
    }
}
