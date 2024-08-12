<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Flight Dashboard</title>
</head>
<body>
    <jsp:include page="navbar2.jsp"></jsp:include>
    <div class="container mt-4">
        <h1>Flight Dashboard</h1>

        <!-- Display success or error messages -->
        <c:if test="${not empty sessionScope.msg}">
            <p class="text-success">${sessionScope.msg}</p>
        </c:if>
        <c:if test="${not empty requestScope.msg}">
            <p class="text-danger">${requestScope.msg}</p>
        </c:if>

        <!-- Display data in a read-only table -->
        <table class="table table-dark table-striped">
            <thead>
                <tr>
                    <th scope="col">Flight ID</th>
                    <th scope="col">From</th>
                    <th scope="col">To</th>
                    <th scope="col">Departure</th>
                    <th scope="col">Arrival</th>
                    <th scope="col">Book Now</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="flight" items="${flights}">
                    <tr>
                        <td>${flight.id}</td>
                        <td>${flight.origin}</td>
                        <td>${flight.destination}</td>
                        <td><fmt:formatDate value="${flight.departure}" pattern="yyyy-MM-dd HH:mm" /></td>
                        <td><fmt:formatDate value="${flight.arrival}" pattern="yyyy-MM-dd HH:mm" /></td>
                        <td href="book.jsp">Book</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

       
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
