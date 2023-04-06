<%--
  Created by IntelliJ IDEA.
  User: quang
  Date: 3/29/2023
  Time: 7:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form action="/may-tinh/update?ma=${mayTinh.ma}" method="post">
    Tên: <input type="text" name="ten" value="${mayTinh.ten}"> <br>
    Giá: <input type="text" name="gia" value="${mayTinh.gia}"> <br>
    Bộ nhớ: <input type="text" name="boNho" value="${mayTinh.boNho}"> <br>
    Màu sắc: <input type="radio" name="mauSac" value="Đen" ${mayTinh.mauSac == "Đen" ? "checked" : ""}>Đen
    <input type="radio" name="mauSac" value="Bạc" ${mayTinh.mauSac == "Bạc" ? "checked" : ""}>Bạc
    <br>
    Hãng: <select name="hang">
    <option value="MSI" ${mayTinh.hang == "MSI" ? "selected" : ""}>MSI</option>
    <option value="ASUS" ${mayTinh.hang == "ASUS" ? "selected" : ""}>ASUS</option>
    <option value="ACER" ${mayTinh.hang == "ACER" ? "selected" : ""}>ACER</option>
    <option value="DELL" ${mayTinh.hang == "DELL" ? "selected" : ""}>DELL</option>
</select>
    <br>
    Mô tả: <input type="text" name="moTa" value="${mayTinh.mieuTa}"><br>
    <button type="submit">Update</button>
</form>
</body>
</html>
