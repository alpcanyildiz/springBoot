<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: UlpJuan
  Date: 8.07.2018
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome to Add User Page !</title>
</head>
<body>
<div>
    <h2>Welcome to Add Person page</h2>


    <a href="${pageContext.request.contextPath}/admin/listUser"> Cancel </a>

</div>

<form:form action="${pageContext.request.contextPath}/admin/addUser/" method="post" modelAttribute="user">

    <div class="form-group">
        <label for="UserName">Name</label>
        <form:input path="userName" id="userName" class="form-Control"/>
    </div>


    <div class="form-group">
        <label for="UserSurname">Surname</label>
        <form:input path="userSurname" id="userSurname" class="form-Control"/>
    </div>


    <div class="form-group">
        <label for="Password">Password</label>
        <form:input path="password" id="password" class="form-Control"/>
    </div>

    <div class="form-group">
        <label for="Adress">Adress</label>
        <form:input path="addres" id="addres" class="form-Control"/>
    </div>

    <input type="submit" value="Submit"/>



</form:form>




</body>
</html>
