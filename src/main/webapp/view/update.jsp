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
<form action="/sinh-vien/update" method="post">
    MSSV: <input type="text" name="code" value="${sv.code}" readonly>
    <br>
    <br>
    Tên: <input type="text" name="name" value="${sv.name}">
    <br>
    <br>
    Tuổi: <input type="text" name="age" value="${sv.age}">
    <br>
    <br>
    Địa chỉ: <input type="text" name="address" value="${sv.address}">
    <br>
    <br>
    Giới tính: <input type="radio" name="gender" value="true" ${sv.gender == true ? "checked" : ""}>Nam
    <input type="radio" name="gender" value="false"  ${sv.gender == false ? "checked" : ""}>Nữ
    <br>
    <br>
    <button type="submit">update</button>
</form>
</body>
</html>
