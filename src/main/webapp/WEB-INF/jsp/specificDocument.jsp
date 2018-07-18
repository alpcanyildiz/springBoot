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

<h1>Welcome to Last One Month Account Document Page</h1>


<form:form method="get" action="accountInformation" >


<select id="time" name="time" >
    <option value="lastday">Last 1 Day</option>
    <option value="lastweek">Last Week</option>
    <option value="lastmonth">Last Month</option>
    <option value="lastyear">Last Year</option>
    <input name="submit" type="submit" value="submit" />
</select>

</form:form>

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
