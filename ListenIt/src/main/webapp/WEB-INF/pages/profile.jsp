<!--
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Profile</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <script type="text/javascript" src="../../static/js/jquery-2.1.4.min.js"></script>
  <script type="text/javascript" src="../../static/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="../../static/js/add_audio.js"></script>
  <link href="../../static/css/bootstrap.min.css" rel="stylesheet">
  <link href="../../static/css/style.css" rel="stylesheet">
</head>
<body>

<div class="jumbotron">

  <c:import url="header.jsp"/>

  <div class="page-header">
    <h2>Music</h2>
  </div>
//
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
//
    <div class="my-audio-table">
      <div class="container">
        <div class="panel panel-default">


          <div class="panel-heading">Your Playlist</div>
          <table class="table table-striped">
            <thead>
            <tr>
              <th>Name</th><th>Audio</th><th>Description</th><th>Year</th><th>Edit</th><th>Delete</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach var="audio" items="${audio}" varStatus="status">
              <tr>
                <td>${audio.audioName}</td>

                <td><div class="td-audio">
                  <audio controls>
                    <source src="${audio.audioFile}">
                  </audio>
                  <img src="${audio.get(status.index)}">
                </div></td>

                <td><textarea class="form-control" rows="5" readonly>${audio.audioDescription}
                </textarea></td>

                <td>${audio.year}</td>

                <td><a data-toggle="modal" data-target="#updateModel" class="glyphicon glyphicon-edit
                            image-upd" id="updatePlaceBtn"></a>
                  <span id="plName" hidden>${audio.audioName}</span>
                  <span id="plDescr" hidden>${audio.audioDescription}</span>
                  <span id="plSrc" hidden>${myPhoto.get(status.index)}</span>
                  <span id="plId" hidden>${myAudio.get(status.index).id}</span>
                </td>
                <td>
                  <a href="/myPhotos/${audio.id}/delete"
                     class="glyphicon glyphicon-remove"
                     onclick="return confirm('Are you sure you want to delete?')"></a>
                </td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
        <div class="container">
          <button type="button" class="btn btn-primary" data-toggle="modal"
                  data-target="#myModal" id="newAudioBtn">
            Add new audio
          </button>
        </div>
      </div>
    </div>


    <div class="modal-container">
      <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal">&times;</button>
              <h4 class="modal-title">New Audio</h4>
            </div>
            <form action="<c:url value="/myAudios"/>" method="POST" enctype="multipart/form-data" id="newAudioForm">
              <div class="modal-body">

                <div class="form-group">
                  <label for="name">Name</label>
                  <input class="form-control" id="name" name="name" placeholder="Audio name">
                </div>

                <div class="form-group">
                  <label for="descr">Description</label>
                            <textarea id="descr" class="form-control" rows="5"
                                      name="description" placeholder="Less than 600 characters"
                                      maxlength="600"></textarea>
                </div>

                <div class="form-group">
                  <label for="inputFile">Choose audio file</label>
                  <input type="file" name="audioFile" id="inputFile" accept="image/jpeg, image/png, image/gif">
                  <p class="help-block">Choose audio file</p>
                </div>

              </div>
              <div class="modal-footer">
                <button type="submit" class="btn btn-primary"><a class="glyphicon-plus"></a>Add</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>


    <div class="modal-container">
      <div class="modal fade" id="updateModel" role="dialog">
        <div class="modal-dialog">
          <div class="modal-content">

            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal">&times;</button>
              <h4 class="modal-title">Update Audio</h4>
            </div>
            <form action="<c:url value="/myAudios"/>" method="POST" enctype="multipart/form-data"
                  id="updateAudioForm">

              <div class="modal-body">
                <div class="form-group">
                  <label for="name">Name</label>
                  <input class="form-control" id="nameUpd" name="name" placeholder="Audio name">
                </div>
                <div class="form-group">
                  <label for="descr">Description</label>
                            <textarea id="descrUpd" class="form-control" rows="5"
                                      name="description" placeholder="Less than 600 charactes"></textarea>
                </div>

                <div class="form-group">
                  <div class="td-image" ><audio src="" id="audioSrcDesr"/></div>
                </div>

                <div class="form-group">
                  <label for="inputFile">Choose file</label>
                  <input type="file" name="audioFile" id="inputFileUpd" accept="audio/ogg audio/wav ">
                  <p class="help-block">Update your audio</p>
                </div>
              </div>

              <div class="modal-footer">
                <button type="submit" class="btn btn-primary">Update</button>
              </div>
            </form>

          </div>
        </div>
      </div>
    </div>
<%--<c:import url="footer.jsp"/>

</body>
</html>
-->
