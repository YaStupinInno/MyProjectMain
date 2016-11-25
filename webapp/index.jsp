<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 20.11.2016
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="error.jsp"%>


<%
    Cookie []cookies = request.getCookies();
    for(Cookie a: cookies) {
        String idCoc =a.getValue();
        String idses = String.valueOf(request.getSession());
        if(idCoc.equals(idses)) {
            RequestDispatcher disp = request.getRequestDispatcher("/myAcc.jsp");
            disp.forward(request, response);
        }
    }
%>

<br>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%! int inc = 0;%>
<% inc++ ;%>
Счетчик загрузок:  <%= inc %>
<br>
Стартовая
<br>
----------------
<form action="actionClic" method="post">
    Login: <input type="text" name="login"/>
    Password:<input type="password" name="password"/>
    <input type="submit" name="enter" value="Login In">
    <input type="submit" name="register" value="Register">
    <br>
    <a href="myServlet">link to hello</a>
</form>
</body>
</html>
