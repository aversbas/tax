package servlet;

import dao.daoImpl.ActionDaoImpl;
import dao.daoImpl.UserActionDaoImpl;
import dao.daoImpl.UserDaoImpl;
import dao.idao.IActionDao;
import dao.idao.IUserActionDao;
import entyties.User;
import org.apache.log4j.Logger;

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
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    Logger log = Logger.getLogger(RegistrationServlet.class);
    UserDaoImpl userDao = new UserDaoImpl();
    IActionDao actionDao = new ActionDaoImpl();
    IUserActionDao userActionDao = new UserActionDaoImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/registration.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        RequestDispatcher rd = req.getRequestDispatcher("/home");
//        rd.forward(req, resp);
//
//        String uname = req.getParameter("userName");
//        String mail = req.getParameter("email");
//        String pass =req.getParameter("password");
////        String hashedPassword = MD5.getMD5(pass);
//        log.info("RegistrationServlet");
//        User user = new User(uname, mail, pass);
//        if(userDao.getUserByUserNameAndPassword(uname, pass)){
//            log.warn("Cannot register, User already exists");
//        }else{
//            //save user in db
//            userDao.save(user);
//            //create action for him
//            Action action = new Action();
//            //save action
//            actionDao.addNewAction(action);
//            //create userAction
//            UserAction userAction = new UserAction();
//            //save userAction
//            userActionDao.createnewUserAction(action);
//            log.info("User registred successfully");
//
//            RequestDispatcher requestDispatcherd = req.getRequestDispatcher("/booking.jsp");
//            requestDispatcherd.forward(req,resp );
//            resp.sendRedirect("/booking");
//        }
//
//        log.info("RegistrationServlet doPost userName: " + uname);
//        log.info("RegistrationServlet doPost mail: " + mail);
//        log.info("RegistrationServlet doPost password: " + pass);



        String username = req.getParameter("userName");
        String mail = req.getParameter("email");
        String password = req.getParameter("password");

        User user = new User();
        userDao.save(user);
        String destPage = "registration.jsp";

        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("userName", username);
            destPage = "home.jsp";
        } else {
            String message = "Invalid email/password";
            req.setAttribute("message", message);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(destPage);
        dispatcher.forward(req, resp);

    }
}