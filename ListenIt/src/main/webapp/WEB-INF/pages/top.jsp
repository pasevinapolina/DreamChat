<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Top List</title>
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

  <div class="player">
    <audio controls="controls">
      Your browser does not support the <code>audio</code> element.
      <source src="http://online-radiorelax.tavrmedia.ua/RadioRelax_Nature?63" type="audio/wav">
    </audio>
  </div>


  <div class="gallery">
    <div class="flex-container">
      <c:forEach var="topPlaylists" items="${playlists}" varStatus="status">
        <div class="flex">

          <div class="thumbnail">
            <div class="flex-image">
              <img src="${audios.get(status.index)}" class="image-link">
            </div>
          </div>


          <div class="image-description">
            <div class="panel panel-info">
              <div class="panel-heading">${topPlaylists.audioName}</div>
              <div class="panel-body">
                  ${topPlaylists.audioDescription}
              </div>
            </div>
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
            <span class="modal-title" id="playlistName"></span>
          </div>
          <div class="modal-body">
            <img class="modal-image" src="">
            <div class="like">
              <span class="glyphicon like-span" id="id-like"></span>
              <span class="audioId" hidden></span>
            </div>
          </div>

          <div class="panel panel-default">
            <div class="panel-heading" id="playlistDescription"></div>
            <ul class="list-group" id="comments">
            </ul>
          </div>

          <div class="modal-footer">
            <form id="commentValid">
              <div class="controls">
                            <textarea id="commentSrc"
                                      name="commentArea" class="form-control required" rows="3"
                                      placeholder="Less than 600 characters" maxlength="600"></textarea>
              </div>
              <div class="controls">
                <button type="submit" id="btn-add" class="btn btn-primary">Add Comment</button>
              </div>
            </form>
          </div>
        </div>

      </div>
    </div>
  </div>


  <c:import url="footer.jsp"/>

</body>
</html>
