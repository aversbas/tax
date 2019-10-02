<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>

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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

</head>
<body>

<div class="limiter">
    <div class="container-table100">
        <div class="wrap-table100">
            <div class="table100">

                <div class="container booking">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item">${sessionScope.get("user")} page<a href="${pageContext.request.contextPath}/home">Back</a></li>
                        </ol>
                    </nav>
                    <form method="post" action="${pageContext.request.contextPath}/booking">
                        <div class="form-group">
                            <label for="home">Select where to pick up you</label>
                            <select name="home" id="home">
                                <c:forEach var="street" items="${streets}">
                                    <option><c:out value="${street.name}"/></option>
                                </c:forEach>
                                <%--    <option value="Vokzal">Volvo</option>--%>
                                <%--    <option value="Yunosti">Saab</option>--%>
                                <%--    <option value="Keletska">Mercedes</option>--%>
                                <%--    <option value="Kosmonavtiv">Audi</option>--%>
                            </select>
                        </div>

                        <div class="form-group">
                            <label for="dest">Select where do you want to go</label>
                            <select name="dest" id="dest">
                                <c:forEach var="street" items="${streets}">
                                    <option><c:out value="${street.name}"/></option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group">
                            <label for="cars">Select type of car you want</label>
                            <%--<select name="cars" id="cars">--%>
                            <%--    <c:forEach var="car" items="${carList}">--%>
                            <%--        <option><c:out value="${car.class}"/></option>--%>
                            <%--    </c:forEach>--%>
                            <%--</select>--%>  <%-- MAYBE MAKE TABLE OF AVAILABLE CARS WITH ALL THEIR ATTRIBUTES    -->   OR MAKE RADIO BUTTONS--%>
                        </div>
                        <div class="form-group">
                            <label for="car">    </label>
                            <select name="car" id="car">
                                <c:forEach var= "taxi" items="${taxis}">
                                    <option><c:out value="${taxi.carClass}"/></option>
                                </c:forEach>

                            </select>
                        </div>
                        <input type="submit" value="submit" class="btn btn-primary">
                    </form>
                </div>
                <div class="container">
                    <p class="h4">
                        <span class="badge badge-secondary">Waiting time: </span>
                        <span class="badge badge-warning">${waitingTime} min</span><br/>
                    </p>
                    <p class="h4">
                        <span class="badge badge-secondary">Your last bookings:</span>
                        <%--<c:forEach var="booking" items="${bookingList}">--%>
                        <%--   <c:out value="${booking.startAddress.name}"/>--%>
                        <%--    <c:out value="${booking.endAddress.name}"/>--%>
                        <%--    <c:out value="${booking.taxi.carClass}"/>--%>
                        <%--</c:forEach>--%>
                        <%--ТУТ БУЛИ ДІВИ--%>
                    </p>
                </div>
                <div class="container">
                    <table class="table" width = "100%">
                        <thead>
                        <tr class="table100-head">
                            <th class="column1">from</th>
                            <th class="column2">where</th>
                            <th class="column3">Car type</th>
                        </tr>
                        </thead>
                        <c:forEach var="booking" items="${bookingList}">
                            <tr>
                                <td><c:out value="${booking.startAddress.name}"/></td/>
                                <td><c:out value="${booking.endAddress.name}"/></td>
                                <td><c:out value="${booking.taxi.carType}"/></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
