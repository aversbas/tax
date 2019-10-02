package servlet;

import dao.daoImpl.StreetDaoImpl;
import dao.daoImpl.UserDaoImpl;
import dao.idao.IStreetDao;
import dao.idao.IUserDao;
import entyties.Street;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by alexm on 21.09.2019.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    Logger log = Logger.getLogger(LoginServlet.class);
    private IUserDao userDaoImpl = new UserDaoImpl();
    private IStreetDao streetDao = new StreetDaoImpl();

    // ResourceBundle bundle = ResourceBundle.getBundle("locales", new Locale(Locale.US.getLanguage()));
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

//        System.out.println("DEFAULT LOCALE USER IS: " + req.getLocale().getDisplayLanguage());
//        System.out.println("DEFAULT LOCALE USER IS: " + req.getLocale().getCountry());
//        ResourceBundle bundle = ResourceBundle.getBundle("locales", req.getLocale());
//        resp.setLocale(bundle.getLocale());
//        req.setAttribute("language", req.getLocale().getLanguage());



        RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
        rd.forward(req, resp);


    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        //This receives when come from registration page
//        RequestDispatcher rd = req.getRequestDispatcher("/view/login.jsp");
//        rd.forward(req, resp);



        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
//        String hashedPassword = MD5.getMD5(password);
        req.setAttribute("userName", userName);
        req.setAttribute("password",password);
        if(userDaoImpl.getUserByUserNameAndPassword(userName, password)){
            log.info("Login Success");
            HttpSession session = req.getSession();
            session.setAttribute("user", userName);
            List<Street> streets = streetDao.getAllStreets();
            req.setAttribute("streets", streets);
            //RequestDispatcher rd = req.getRequestDispatcher("/view/home.jsp");

            RequestDispatcher rd = req.getRequestDispatcher("/home");
            rd.forward(req, resp);
        }else{
            log.warn("Cannot login");

            resp.sendRedirect("/login.jsp");
        }
    }
}
