<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: alexm
  Date: 21.09.2019
  Time: 8:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setBundle basename="locales" />
<html>
<head>
    <title>Registration</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/registration" method="post">
    User name:<br>
    <input type="text" name="userName" >
    <br>
    Mail:<br>
    <input type="text" name="mail" >
    <br><br>
    Password:<br>
    <input type="text" name="password" >
    <br><br>
    <input type="submit" value="Submit">

</form>
</body>
</html>
