<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/29/2023
  Time: 9:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/sinh-vien/search" method="get">
    Tên<input name="sten"/>
    <button type="submit">Search</button>
</form>

<a href="/sinh-vien/view-add">Add Student</a>
<table border="1">
    <thead>
    <tr>
        <th>MSSV</th>
        <th>Tên</th>
        <th>Tuổi</th>
        <th>Địa chỉ</th>
        <th>Giới tính</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listSV}" var="x">
        <tr>
            <td>${x.code}</td>
            <td>${x.name}</td>
            <td>${x.age}</td>
            <td>${x.address}</td>
            <td>${x.gender == true ? "Nam" : "Nữ"}</td>
            <td>
                <a href="/sinh-vien/detail?id=${x.code}">detail</a>
                <a href="/sinh-vien/remove?id=${x.code}">delete</a>
                <a href="/sinh-vien/view-update?id=${x.code}">update</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
