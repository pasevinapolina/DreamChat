<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Listen It</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link href="webjars/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet"/>
  <link href="webjars/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="../../css/style.css" rel="stylesheet"/>
</head>

<body>
  <script src="webjars/bootstrap/3.3.5/js/bootstrap.js"></script>
  <script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  <script src=""></script>

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
                          <button class="btn btn-default" onclick="showModal()">Login</button>
                      </div>
                      <div class="col-md-1">
                          <p><a href="#">Sign up</a></p>
                      </div>
                  </div>
              </div>
          </div><!--/.navbar-collapse -->

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
