<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  UserEntity: UlpJuan
  Date: 8.07.2018
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Werlcome to Edit User Page</title>
</head>
<body>
<h1>Welcome to the edit page</h1>


<form:form action="${pageContext.request.contextPath}/admin/editUser" method="post" modelAttribute="editUser">

    <form:hidden path="userId" id="userId" value="${editUser.userId}" />

    <div class="form-group">
        <label for="name">Name</label>
        <form:input path="userName" id="name"  value="${editUser.userName}"  placeholder="Name"></form:input>
    </div>


    <div class="form-group">
        <label for="surname">Surname</label>
        <form:input path="userSurname" id="surname"  value="${editUser.userSurname}" placeholder="Surname"></form:input>
    </div>


    <div class="form-group">
        <label for="age">Password</label>
        <form:input path="password" id="age"  value="${editUser.password}" class="form-Control" placeholder="Password"></form:input>
    </div>


    <div class="form-group">
        <label for="age">Adress</label>
        <form:input path="addres" id="age"  value="${editUser.addres}" class="form-Control" placeholder="Adress"></form:input>
    </div>


    <input type="submit" value="Edit"/>
</form:form>

</body>
</html>
