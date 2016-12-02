<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>

<form:form method="POST" commandName="user" action="${contextPath}/users/add" cssClass="features-table">
    <h2 class="form-heading">Registration</h2>

    <form:label path="login">Login:</form:label>
    <form:input path="login" /><br>

    <form:label path="pass">Password:</form:label>
    <form:password path="pass" /><br>

    <form:label path="nameFull">Name:</form:label>
    <form:input path="nameFull" /><br>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Registration</button><br>
</form:form>


</body>
</html>
