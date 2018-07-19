<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  UserEntity: UlpJuan
  Date: 7.07.2018
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome to userEntity list</title>
</head>
<body>

<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>

    </c:if>

</div>

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
        <c:forEach var="userEntity" items="${userEntities}">
            <tr>


                <td>${userEntity.userID}</td>
                <td>${userEntity.userName}</td>
                <td>${userEntity.userSurname}</td>
                <td>${userEntity.password}</td>
                <td>${userEntity.addres}</td>
                <td><a href="<spring:url value="viewUser/${userEntity.userId}"/>"
                > View</a>
                    <a href="<spring:url value="deleteUser/${userEntity.userId}" />"
                    >Delete</a>
                    <a href="<spring:url value="editUser/${userEntity.userId}" />"
                    >Edit</a>
                </td>
                <br> <br>
            </tr>

        </c:forEach>

    </table>
</div>
</body>
</html>
