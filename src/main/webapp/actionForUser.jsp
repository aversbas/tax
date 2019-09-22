
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
</head>
<body>
<a href="${pageContext.request.contextPath}/home">Back</a>
Your action account: ${action} ₴ available for discount

<p>If your wasted total sum is more than 20 then your discount will automaticly be used for new booking,
    else you will just be collecting money for discount</p>
</body>
</html>
