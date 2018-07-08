<%--
  Created by IntelliJ IDEA.
  User: UlpJuan
  Date: 8.07.2018
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome to view user page</title>
</head>
<body>

<h1>User Information</h1>

<h3> <strong>NAME </strong> ${viewUser.userName}</h3>
<br>
<p> <strong>SURNAME </strong>  ${viewUser.userSurname}</p>
<br>
<p>
    <strong>PASSWORD </strong> : ${viewUser.password}
</p>
<br>

    <strong>ADDRES </strong> : ${viewUser.addres}
</p>
<br>
<p>
    <strong>ID </strong> : ${viewUser.userID}


    <br>

    <a href="/admin/listUser"> <strong>Back to List of User </strong> </a>
</body>
</html>
