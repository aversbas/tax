package servlet;

import dao.daoImpl.TaxiDaoImpl;
import dao.idao.ITaxiDao;
import entyties.Taxi;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by alexm on 19.09.2019.
 */
@WebServlet("/cars")
public class ShowCarsServlet extends HttpServlet {

    ITaxiDao taxiDao = new TaxiDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Taxi> taxis = taxiDao.getAllCars();

        req.setAttribute("taxis", taxis);
        RequestDispatcher rd = req.getRequestDispatcher("/showcars.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
