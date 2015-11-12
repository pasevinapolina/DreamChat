<html>
<head>
    <title>Listen It</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script type="text/javascript" src="static/js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="static/js/bootstrap.min.js"></script>
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/style.css" rel="stylesheet">
</head>

<body>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">

    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>

        <div class="navbar-collapse collapse">
            <div class="navbar-form navbar-right">
                <div class="container">
                    <div class="col-md-10">
                        <a class="navbar-brand" href="#">Listen It</a>
                    </div>
                    <div class="col-md-1">
                        <a href="#loginModal" role="button" class="btn" data-toggle="modal">Login</a>
                    </div>
                    <div class="col-md-1">
                        <p><a  role="button" class="btn" href="WEB-INF/pages/signup.jsp">Sign up</a></p>
                    </div>
                </div>
            </div>
        </div><!--/.navbar-collapse -->

    </div>
</div>

<div id="homePageCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#homePageCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#homePageCarousel" data-slide-to="1"></li>
        <li data-target="#homePageCarousel" data-slide-to="2"></li>
    </ol>

    <div class="carousel-inner">

        <div class="item active">
            <img src="static/img/bg-sunset.jpg" alt="Sunset" class="img-responsive">
            <div class="container">
                <div class="carousel-caption">
                    <h2>Create your mood.</h2>
                    <p>Express yourself with mixtapes. Change tracklist, background and mood of them. Create mixtapes tailored to your quirks</p>
                    <p><a class="btn btn-lg btn-primary" href="#" role="button">Sign up today</a></p>
                </div>
            </div>
        </div>

        <div class="item">
            <img src="static/img/bg-crowd.jpg" alt="Crowd" class="img-responsive">
            <div class="container">
                <div class="carousel-caption">
                    <h2>You are unique.</h2>
                    <p>Rock? Classical? Or indie? Choose your favourite</p>
                    <p><a class="btn btn-lg btn-primary" href="#" role="button">Discover</a></p>
                </div>
            </div>
        </div>

        <div class="item">
            <img src="static/img/bg-mountain.jpg" alt="Mountain" class="img-responsive">
            <div class="container">
                <div class="carousel-caption">
                    <h2>We love good music.</h2>
                    <p>Login and get all the options.</p>
                    <p><a class="btn btn-lg btn-primary" href="#" role="button">Login</a></p>
                </div>
            </div>
        </div>

    </div>

    <a class="carousel-control left" href="#homePageCarousel" data-slide="prev">
        <span class="icon-prev"></span>
    </a>

    <a class="carousel-control right" href="#homePageCarousel" data-slide="next">
        <span class="icon-next"></span>
    </a>

</div><!-- /.carousel -->

<!-- Modal -->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="loginModalLabel">Login</h4>
            </div>
            <div class="modal-body">
                ...
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Login</button>
            </div>
        </div>
    </div>
</div>

<div class="navbar navbar-fixed-bottom" role="navigation">
    <div class="container">
        <div class="row">
            <div class="col-md-2">
                <p><a href="#">Contuct us</a></p>
            </div>
            <div class="col-md-2">
                <p><a href="#">About</a></p>
            </div>
            <div class="col-md-8" align="right">
                <p>&copy; ListenIt 2015</p>
            </div>
        </div>
    </div>
</div>

</body>
</html>

