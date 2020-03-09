<%@ page import="web.model.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User Page</title>
</head>
<body>

    <table width="100%" cellspacing="0" cellpadding="4">
    <c:forEach var="list" items="${user}">
        <tr>
            <td></td>
            <td>User Information</td>
        </tr>
        <tr>
            <td align="right" width="100">Id:</td>
            <td>${list.id}</td>
        </tr>
        <tr>
            <td align="right" width="100">username:</td>
            <td>${list.username}</td>
        </tr>
        <tr>
            <td align="right" width="100">Password:</td>
            <td>${list.password}</td>
        </tr>
        <tr>
            <td align="right" width="150">User Roles:</td>
            <td> <c:forEach items="${list.roles}" var="role">${role.toString()}<br/></c:forEach></td>
        </tr>

        </tr>
    </c:forEach>
    </table>
    <jsp:include page="user-logout.jsp"/>
</body>
</html>
