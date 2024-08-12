package controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.sql.DataSource;

import dao.FlightDAO;
import model.Flight;
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/save-flight")
public class FlightController extends HttpServlet {

    @Resource(name = "DBconnect")
    private DataSource dataSource;

    private FlightDAO flightDAO;

    @Override
    public void init() throws ServletException {
        flightDAO = new FlightDAO(dataSource);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flightIdStr = request.getParameter("flight_id");
        String origin = request.getParameter("origin");
        String destination = request.getParameter("destination");
        String departureStr = request.getParameter("departure");
        String arrivalStr = request.getParameter("arrival");

        if (flightIdStr.isBlank() || origin.isBlank() || destination.isBlank() || departureStr.isBlank() || arrivalStr.isBlank()) {
            request.setAttribute("msg", "All fields are required.");
            request.getRequestDispatcher("admin.jsp").forward(request, response);
            return;
        }

        String flightId;
        Timestamp departure = null, arrival = null;
        try {
            flightId = flightIdStr;

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.getDefault());
            departure = new Timestamp(dateFormat.parse(departureStr).getTime());
            arrival = new Timestamp(dateFormat.parse(arrivalStr).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            request.setAttribute("msg", "Invalid date format. Please check your entries.");
            request.getRequestDispatcher("admin.jsp").forward(request, response);
            return;
        }

        Flight flight = new Flight();
        flight.setFlight_id(flightId);
        flight.setOrigin(origin);
        flight.setDestination(destination);
        flight.setDeparture(departure);
        flight.setArrival(arrival);

        try {
            boolean result = flightDAO.insertFlight(flight);
            HttpSession session = request.getSession();

            if (result) {
                session.setAttribute("msg", "Flight saved successfully");
            } else {
                session.setAttribute("msg", "Something went wrong");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "Database error occurred.");
            request.getRequestDispatcher("admin.jsp").forward(request, response);
            return;
        }

        response.sendRedirect(request.getContextPath() + "/flight-dashboard");
    }
}
