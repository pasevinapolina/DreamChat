<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>About</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link href="static/css/bootstrap.min.css" rel="stylesheet">
  <link href="static/css/style.css" rel="stylesheet">
</head>

<body>

  <div class="jumbotron">

    <c:import url="header.jsp"/>

    <div class="container">

      <div class="row">
        <div class="col-md-12">
          <h2 class="page-header">About Us
            <small>It's Nice to Meet You!</small>
          </h2>
          <p>It’s easy to find the right music for every moment – on your phone, your computer, your tablet and more.</p>
        </div>
      </div>

      <div class="row">
        <div class="col-md-12">
          <h2 class="page-header"><b>Service and Support</b></h2>
        </div>
        <hr>

        <div class="col-md-4 col-sm-6 text-center">
          <img class="img-circle img-responsive img-center" src="../../static/img/help.jpg" alt="">
          <h3><b>Help site</b></h3>
          <p>Help us to learn more about your tastes. ListenIt tries to become better for you!</p>
        </div>

        <div class="col-md-4 col-sm-6 text-center">
          <img class="img-circle img-responsive img-center" src="../../static/img/contact.jpg" alt="">
          <h3><b>Contact form</b></h3>
          <p>If you cannot find any solution to the problem with our website, and would like to contact ListenIt Customer Support, you can submit a query using the contact form.</p>
        </div>

        <div class="col-md-4 col-sm-6 text-center">
          <img class="img-circle img-responsive img-center" src="../../static/img/inspire.jpg" alt="">
          <h3><b>We’re here to inspire</b></h3>
          <p>Our team wishes you to listen to music you love</p>
        </div>

      </div> <!--row-->
    </div> <!--container-->
  </div>

  <c:import url="footer.jsp"/>

</body>
</html>
