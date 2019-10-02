
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alexm
  Date: 19.09.2019
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setBundle basename="locales"/>
<html>
<head>
    <title>Cars</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/home">Back</a></li>
        </ol>
    </nav>


    <p class="h4">
        <span class="badge badge-secondary">Cars that we have:</span>
    </p>
    <table class="table">
        <tr>
            <th>car class</th>
        </tr>
        <c:forEach var="car" items="${taxis}">
            <tr>
                <td><c:out value="${car.carClass}"/>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>