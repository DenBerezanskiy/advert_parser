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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <style>
        body {
            background: url(http://i.piccy.info/i9/55c2bf31e9c4bd885c55ecbb068f3530/1523017061/343058/1235287/150036a2c2b5.jpg) no-repeat fixed center;
            background-size: 100%;
        }
        .navbar-brand
        {
            font-family: "Berlin Sans FB";
            font-size: x-large;
        }
        .register {
            margin-top: 10%;
            margin-left: 35%;
            margin-right: 35%;
            background-color: rgba(214, 214, 194, 0.5);
            border-radius: 3%;

        }

        .register-form {
            width: 50%;
            margin: auto;
        }
        #confirmButton
        {
            background-color: rgba(0, 0, 0,0.7);
        }
        ::-webkit-input-placeholder {
            font-style: italic;
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

<div class="register">
    <form class="register-form">
        <table>
            <tr>
                <label>Username:</label>
                <input class="form-control" id="username" name="username" placeholder="Username">
            </tr>
            <tr>
                <label>Password:</label>
                <input class="form-control" id="password" name="password" placeholder="Password">
            </tr>
            <tr>
                <label>Email:</label>
                <input class="form-control" id="email" name="email" placeholder="Email">
            </tr>
            <tr>
                <label>Phone number:</label>
                <input class="form-control" id="phone" name="phone" placeholder="Phone number">
            </tr>
            <tr>
                <td>
                    <input class="btn btn-outline-success" type="submit" id="confirmButton" value="Register">
                </td>
            </tr>
        </table>
    </form>
</div>


<div class="footer">
    <p>All rights reserved. Advert Parser 2018 :)</p>
</div>
</body>
</html>
