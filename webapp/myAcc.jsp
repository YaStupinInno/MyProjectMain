<%@ page import="ru.innopolis.*" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="menu.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
 Личный кабинет<br>
Привет
 <% HttpSession ses = request.getSession();
     User user = (User) ses.getAttribute("user");
 %>
 <%=user.getName()%>

<%--<% User user = (User) request.getAttribute("user");%>
 <%=user.getName()%>--%>

</body>
</html>
