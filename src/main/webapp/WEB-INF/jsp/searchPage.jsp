<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Advert Parser</title>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="icon" type="image/x-icon" href="http://i.piccy.info/i9/705e61dcb89f22f8ad1765de4d65cd95/1523253577/6265/1235287/icon.png">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="resources/js/disableButton.js"></script>
</head>
<body>
<div class="navbar-container">
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">

        <!-- Links -->
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="navbar-brand" href="/">Advert Parser</a>
            </li>
        </ul>
    </nav>
</div>
<div class="info-container">
    <h1>Get Started</h1>
    <p>To begin using parser: just insert into input olx search link and click the "submit" button</p>
</div>
<div class="search-container">
    <form class="form-inline  input-group col-md-12 " method="get">
        <input class="form-control" type="text" id="searchInput" name="inputField" placeholder="Search">
        <input type="submit" class="btn btn-outline-success" id="searchConfirmButton" disabled="disabled" method="get" placeholder="Submit"/>
    </form>
</div>
<div id="alert_placeholder"></div>
<div class="footer">
    <p>All rights reserved. Advert Parser 2018 :)</p>
</div>
</body>
</html>