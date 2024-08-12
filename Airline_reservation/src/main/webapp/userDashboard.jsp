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
    <style>
        body {
            background-image: url('maps.jpg');
            background-size: cover;
            background-attachment: fixed;
            background-position: center;
            background-repeat: no-repeat;
        }
        .container {
            background-color: rgba(255, 255, 255, 0.8); 
            padding: 20px;
            border-radius: 8px;
            margin-top: 40px;
            backdrop-filter: blur(10px); /
        }
        h1 {
            color: #333;
        }
        table {
            background-color: rgba(255, 255, 255, 0.5); 
        }
    </style>
</head>
<body>
    <jsp:include page="navbar3.jsp"></jsp:include>
    <div class="container mt-4">
        <h1>Flight Dashboard</h1>
        <c:if test="${not empty flights}">
            <table class="table table-striped table-hover">
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
                            <td>${flight.flight_id}</td>
                            <td>${flight.origin}</td>
                            <td>${flight.destination}</td>
                            <td><fmt:formatDate value="${flight.departure}" pattern="yyyy-MM-dd HH:mm" /></td>
                            <td><fmt:formatDate value="${flight.arrival}" pattern="yyyy-MM-dd HH:mm" /></td>
                            <td>
                                <a href="book.jsp">
                                    <button type="button" class="btn btn-primary">Book</button>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <c:if test="${empty flights}">
            <p>No flights found.</p>
        </c:if>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
