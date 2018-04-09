<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%><!DOCTYPE HTML>
<html>
<head>
    <title>Advert Parser</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/x-icon" href="http://i.piccy.info/i9/705e61dcb89f22f8ad1765de4d65cd95/1523253577/6265/1235287/icon.png">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

    <style>
        body
        {
            background: url(http://i.piccy.info/i9/55c2bf31e9c4bd885c55ecbb068f3530/1523017061/343058/1235287/150036a2c2b5.jpg) no-repeat fixed center;
            background-size: 100%;
        }
        .info-container
        {
            margin-top: 100px;
            margin-bottom: 50px;
            text-align: center;
        }
        .card
        {
            background-color: rgba(214, 214, 194,0.5);
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
    <%--<nav class="navbar navbar-expand-sm bg-dark navbar-dark">--%>
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">

        <!-- Links -->
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="navbar-brand" href="/">
                    <!--<img src="https://a.radikal.ru/a34/1804/8c/b87049588f93.jpg"/>-->
                    Advert Parser
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/welcome">
                    Search
                    <!--for demonstrate numbers of adverts-->
                    <span class="badge badge-light">4</span></a>
            </li>
        </ul>
    </nav>
</div>

<div class="info-container">
    <h1>Adverts list :</h1>
</div>
<%--<table class="table">--%>
    <%--<tbody>--%>
    <%--<tr>--%>
        <%--<td>--%>
            <%--<div class="card">--%>
                <%--<div class="card-body">--%>
                    <%--<h4 class="card-title">Advert title</h4>--%>
                    <%--<p class="card-text">Blablabla</p>--%>
                    <%--<button type="button" class="btn btn-outline-success">--%>
                        <%--<a href="#" class="card-link"/>Go</button>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</td>--%>
    <%--</tr>--%>
    <%--</tbody>--%>
<%--</table>--%>
${message}

<div class="footer">
    <p>All rights reserved. Advert Parser 2018 :)</p>
</div>
</body>
</html>
