<%@ page contentType="text/html; charset-UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>HTML Header</title>
</head>
<body>
<h2>HTML Header</h2>
<table width="100%" border="1" align="center">
    <tr bgcolor="#949494">
        <th>Header name</th>
        <th>Header value</th>
    </tr>

    <c:forEach items="${header.keySet()}" var="headerName">
        <tr>
            <td><c:out value="${headerName}"/></td>
            <td><c:out value="${header.get(headerName)}"/></td>
        </tr>
    </c:forEach>
</table>
</body>

</html>