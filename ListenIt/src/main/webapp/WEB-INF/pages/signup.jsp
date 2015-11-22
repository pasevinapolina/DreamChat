<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
  <head>
    <title>Signup</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="/static/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="/static/css/style.css" rel="stylesheet"/>
  </head>

  <body>
    <script src="/static/js/home.js"></script>

    <div class="jumbotron">

      <c:import url="header.jsp"/>

      <div class="page-header">
        <h2>Join us</h2>
      </div>

      <div class="row">
        <div class="col-md-4 col-md-offset-4">

          <c:url var="signup_url" value="/register"/>

          <form:form modelAttribute="user" action="${signup_url}" method="post">
            <spring:bind path="username">

              <div class="form-group">
                <form:label path="username">Username</form:label>
                <form:input path="username" type="text" class="form-control"
                            placeholder="Username"/>
              </div>

              <div class="form-group">
                <form:label path="password">Password</form:label>
                <form:input type="password" class="form-control" placeholder="Password"
                            path="password"/>
              </div>

              <div class="form-group">
                <form:label path="matchingPassword">Confirm password</form:label>
                <form:input path="matchingPassword" value="" class="form-control"
                            type="password" placeholder="Confirm Password" />
              </div>

              <button class="btn btn-primary btn-block" type="submit">Sign up</button>

              <div class="form-group" style="margin-top: 24px;">
                <form:errors path="username" class="form-group">
                  <div class="alert alert-danger" role="alert">
                    <b>Sorry! </b>User with such name already exists
                  </div>
                </form:errors>
              </div>

            </spring:bind>
          </form:form>

        </div>
      </div>
    </div>

    <c:import url="footer.jsp"/>
  </body>
</html>

