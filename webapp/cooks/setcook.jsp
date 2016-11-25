<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 23.11.2016
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String login = request.getParameter("login");

    Cookie cookie = new Cookie("login", login);
    cookie.setMaxAge(365*24*60*60);
    response.addCookie(cookie);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <a href="showcooki.jsp"> show cooc...</a>
</body>
</html>
