<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 23.11.2016
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
if (true){

    HttpSession ses = request.getSession();
    String str = request.getParameter("textinput");
    request.setAttribute("textin",str);
    RequestDispatcher disp =  request.getRequestDispatcher("/sesion/swowsessio");
    disp.forward(request, response);
}
%>

<form action="/SessionServlet" method="GET">
    Input: <input type="text" name="textinput"/>
    <input type="submit" name="send" value="next"/>
</form>

</body>
</html>
