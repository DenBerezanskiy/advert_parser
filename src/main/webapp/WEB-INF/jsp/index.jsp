<!DOCTYPE HTML>
<html>
<head>
    <title>Advert Parser</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
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
        .search-container
        {
            position: absolute;
            top: 50%;
            margin: -50px 0 0 0;
            width: 100%;
        }
        .info-container
        {
            margin-top: 100px;
            text-align: center;
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

            <!-- Links -->
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="navbar-brand" href="/">Advert Parser</a>
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
            <h1>Get Started</h1>
            <p>To begin using parser: just insert into input olx search link and click the "submit" button</p>
        </div>
        <div class="search-container">
            <form class="form-inline  input-group col-md-12 " method="post" name="searchForm" action="obtainSearchLink" onsubmit="return validateForm()" method="post">
                <input class="form-control" type="url" name="searchLink" placeholder="Search">
                <button type="button" class="btn btn-outline-success">Submit</button>
            </form>
        </div>
        <div id="alert_placeholder"></div>
        <div class="footer">
            <p>All rights reserved. Advert Parser 2018 :)</p>
        </div>
<script>
    function validateForm() {
        var inputValue = document.forms["searchForm"]["searchLink"].value;
        if(inputValue.indexOf("")>=0)
        {
            alert("Wrong url");
//            $('#alert_placeholder').html('<div class="alert alert-danger alert-dismissible fade show"><button type="button" class="close" data-dismiss="alert">&times;</button>Search link is not valid!</div>')
        }
    }

</script>
</body>
</html>