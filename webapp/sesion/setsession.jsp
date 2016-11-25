<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 23.11.2016
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String str = request.getParameter("textinput");

    session.setAttribute("textin",str);
%>


<html>
<head>
    <title>Title</title>
</head>
<body>
 <a href="swowsession.jsp">WHOWSESSION</a>
</body>
</html>
