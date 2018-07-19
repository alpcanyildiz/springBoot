<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  UserEntity: yildiza
  Date: 7/17/2018
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Welcome ! </h1>
<strong>Account Documents</strong>

<div>

<table>

    <tr>

        <th>Price </th>
        <th>Account Receiver ID</th>
        <th>Date</th>
    </tr>

<form:form action="/account/listAccount" method="get">

    <input type="text" name="accountID" id="accountID" placeholder="Enter a Account ID" />

    <select id="time" name="time" >
        <option value="lastmonth">Last Month</option>
        <option value="lastyear">Last Year</option>
        <option value="lastday">Last 1 Day</option>
        <option value="lastweek">Last Week</option>
    </select>

    <input name="submit" type="submit" value="submit"/>


</form:form>


<c:forEach var="document" items="${documents}">
    <tr>


        <td>${document.balance}</td>
        <td>${document.toId}</td>
        <td>${document.formattedDate}</td>


        <br> <br>
    </tr>

</c:forEach>


</table>

</div>



</body>
</html>
