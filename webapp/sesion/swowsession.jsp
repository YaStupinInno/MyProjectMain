<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 23.11.2016
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String val = (String)session.getAttribute("textin");
%>


<html>
<head>
    <title>Title</title>
</head>
<body>
 Session: <%= val%>
</body>
</html>
