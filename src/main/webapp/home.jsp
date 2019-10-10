<%--
  Created by IntelliJ IDEA.
  User: alexm
  Date: 19.09.2019
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="locales" />

<html>
<head>
    <title>Home</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">
    //<fmt:message key="hello"/>${sessionScope.get("user")}${param.userName}
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/booking">Book a taxi</a></li>
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/actions">Check my actions</a></li>
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/cars">types of cars</a></li>
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/login">Exit</a></li>
        </ol>
    </nav>
</div>

</body>
</html>
