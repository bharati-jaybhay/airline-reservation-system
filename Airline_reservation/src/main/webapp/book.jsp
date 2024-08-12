<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" 
    rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
    crossorigin="anonymous">

    <title>Tickets</title>
    <style>
        .table-container {
            width: 50%;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ddd;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            background-color: #f9f9f9;
        }
        body {
            background-image: url('sits2.jpg');
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
        }
    </style>
</head>
<body>
    <jsp:include page="navbar2.jsp"></jsp:include>
    <br><br>
    <div class="table-container">
    
        <table class="table table-striped table-hover table-bordered">
            <thead>
                <tr class="table-danger">
                    <th scope="col">Economy</th>
                    <th scope="col">Premium Economy</th>
                    <th scope="col">Business</th>
                    <th scope="col">First Class</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-currency-rupee" viewBox="0 0 16 16">
  <path d="M4 3.06h2.726c1.22 0 2.12.575 2.325 1.724H4v1.051h5.051C8.855 7.001 8 7.558 6.788 7.558H4v1.317L8.437 14h2.11L6.095 8.884h.855c2.316-.018 3.465-1.476 3.688-3.049H12V4.784h-1.345c-.08-.778-.357-1.335-.793-1.732H12V2H4z"/>
</svg>5000/person</td>
                    <td><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-currency-rupee" viewBox="0 0 16 16">
  <path d="M4 3.06h2.726c1.22 0 2.12.575 2.325 1.724H4v1.051h5.051C8.855 7.001 8 7.558 6.788 7.558H4v1.317L8.437 14h2.11L6.095 8.884h.855c2.316-.018 3.465-1.476 3.688-3.049H12V4.784h-1.345c-.08-.778-.357-1.335-.793-1.732H12V2H4z"/>
</svg>5500/person</td>
                    <td><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-currency-rupee" viewBox="0 0 16 16">
  <path d="M4 3.06h2.726c1.22 0 2.12.575 2.325 1.724H4v1.051h5.051C8.855 7.001 8 7.558 6.788 7.558H4v1.317L8.437 14h2.11L6.095 8.884h.855c2.316-.018 3.465-1.476 3.688-3.049H12V4.784h-1.345c-.08-.778-.357-1.335-.793-1.732H12V2H4z"/>
</svg>6500/person</td>
                    <td><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-currency-rupee" viewBox="0 0 16 16">
  <path d="M4 3.06h2.726c1.22 0 2.12.575 2.325 1.724H4v1.051h5.051C8.855 7.001 8 7.558 6.788 7.558H4v1.317L8.437 14h2.11L6.095 8.884h.855c2.316-.018 3.465-1.476 3.688-3.049H12V4.784h-1.345c-.08-.778-.357-1.335-.793-1.732H12V2H4z"/>
</svg>7000/person</td>
                </tr>
                <tr>
                    <td><strong>Baggage</strong><br>- &Kgs Cabin baggage <br> -15 Kgs Check-in baggage
                    <br> <strong>Seats, Meals,More</strong> <br>- Chargeable Seats <br>- Chargeable Meals
                    </td>
                    
                    <td> <strong>Baggage</strong><br>- &Kgs Cabin baggage <br> -15 Kgs Check-in baggage
                    <br> <strong>Seats, Meals,More</strong> <br>- Chargeable Seats <br>- Chargeable Meals 
                    <br><strong>Flexibility:</strong><br>- Free date change 
                    </td>
                    
                    <td><strong>Baggage</strong><br>- &Kgs Cabin baggage <br> -15 Kgs Check-in baggage
                    <br><strong>Seats, Meals,More</strong>  <br>- Free Seats <br>- Compliementary Meals
                    <br><strong>Flexibility:</strong> <br>- Free date change <br>-Lower Cancellation Fees
                    </td>
                    
                    <td> <strong>Baggage</strong></br>- &Kgs Cabin baggage <br> -15 Kgs Check-in baggage
                    <br> <strong>Seats, Meals,More</strong> <br>- Chargeable Seats <br>- Chargeable Meals
                    <br><strong>Flexibility:</strong> <br>- Free date change <br>-Lower Cancellation Fees
                    <br><strong>Exclusive Benefits</strong><br>Free Priority Boarding
                    <br>-Free deployment and lost baggage Protection service
                    </td>
                </tr>
                <tr>
                    <td><a href="payment.jsp"><button type="button" class="btn btn-info">Book Now</button></a></td>
                    <td><a href="payment1.jsp"><button type="button" class="btn btn-info">Book Now</button></a></td>
                    <td><a href="payment2.jsp"><button type="button" class="btn btn-info">Book Now</button></a></td>
                    <td><a href="payment3.jsp"><button type="button" class="btn btn-info">Book Now</button></a></td>
                </tr>
            </tbody>
        </table>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" 
    crossorigin="anonymous"></script>
</body>
</html>
