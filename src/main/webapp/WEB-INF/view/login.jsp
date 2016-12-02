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

    <form:form method="POST" commandName="user" action="${contextPath}/chekUser" cssClass="features-table">
      <h2 class="form-heading">Войти</h2>

      <form:label path="login">Name:</form:label>
      <form:input path="login" /><br>
      <form:label path="pass">Password:</form:label>
      <form:password path="pass" />


<%--
      <input name="username" type="text" class="form-control" placeholder="Username" autofocus="true"/>
        <input name="password" type="password" class="form-control" placeholder="Password"/>--%>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button><br>
        <h4 class="text-center"><a href="${contextPath}/registration">Registration</a></h4>
    </form:form>

  </div>

  </body>
</html>
