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
MSSV: <span>${sv.code}</span>
<br>
<br>
Tên: <span>${sv.name}</span>
<br>
<br>
Tuổi: <span >${sv.age}</span>
<br>
<br>
Địa chỉ: <span >${sv.address}</span>
<br>
<br>
Giới tính: <input type="radio" name="gender" value="true" ${sv.gender == true ? "checked" : ""}>Nam
<input type="radio" name="gender" value="false"  ${sv.gender == false ? "checked" : ""}>Nữ

</body>
</html>
