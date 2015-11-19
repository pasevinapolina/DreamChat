<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Profile</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link href="static/css/bootstrap.min.css" rel="stylesheet">
  <link href="static/css/style.css" rel="stylesheet">
</head>
<body>

<div class="jumbotron">

  <c:import url="header.jsp"/>

  <div class="page-header">
    <h2>Music</h2>
  </div>

  <div class="row">
    <div class="col-6 col-sm-6 col-lg-4">
      <audio controls>
        <source src="../../static/img/jazz.ogg" type="audio/ogg">
        <source src="../../static/img/jazz.mp3" type="audio/mpeg">
          Please <a href="../../static/img/jazz.mp3" download>download</a> the audio file.
      </audio>
    </div>
  </div>

</div>

<c:import url="footer.jsp"/>

</body>
</html>
