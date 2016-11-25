<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 22.11.2016
  Time: 9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/RegisterClient" method="POST">
        Login: <input type="text" name="login" />
        Pasword: <input type="password" name="password" />
        First name: <input type="text" name="firstName" />
        Last name: <input type="text" name="lastName" />
        <input type="submit" name="register" value="Registration"/>
    </form>



</body>
</html>
