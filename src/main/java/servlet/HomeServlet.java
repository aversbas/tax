package servlet;

import dao.daoImpl.TaxiDaoImpl;
import dao.daoImpl.StreetDaoImpl;
import dao.idao.ITaxiDao;
import dao.idao.IStreetDao;
import entyties.Taxi;
import entyties.Street;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by alexm on 21.09.2019.
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    Logger log = Logger.getLogger(HomeServlet.class);
    IStreetDao streetDao = new StreetDaoImpl();
    ITaxiDao taxiDao = new TaxiDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/home.jsp");
        rd.forward(req, resp);
        // comment top 2 strings

        String userName = req.getParameter("userName");
        req.setAttribute("userName", userName);
        log.info("HomeServlet: doGet" + userName);

        List<Street> streets = streetDao.getAllStreets();
        req.setAttribute("streets", streets);

        List<Taxi> taxis = taxiDao.getAllAvailableCars();
        req.setAttribute("taxis", taxis);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/home.jsp");
        rd.forward(req, resp);

        String userName = req.getParameter("userName");
        log.info("HomeServlet: doPost " + userName);
        String password = req.getParameter("password");
        log.info("HomeServlet: doPost " + password);
        //try this
        req.setAttribute("userName", userName);
    }
}
