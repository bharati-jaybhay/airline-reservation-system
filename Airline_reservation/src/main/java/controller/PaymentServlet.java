package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/process-payment")
public class PaymentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cardNumber = request.getParameter("cardNumber");
        String expiryDate = request.getParameter("expiryDate");
        String cvv = request.getParameter("cvv");

        boolean paymentSuccess = processPayment(cardNumber, expiryDate, cvv);

        if (paymentSuccess) {
            response.sendRedirect("payment-success");
        } else {
            response.sendRedirect("payment-failure");
        }
    }

    private boolean processPayment(String cardNumber, String expiryDate, String cvv) {
     
        return cardNumber != null && expiryDate != null && cvv != null && 
               !cardNumber.isEmpty() && !expiryDate.isEmpty() && !cvv.isEmpty();
    }
}
