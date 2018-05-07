<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 06.04.2018
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${status} Advert Parser</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet"  type="text/css" href="/resources/css/style.css">
    <link rel="icon" type="image/x-icon" href="http://i.piccy.info/i9/705e61dcb89f22f8ad1765de4d65cd95/1523253577/6265/1235287/icon.png">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</head>
<body>
<div class="navbar-container">
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">

        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="navbar-brand" href="/">
                    Advert Parser
                </a>
            </li>
        </ul>
    </nav>
</div>
<div id="box">
    <h1 >
    ${status}
    ${reason}
    </h1>

</div>
<div class="footer">
    <p>All rights reserved. Advert Parser 2018 :)</p>
</div>
</body>
</html>
