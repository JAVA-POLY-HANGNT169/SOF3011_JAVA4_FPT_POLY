<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/29/2023
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/sinh-vien/add" method="post">
    Tên: <input type="text" name="name">
    <br>
    <br>
    Tuổi: <input type="text" name="age">
    <br>
    <br>
    Địa chỉ: <input type="text" name="address">
    <br>
    <br>
    Giới tính: <input type="radio" name="gender" value="true" checked>Nam
    <input type="radio" name="gender" value="false">Nữ
    <br>
    <br>
    <button type="submit">Add</button>
</form>
</body>
</html>
