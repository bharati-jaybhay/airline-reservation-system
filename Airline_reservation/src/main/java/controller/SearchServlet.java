package controller;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import dao.FlightDAO;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Flight;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    @Resource(name = "DBconnect")
    private DataSource dataSource;

    private FlightDAO dao;

    @Override
    public void init() throws ServletException {
        dao = new FlightDAO(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String origin = request.getParameter("searchQuery");
        try {
            List<Flight> flights = dao.searchFlightsByOrigin(origin);
            request.setAttribute("flights", flights);
            request.getRequestDispatcher("userDashboard.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
