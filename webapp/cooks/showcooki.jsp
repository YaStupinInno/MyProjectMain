<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 23.11.2016
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    String nameCookie = "login";
    Cookie []cookies = request.getCookies();
    Cookie cook = null;
    for(Cookie a: cookies){
        String cookie = a.getName();
        if(cookie.equals(nameCookie)){
            cook = a;
            break;
        }


    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<% if(cook != null){%>
    value :<%= cook.getValue() %>
<%} else  {%>
    no kook
<%}%>

</body>
</html>
