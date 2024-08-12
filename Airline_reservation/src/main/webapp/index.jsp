<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
    crossorigin="anonymous">
<style>
    .bg-std {
        background-size: cover;
        background-repeat: no-repeat;
        background-position: center;
        height: 100vh;
        position: relative;
    }
    .centered-text {
        color: black;
        text-align: center;
        margin-top: 5%;
        font-style: italic;
       
    }
    .button-container {
        position: absolute;
        top: 40%;
        left: 10%;
        display: flex;
        gap: 20px;
    }
    .custom-btn {
        padding: 10px 20px;
        margin-top:100%;
        color: black;
    }
    .custom-btn:hover {
        background-color: white;
        color: blue;
    }
</style>
<title>Airlines</title>
</head>
<body style="background-image:url('plane3.jpg')" class="bg-std">

<jsp:include page="navbar.jsp"></jsp:include>
<div class="container">
    <div class="centered-text">
        <h1>Welcome to Indian Airlines.</h1>
    </div>
</div>

<div class="button-container">
    <a class="btn btn-lg btn-outline-dark custom-btn" href="Register.jsp">Register</a>
    <a class="btn btn-lg btn-outline-dark custom-btn" href="login.jsp">Login</a>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
    crossorigin="anonymous"></script>
</body>
</html>
