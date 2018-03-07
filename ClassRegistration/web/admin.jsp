<%-- 
    Document   : admin
    Created on : Feb 26, 2018, 11:13:09 PM
    Author     : Sean Cox
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>School Administration Page</title>
    </head>
    <body>
        <h1>Hello ${person.firstName} ${person.lastName}</h1>
        <p style="color: red;">${message}</p>
        <p>Pick a class to remove (must have no students or professors registered):</p>
        <form action="manage" method="post">
            <input type="hidden" name="action" value="deletecourse">
            <c:forEach items="${courses}" var="course">
                <input type="radio" name="course" value="${course.id}">${course.id}: ${course.name}<br>
            </c:forEach>
            <label>&nbsp;</label>
            <input type="submit" value="Submit">
        </form>
        <p>Pick a class to create:</p>
        <form action="manage" method="post">
            <input type="hidden" name="action" value="addcourse">
            Course ID: <input type="text" size="10" required="true" name="courseid" value="${courseid}"/><br/>
            Course Name: <input type="text" size="60" required="true" name="coursename" value="${coursename}"/><br/>
            Course Description: <textarea name="coursedescription" required="true">${coursedescription}</textarea><br/>
            Course Hours: <input type="text" size="4" inputmode="numeric" required="true" name="coursehours" value="${coursehours}"/><br/>
            <label>&nbsp;</label>
            <input type="submit" value="Submit">
        </form>
        &nbsp;
        <form action="manage" method="post">
            <input type="hidden" name="action" value="logoff">
            <input type="submit" value="Log Out">
        </form>
    </body>
</html>
