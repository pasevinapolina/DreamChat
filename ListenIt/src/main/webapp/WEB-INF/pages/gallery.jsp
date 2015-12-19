<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
  <title>Gallery</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link href="static/css/bootstrap.min.css" rel="stylesheet">
  <link href="static/css/style.css" rel="stylesheet">
  <script src="webjars/jquery/2.1.4/jquery.min.js"></script>
  <script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>

<body>

<div class="jumbotron">

  <c:import url="header.jsp"/>

    <div class="gallery">
      <div class="flex-container">
        <c:forEach var="playlist" items="${playlist}" varStatus="status">

          <div class="flex1">
            <div class="thumbnail">
              <img src="${audios.get(status.index)}" class="image-link">
              <span class="image-name" hidden>${playlist.name}</span>
              <span class="image-description" hidden>${playlist.description}</span>
            </div>
          </div>
        </c:forEach>
      </div>
    </div>

    <div class="container modal-container">
      <!-- Modal -->
      <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">
          <!-- Modal content-->
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal">&times;</button>
              <span class="modal-title"></span>
            </div>
            <div class="modal-body">
              <img class="modal-image" src="">
              <div class="like">
                <span class="glyphicon like-span" id="id-like"></span>
                <span class="audioId" hidden></span>
              </div>
            </div>
            <div class="modal-footer">
              <span class="modal-description"></span>
            </div>
          </div>

        </div>
      </div>



      <c:import url="footer.jsp"/>
</div>

</body>
</html>
