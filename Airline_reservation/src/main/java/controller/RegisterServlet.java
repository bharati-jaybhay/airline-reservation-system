package controller;

import java.io.IOException;
import javax.sql.DataSource;
import dao.UserDAO;
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/Add")
public class RegisterServlet extends HttpServlet {
    @Resource(name = "DBconnect")
    private DataSource dataSource;

    private UserDAO dao;

    @Override
    public void init() throws ServletException {
        dao = new UserDAO(dataSource);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("Email");
        String username = request.getParameter("Username");
        String password = request.getParameter("Password");

        User user = new User();
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);

        boolean hasErrors = false;
        if (email.isBlank()) {
            request.setAttribute("msg", "Please enter email");
            hasErrors = true;
        } else if (username.isBlank()) {
            request.setAttribute("msg", "Please enter a username");
            hasErrors = true;
        } else if (password.isBlank()) {
            request.setAttribute("msg", "Password is empty");
            hasErrors = true;
        }

        if (hasErrors) {
            RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
            rd.forward(request, response);
        } else {
            try {
                boolean result = dao.saveData(user);
                HttpSession session = request.getSession();

                if (result) {
                    session.setAttribute("msg", "User saved successfully");
                    response.sendRedirect("view-flights"); 
                } else {
                    session.setAttribute("msg", "Something went wrong");
                    response.sendRedirect("Register.jsp");
                }
            } catch (Exception e) {
                e.printStackTrace();
                RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
                rd.forward(request, response);
            }
        }
    }
}
