<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>My Audio</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <script type="text/javascript" src="../../static/js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="../../static/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../../static/js/add_audio.js"></script>
    <link href="../../static/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../static/css/style.css" rel="stylesheet">
</head>

<body>

<div class="jumbotron">
    <c:import url="header.jsp"/>


    <div class="my-audio-table">
        <div class="container">
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading">Your Playlist</div>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Singer</th>
                        <th>Audio</th>
                        <th>Description</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach var="audioObj" items="${playlists}" varStatus="status">
                        <tr>
                            <td>${audioObj.audioName}</td>
                            <td>${audioObj.singer}</td>
                            <td>
                                <div class="td-image"><img src="${audios.get(status.index)}"></div>
                            </td>
                            <td><textarea class="form-control" rows="5" readonly>${audioObj.audioDescription}</textarea>
                            </td>

                            <td><a data-toggle="modal" data-target="#updateModel" class="glyphicon glyphicon-edit
                            image-upd" id="updatePlaceBtn"></a>
                                <span id="plDescr" hidden>${audioObj.audioDescription}</span>
                                <span id="plSrc" hidden>${audios.get(status.index)}</span>
                                <span id="plId" hidden>${playlists.get(status.index).id}</span>
                            </td>

                            <td>
                                <a href="/myAudios/${audioObj.id}/delete"
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
                        data-target="#myModal" id="newPlaceBtn">
                    Add new Track
                </button>
            </div>
        </div>
    </div>
</div>


<div class="modal-container">
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">

                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">New Track</h4>
                </div>

                <form action="<c:url value="/myAudiosNew"/>" method="POST" enctype="multipart/form-data" id="addAudioForm">
                    <div class="modal-body">

                        <div class="form-group">
                            <label for="audioName">Audio name</label>
                            <input class="form-control" id="audioName" name="audioName" placeholder="Track name">
                        </div>

                        <div class="form-group">
                            <label for="singer">Singer</label>
                            <input class="form-control" id="singer" name="singer" placeholder="Singer">
                        </div>

                        <div class="form-group">
                            <label for="descr">Description</label>
                            <textarea id="descr" class="form-control" rows="5" name="audioDescription"
                                      placeholder="Less than 600 characters" maxlength="600"></textarea>
                        </div>

                        <div class="form-group">
                            <label for="audioFile">Choose file</label>
                            <input type="file" name="audioFile" id="audioFile" accept="image/jpeg, image/png, image/gif">

                            <p class="help-block">Choose audio file</p>
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary">Add</button>
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
                    <h4 class="modal-title">Update Track</h4>
                </div>

                <form action="<c:url value="/myAudios"/>" method="POST" enctype="multipart/form-data"
                      id="updatePlaceForm">

                    <div class="modal-body">
                        <div class="form-group">
                            <label for="nameUpd">Audio Name</label>
                            <input class="form-control" id="nameUpd" name="audioName" placeholder="Track name">
                        </div>

                        <div class="form-group">
                            <label for="singerUpd">Singer</label>
                            <input class="form-control" id="singerUpd" name="singer" placeholder="Singer">
                        </div>

                        <div class="form-group">
                            <label for="descr">Description</label>
                            <textarea id="descrUpd" class="form-control" rows="5"
                                      name="audioDescription" placeholder="Less than 600 characters"></textarea>
                        </div>

                        <div class="form-group">
                            <div class="td-image"><img src="" id="imageSrcDesr"></div>
                        </div>

                        <div class="form-group">
                            <label for="inputFileUpd">Choose file</label>
                            <input type="file" name="audioFile" id="inputFileUpd"
                                   accept="image/jpeg, image/png, image/gif">

                            <p class="help-block">Update audio file</p>
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary">Apply</button>
                    </div>
                </form>

            </div>
        </div>
    </div>
</div>

<c:import url="footer.jsp"/>

</body>
</html>
