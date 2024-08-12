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
import jakarta.servlet.http.HttpSession;

@WebServlet("/delete-flight")
public class DeleteController extends HttpServlet {

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

        HttpSession session = request.getSession();

        if (flightId == null || flightId.isBlank()) {
            session.setAttribute("deleteMsg", "Flight ID is required for deletion.");
            response.sendRedirect(request.getContextPath() + "/flight-dashboard");
            return;
        }

        try {
            if (flightDAO.searchFlightById(flightId) != null) {
                flightDAO.deleteFlight(flightId);
                session.setAttribute("deleteMsg", "Flight deleted successfully.");
            } else {
                session.setAttribute("deleteMsg", "Flight with ID " + flightId + " does not exist.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("deleteMsg", "An error occurred while deleting the flight.");
        }

        response.sendRedirect(request.getContextPath() + "/flight-dashboard");
    }
}
