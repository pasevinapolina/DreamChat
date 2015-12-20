<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
  <title>Gallery</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <script type="text/javascript" src="../../static/js/jquery-2.1.4.min.js"></script>
  <script type="text/javascript" src="../../static/js/bootstrap.min.js"></script>
  <link href="../../static/css/bootstrap.min.css" rel="stylesheet">
  <link href="../../static/css/style.css" rel="stylesheet">
</head>

<body>

<div class="jumbotron">

  <c:import url="header.jsp"/>
</div>

    <div class="jumbotron">

      <div class="flex-container">
        <table class="table-hover">
          <c:forEach var="playlists" items="${playlists}" varStatus="status">
            <tr class="row">
              <td class="col-md-3 col-md-push-3">
                <audio controls class="audio">
                  <source src="${audios.get(status.index)}">
                  Please <a href="../../static/img/jazz.mp3" download>download</a> the audio file.
                </audio>
              </td>
              <td class="col-md-6"><p class="track-name">${playlists.audioName}</p></td>
              <td class="col-md-9"><p class="track-description" hidden>${playlists.singer}</p></td>
            </tr>
          </c:forEach>
        </table>
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
              <audio controls>
                <source src="" id="audSrc">
              </audio>

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
    </div>

  <c:import url="footer.jsp"/>

</body>
</html>
