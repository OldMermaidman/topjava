<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <title>Meals</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>
<table border="1">
    <tbody>
    <tr>
        <td><b>Date</b></td>
        <td><b>Description</b></td>
        <td><strong>Calories</strong></td>
        <td></td>
        <td></td>
    </tr>
    <c:forEach var="mealsTo" items="${mealsTo}">
        <tr
                <c:choose>
                    <c:when test="${mealsTo.excess eq true}">
                        style="color:red;"
                    </c:when>
                    <c:when test="${mealsTo.excess eq false}">
                        style="color:green;"
                    </c:when>
                </c:choose>
        >
            <td>${localDateTimeFormat.format(mealsTo.dateTime)}</td>
            <td>${mealsTo.description}</td>
            <td>${mealsTo.calories}</td>
            <td>Update</td>
            <td>Delete</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
