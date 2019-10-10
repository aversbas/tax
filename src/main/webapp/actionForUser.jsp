
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: alexm
  Date: 21.09.2019
  Time: 8:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setBundle basename="locales" />
<html>
<head>
    <title>Your Actions</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item">${sessionScope.get("user")}<a href="${pageContext.request.contextPath}/home">Back</a></li>
        </ol>
    </nav>

    <p class="h4">
        <span class="badge badge-secondary">Your action account:</span> ${action} ₴ available for discount
    </p>

    <p>If your wasted total sum is more than 20 then your discount will automaticly be used for new booking,
        else you will just be collecting money for discount</p>
</div>

</body>
</html>