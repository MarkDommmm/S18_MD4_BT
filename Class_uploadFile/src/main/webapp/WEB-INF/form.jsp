<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/15/2023
  Time: 5:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/upload/image" method="post" enctype="multipart/form-data">
    <input type="file" name="img" multiple>
    <button>Lick em!</button>
</form>
</body>
</html>
