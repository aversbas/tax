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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/demo.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/component.css" />
</head>
<body>

//<fmt:message key="hello"/>${param.userName}
<section class="color-0">
    <nav class="cl-effect-1">
        <a href="${pageContext.request.contextPath}/booking">Book a taxi</a>
        <a href="${pageContext.request.contextPath}/actions">Check my actions</a>
        <a href="${pageContext.request.contextPath}/cars">types of taxis</a>
        <a href="${pageContext.request.contextPath}/login">Exit</a>
    </nav>
</section>
</body>
</html>
