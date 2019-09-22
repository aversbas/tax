<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<%--
  Created by IntelliJ IDEA.
  User: alexm
  Date: 21.09.2019
  Time: 8:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setBundle basename="locales" />

<html>
<head>
    <title>Booking</title>
    <%--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/util.css">--%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">

</head>
<body>

<div class="limiter">
    <div class="container-table100">
        <div class="wrap-table100">
            <div class="table100">

                ${sessionScope.get("user")} page
                <a href="${pageContext.request.contextPath}/home">Back</a>



                <form method="post" action="${pageContext.request.contextPath}/booking">

                    Select where to pick up you
                    <select name="home">

                        <c:forEach var="street" items="${streets}">
                            <option><c:out value="${street.name}"/></option>
                        </c:forEach>
                        <%--    <option value="Vokzal">Volvo</option>--%>
                        <%--    <option value="Yunosti">Saab</option>--%>
                        <%--    <option value="Keletska">Mercedes</option>--%>
                        <%--    <option value="Kosmonavtiv">Audi</option>--%>
                    </select>

                    Select where do you want to go
                    <select name="dest">

                        <c:forEach var="street" items="${streets}">
                            <option><c:out value="${street.name}"/></option>
                        </c:forEach>
                    </select>

                    Select type of taxi you want
                    <%--<select name="taxis">--%>
                    <%--    <c:forEach var="taxi" items="${carList}">--%>
                    <%--        <option><c:out value="${taxi.class}"/></option>--%>
                    <%--    </c:forEach>--%>
                    <%--</select>--%>  <%-- MAYBE MAKE TABLE OF AVAILABLE CARS WITH ALL THEIR ATTRIBUTES    -->   OR MAKE RADIO BUTTONS--%>

                    <select name="carClass">

                        <c:forEach var="taxi" items="${taxis}">
                            <option><c:out value="${taxi.carClass}"/></option>
                        </c:forEach>
                    </select>

                    </select>
                    <input type="submit" value="submit">
                </form>

                Waiting time:${waitingTime} min<br/>

                Your last bookings:
                <%--<c:forEach var="booking" items="${bookingList}">--%>
                <%--   <c:out value="${booking.home.name}"/>--%>
                <%--    <c:out value="${booking.dest.name}"/>--%>
                <%--    <c:out value="${booking.taxi.carClass}"/>--%>
                <%--</c:forEach>--%>


                <%--ТУТ БУЛИ ДІВИ--%>

                <table border = "1" width = "100%">
                    <thead>
                    <tr class="table100-head">
                        <th class="column1">from</th>
                        <th class="column2">where</th>
                        <th class="column3">Car type</th>
                    </tr>
                    </thead>
                    <c:forEach var="booking" items="${bookingList}">
                        <tr>
                            <td><c:out value="${booking.home.name}"/></td/>
                            <td><c:out value="${booking.dest.name}"/></td>
                            <td><c:out value="${booking.taxi.carType}"/></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>

</body>
</html>
