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
    <title>404.Page Not found</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <style>
        body {
            background: url(http://i.piccy.info/i9/55c2bf31e9c4bd885c55ecbb068f3530/1523017061/343058/1235287/150036a2c2b5.jpg) no-repeat fixed center;
            background-size: 100%;
        }

        .navbar-brand {
            font-family: "Berlin Sans FB";
            font-size: x-large;
        }

        #box {
            left: 40%;
            margin: auto;
            position: absolute;
            top: 30%;
            color: aliceblue;
        }

        .footer {
            position: fixed;
            left: 0;
            bottom: 0;
            width: 100%;
            background-color: black;
            color: gray;
            text-align: center;
            font-size: x-small;
        }
    </style>
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
