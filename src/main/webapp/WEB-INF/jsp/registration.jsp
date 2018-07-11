<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Create an account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container">

    <form:form action="/registration" method="POST" modelAttribute="userForm" class="form-signin">
        <h2 class="form-signin-heading">Create your account</h2>



        <spring:bind path="userName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="userName" class="form-control" placeholder="Name"
                            autofocus="true"></form:input>
                <form:errors path="userName"></form:errors>
            </div>
        </spring:bind>


        <spring:bind path="userSurname">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="userSurname" class="form-control" placeholder="Surname"
                            autofocus="true"></form:input>
                <form:errors path="userSurname"></form:errors>
            </div>
        </spring:bind>


        <spring:bind path="eMail">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="eMail" path="eMail" class="form-control" placeholder="E-Mail"></form:input>
                <form:errors path="eMail"></form:errors>
            </div>
        </spring:bind>


        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
                <span>${errorMsg}</span>
            </div>
        </spring:bind>

        <spring:bind path="passwordMatch">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="passwordMatch" class="form-control"
                            placeholder="Confirm your password"></form:input>
                <span>${errorMsg}</span>
            </div>
        </spring:bind>

        <spring:bind path="userUsername">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="userUsername" path="userUsername" class="form-control"
                            placeholder="Username"></form:input>
                <form:errors path="userUsername"></form:errors>

            </div>
        </spring:bind>



        <spring:bind path="addres">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="addres" path="addres" class="form-control"
                            placeholder="Adress"></form:input>
                <form:errors path="addres"></form:errors>

            </div>
        </spring:bind>




        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
