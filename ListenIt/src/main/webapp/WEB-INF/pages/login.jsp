<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script type="text/javascript" src="../../static/js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="../../static/js/bootstrap.min.js"></script>
    <link href="../../static/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../static/css/style.css" rel="stylesheet">
</head>

<body>

<div class="jumbotron">

    <c:import url="header.jsp"/>

    <div class="page-header">
        <h2>Login</h2>
    </div>
    <div class="row">
        <div class="col-md-4 col-md-push-4">

            <c:url var="loginUrl" value="/j_spring_security_check"/>

            <form action="${loginUrl}" method="POST">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" class="form-control" id="username"
                           name="username" required autofocus/>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password"
                           name="password" required/>
                </div>

                <button type="submit" class="btn btn-primary" id="signup-submit">Login</button>

                <c:if test="${not empty error}">
                    <div class="form-group" style="margin-top: 24px;">
                        <div class="alert alert-danger" role="alert">
                            <b>Oops! </b>Wrong user name or password
                        </div>
                    </div>
                </c:if>

            </form>
        </div>
    </div>
</div>

<c:import url="footer.jsp"/>

</body>
</html>
