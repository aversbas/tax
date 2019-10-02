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

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container login-wrapper">
    <h3><span class="badge badge-secondary">Please register:</span></h3>
    <form action="${pageContext.request.contextPath}/registration" method="post">
        <div class="form-group">
            <label for="userName">User name:</label>
            <input type="text" name="userName" id="userName" class="form-control">
        </div>
        <div class="form-group">
            <label for="mail">Mail:</label>
            <input type="email" name="mail" id="mail" class="form-control">
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" name="password" id="password" class="form-control">
        </div>
        <div class="form-group">
            <input type="submit" value="Submit" class="btn btn-primary btn-block">
        </div>
    </form>
</div>

</body>
</html>
