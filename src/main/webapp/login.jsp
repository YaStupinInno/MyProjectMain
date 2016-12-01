<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
  <head>
    <title>Main</title>
    <link href="${contextPath}/resources/style.css" rel="stylesheet">
  </head>
  <body>

  <div class="container">

    <form method="POST" action="${contextPath}/login" class="form-signin">
      <h2 class="form-heading">Войти</h2>
        <input name="username" type="text" class="form-control" placeholder="Username" autofocus="true"/>
        <input name="password" type="password" class="form-control" placeholder="Password"/>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
        <h4 class="text-center"><a href="${contextPath}/registration">Кegistration</a></h4>
    </form>

  </div>

  </body>
</html>
