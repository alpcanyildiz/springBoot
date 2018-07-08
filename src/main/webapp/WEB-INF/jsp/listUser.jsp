<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: UlpJuan
  Date: 7.07.2018
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome to user list</title>
</head>
<body>

<a href="${pageContext.request.contextPath}/admin/addUser"> Add Person </a>

<div>
    <table>

        <tr>

            <th>User ID </th>
            <th>User Name </th>
            <th>User Surname </th>
            <th>User Password </th>
            <th>User Addres </th>

        </tr>
        <c:forEach var="user" items="${users}">
            <tr>


                <td>${user.userID}</td>
                <td>${user.userName}</td>
                <td>${user.userSurname}</td>
                <td>${user.password}</td>
                <td>${user.addres}</td>
                <td><a href="<spring:url value="viewUser?userID=${user.userID}"/>"
                > View</a>
                    <a href="<spring:url value="deleteUser?userID=${user.userID}" />"
                    >Delete</a>
                    <a href="<spring:url value="editUser?userID=${user.userID}" />"
                    >Edit</a>

                    <a class="button" href="${pageContext.request.contextPath}/personList?deletePerson=${person.personID}" Sil />
                </td>
                <br> <br>
            </tr>

        </c:forEach>

    </table>
</div>
</body>
</html>
