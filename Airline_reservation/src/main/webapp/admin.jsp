<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Flight Management</title>
</head>
<body>
    <c:set var="flight" value="${requestScope.flight}" />
    <c:set var="msg" value="${requestScope.msg}" />
    <jsp:include page="navbar2.jsp" />
    <div class="container">
        <div class="text-center my-5">
            <h1>Flight Management System</h1>
            <p class="text-danger">${msg}</p>
        </div>
        <form class="w-75 mx-auto" method="post" action="save-flight">
            <div class="mb-3">
                <label for="flight_id" class="form-label">Flight ID</label>
                <input type="text" class="form-control" id="flight_id" name="flight_id" value="${flight.flight_id}">
            </div>
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
                <input type="datetime-local" class="form-control" id="departure" name="departure" value="<fmt:formatDate value='${flight.departure}' pattern='yyyy-MM-dd\'T\'HH:mm'/>">
            </div>
            <div class="mb-3">
                <label for="arrival" class="form-label">Arrival</label>
                <input type="datetime-local" class="form-control" id="arrival" name="arrival" value="<fmt:formatDate value='${flight.arrival}' pattern='yyyy-MM-dd\'T\'HH:mm'/>">
            </div>
            <button type="submit" class="btn btn-primary">Add Flight</button>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
