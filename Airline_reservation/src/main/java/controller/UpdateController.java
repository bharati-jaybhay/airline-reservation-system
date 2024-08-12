package controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.sql.DataSource;
import dao.FlightDAO;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Flight;

@WebServlet("/update-flight")
public class UpdateController extends HttpServlet {

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
            response.sendRedirect("flight-dashboard");
            return;
        }

        try {
            Flight flight = flightDAO.searchFlightById(flightId);
            request.setAttribute("flight", flight);
            request.getRequestDispatcher("update-flight.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("flight-dashboard");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flightId = request.getParameter("flight_id");
        String origin = request.getParameter("origin");
        String destination = request.getParameter("destination");
        String departureStr = request.getParameter("departure");
        String arrivalStr = request.getParameter("arrival");

        if (flightId == null || flightId.isBlank() || origin == null || origin.isBlank() ||
            destination == null || destination.isBlank() || departureStr == null || departureStr.isBlank() ||
            arrivalStr == null || arrivalStr.isBlank()) {
            request.setAttribute("msg", "All fields are required.");
            request.getRequestDispatcher("update-flight.jsp").forward(request, response);
            return;
        }

        try {
            Timestamp departure = Timestamp.valueOf(departureStr);
            Timestamp arrival = Timestamp.valueOf(arrivalStr);

            Flight flight = new Flight();
            flight.setFlight_id(flightId);
            flight.setOrigin(origin);
            flight.setDestination(destination);
            flight.setDeparture(departure);
            flight.setArrival(arrival);

            boolean result = flightDAO.updateFlight(flight);

            if (result) {
                request.getSession().setAttribute("msg", "Flight updated successfully");
            } else {
                request.getSession().setAttribute("msg", "Flight update failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.getSession().setAttribute("msg", "Error updating flight");
        }

        response.sendRedirect(request.getContextPath() + "/flight-dashboard");
    }
}
