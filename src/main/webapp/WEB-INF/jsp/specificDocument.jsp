<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: yildiza
  Date: 7/17/2018
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>  Account Document Page</h1>

<strong> Account ID : ${accountInformation}</strong>

<br> <br>

<strong> Documents of : ${timeInformation}</strong>

<br> <br>

<c:forEach var="document" items="${documentbyID}">
    <tr>


        <td>${document.balance}</td>
        <td>${document.toID}</td>
        <td>${document.formattedDate}</td>


        <br> <br>
    </tr>

</c:forEach>
</body>


</html>
