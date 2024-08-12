package controller;

import java.io.IOException;
import java.util.List;
import javax.sql.DataSource;
import dao.UserDAO;
import dao.FlightDAO; // Add this import statement for the FlightDAO
import model.Flight; // Add this import statement for the Flight model
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Resource(name = "DBconnect")
    private DataSource dataSource;

    private UserDAO userDAO;
    private FlightDAO flightDAO; 

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO(dataSource);
        flightDAO = new FlightDAO(dataSource); 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            checkUser(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void checkUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null || username.trim().isEmpty()) {
            request.setAttribute("status", "invalid Username");
            returnLoginForm(request, response);
        } else if (password == null || password.trim().isEmpty()) {
            request.setAttribute("status", "invalid password");
            returnLoginForm(request, response);
        } else {
            boolean isValidUser = userDAO.findUser(username, password);
            if (isValidUser) {
                
                request.getSession().setAttribute("username", username);

                List<Flight> flights = flightDAO.getAllFlights();

                request.setAttribute("flights", flights);

                RequestDispatcher dispatcher = request.getRequestDispatcher("userDashboard.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("status", "invalid credentials");
                returnLoginForm(request, response);
            }
        }
    }

    private void returnLoginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        rd.forward(request, response);
    }
}
