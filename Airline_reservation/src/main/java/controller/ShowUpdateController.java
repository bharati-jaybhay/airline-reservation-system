package controller;

import java.io.IOException;

import javax.sql.DataSource;

import dao.FlightDAO;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Flight;

@WebServlet("/show-update")
public class ShowUpdateController extends HttpServlet {

    @Resource(name = "DBconnect")
    private DataSource dataSource;

    private FlightDAO flightDAO;

    @Override
    public void init() throws ServletException {
        flightDAO = new FlightDAO(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flightId = request.getParameter("flight_id");

        if (flightId == null || flightId.isBlank()) {
            response.sendRedirect(request.getContextPath() + "/flight-dashboard");
            return;
        }

        try {
            Flight flight = flightDAO.searchFlightById(flightId);
            if (flight != null) {
                request.setAttribute("flight", flight);
                request.getRequestDispatcher("update-flight.jsp").forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/flight-dashboard");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/flight-dashboard");
        }
    }
}
