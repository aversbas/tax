<%--
  Created by IntelliJ IDEA.
  User: alexm
  Date: 18.09.2019
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="<%=request.getLocale()%>"/>

<fmt:setBundle basename="locales" />

<html>
<head>
    <title>Login</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container login-wrapper">
    <h3><span class="badge badge-secondary">Please login or register:</span></h3>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <div class="form-group">
            <label for="exampleInputEmail1"><fmt:message key="loginName"/></label>

            <input type="text" name="userName" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter name">
        </div>

        <div class="form-group">
            <label for="exampleInputEmail1"><fmt:message key="userPassword"/></label>
            <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
        </div>

        <div class="form-group">
            <input type="submit" value="Login" class="btn btn-primary btn-block">
        </div>


    </form>
    <form action="${pageContext.request.contextPath}/registration.jsp" method="post">
        <input type="submit" value="registration" class="btn btn-secondary btn-block">
    </form>
</div>
<div class="shadow"></div>

</body>
</html>
