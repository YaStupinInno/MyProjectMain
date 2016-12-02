<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 02.12.2016
  Time: 1:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
Мой кабинет<br>
Привет ${user.getNameFull()}<br>

<h4><a href="${contextPath}/loginOut">loginOut</a></h4>
</body>
</html>
