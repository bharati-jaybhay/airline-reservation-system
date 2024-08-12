<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Flight</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <jsp:include page="navbar2.jsp"></jsp:include>
    <div class="container">
        <h1 class="my-5">Update Flight</h1>
        <c:if test="${not empty sessionScope.updateMsg}">
            <p class="text-success">${sessionScope.updateMsg}</p>
        </c:if>
        <c:if test="${not empty requestScope.updateMsg}">
            <p class="text-danger">${requestScope.updateMsg}</p>
        </c:if>
        <form action="${pageContext.request.contextPath}/update-flight" method="post">
            <input type="hidden" name="flight_id" value="${flight.flight_id}">
            <div class="mb-3">
                <label for="origin" class="form-label">Origin</label>
                <input type="text" class="form-control" id="origin" name="origin" value="${flight.origin}">
            </div>
            <div class="mb-3">
                <label for="destination" class="form-label">Destination</label>
                <input type="text" class="form-control" id="destination" name="destination" value="${flight.destination}">
            </div>
            <div class="mb-3">
                <label for="departure" class="form-label">Departure</label>
                <input type="text" class="form-control" id="departure" name="departure" value="${flight.departure}">
            </div>
            <div class="mb-3">
                <label for="arrival" class="form-label">Arrival</label>
                <input type="text" class="form-control" id="arrival" name="arrival" value="${flight.arrival}" ">
            </div>
            <button type="submit" class="btn btn-primary">Update</button>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
