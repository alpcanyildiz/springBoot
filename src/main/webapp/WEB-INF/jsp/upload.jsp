<%--
  Created by IntelliJ IDEA.
  User: yildiza
  Date: 7/13/2018
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Spring Boot file upload example</h1>

<form method="POST" action="upload" enctype="multipart/form-data">
    File to upload: <input type="file" name="file"> <input
        type="submit" value="Upload"> Press here to upload the
    file!
</form>
</body>
</html>
