<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Advert Parser</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/x-icon"
          href="http://i.piccy.info/i9/705e61dcb89f22f8ad1765de4d65cd95/1523253577/6265/1235287/icon.png">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet"  type="text/css" href="/resources/css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</head>
<body>
<div class="navbar-container">
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">

        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="navbar-brand" href="/">
                    Advert Parser
                </a>
            </li>
        </ul>
    </nav>
</div>
<div class="input-container">
    <form class="input-from" method="get" action="/registerUser">
        <table>
            <tr>
                <label>Username:</label>
                <input class="form-control" id="username" name="username" placeholder="Username">
            </tr>
            <tr>
                <span style="color: red">${userMessage}<br></span>
            </tr>
            <tr>
                <label>Password:</label>
                <input class="form-control" id="password" name="password" placeholder="Password">
            </tr>
            <tr>
                <span  style="color: red">${passMessage}<br></span>
            </tr>
            <tr>
                <label>Email:</label>
                <input class="form-control" id="email" name="email" placeholder="Email">
            </tr>
            <tr>
                <span  style="color: red">${emailMessage}<br></span>
            </tr>
            <tr>
                <label>Phone number:</label>
                <input class="form-control" id="phone" name="phone" placeholder="Phone number">
            </tr>
            <tr>
                <span  style="color: red">${phoneMessage}<br></span>
            </tr>
            <tr>
                <td>
                    <input class="btn btn-outline-success" type="submit" id="confirmButton" value="Register" action="/registerUser">
                </td>
            </tr>
        </table>
        <tr>
            <span>${existsMessage}</span>
        </tr>
    </form>
</div>


<div class="footer">
    <p>All rights reserved. Advert Parser 2018 :)</p>
</div>

</body>
</html>
