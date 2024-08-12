package controller;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import dao.FlightDAO;
import model.Flight;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/flight-dashboard")
public class DashboardController extends HttpServlet {

    @Resource(name = "DBconnect")
    private DataSource dataSource;

    private FlightDAO flightDAO;

    @Override
    public void init() throws ServletException {
        flightDAO = new FlightDAO(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Flight> flights = flightDAO.getAllFlights();
            request.setAttribute("flights", flights);
            request.getRequestDispatcher("flight-dashboard.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}
