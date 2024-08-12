package dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class Test extends HttpServlet {

    @Resource(name = "DBconnect")
    private DataSource dataSource;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection conn = dataSource.getConnection()) {
            System.out.println("Connection object: " + conn);
            PrintWriter out = resp.getWriter();
            
            resp.setContentType("text/html");
            
            out.print("<html><head><title>Test</title></head>");
            out.print("<body><h1>Connection obj: " + conn + "</h1></body></html>");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
