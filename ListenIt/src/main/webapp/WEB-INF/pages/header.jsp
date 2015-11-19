<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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
            <a class="navbar-brand" href="/welcome">Listen It</a>
          </div>

          <c:url var="signup_link" value="/signup"/>
          <c:url var="login_link" value="/login"/>
          <c:url var="logout_link" value="/j_spring_security_logout"/>
          <sec:authorize access="isAnonymous()">
            <div class="col-md-1">
              <a role="button" class="navbar-btn btn btn-primary" href="${signup_link}">Sign Up</a>
            </div>
            <div class="col-md-1">
              <a role="button" class="navbar-btn btn btn-primary login-button" href="${login_link}">Log In</a>
            </div>
          </sec:authorize>
          <sec:authorize access="isAuthenticated()">
            <div class="col-md-1">
              <span class="label label-default">${sessionScope.user}</span>
            </div>
            <div class="col-md-1">
              <a role="button" class="navbar-btn btn btn-primary" href="${logout_link}">Log Out</a>
            </div>
          </sec:authorize>

        </div>
      </div>
    </div><!--/.navbar-collapse -->

  </div>
</div>

