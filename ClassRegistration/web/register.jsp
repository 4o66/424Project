<%-- 
    Document   : register
    Created on : Feb 26, 2018, 11:12:56 PM
    Author     : Sean Cox
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello ${person.firstName} ${person.lastName}</h1>
        <p>Pick a class to drop:</p>
        <form action="enroll" method="post">
            <input type="hidden" name="action" value="drop">
            <c:forEach items="${person.courses}" var="course">
                <input type="radio" name="course" value="${course.id}">${course.id}: ${course.name}<br>
            </c:forEach>
            <label>&nbsp;</label>
            <input type="submit" value="Submit">
        </form>
        <p>Pick a class to add:</p>
        <form action="enroll" method="post">
            <input type="hidden" name="action" value="add">
            <c:forEach items="${courses}" var="course">
                <input type="radio" name="course" value="${course.id}">${course.id}: ${course.name}<br>
            </c:forEach>

            <label>&nbsp;</label>
            <input type="submit" value="Submit">
        </form>
        &nbsp;
        <form action="enroll" method="post">
            <input type="hidden" name="action" value="logoff">
            <input type="submit" value="Log Out">
        </form>
    </body>
</html>
