<%--
  Created by IntelliJ IDEA.
  User: tuane
  Date: 3/31/2023
  Time: 3:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="container">

    <h1 class="caption">Bán Hàng</h1>
    <hr>
    <div class="col-first">
        <button type="button" class="btn btn-success"><a style="text-decoration: none" href="/view-cartResponse">Giỏ Hàng</a>
        </button>
    </div>
    <hr>
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Tên Sản Phẩm</th>
            <th scope="col">Dòng Sản Phẩm</th>
            <th scope="col">Năm bảo hàng</th>
            <th scope="col">Số Lượng</th>
            <th scope="col">Giá Nhập</th>
            <th scope="col">Màu Sắc</th>
            <th scope="col">Thao Tác</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${chiTietSanPhamRespons}" var="o" varStatus="positon">
            <tr>
                <th scope="row">${positon.index + 1}</th>
                <td>${o.tenSP}</td>
                <td>${o.dongSP}</td>
                <td>${o.namBH}</td>
                <td>${o.soLuong}</td>
                <td>${o.giaBan}</td>
                <td>${o.tenMauSac}</td>
                <td>

                    <button class="btn btn-outline-danger"><a style="text-decoration: none" href="/add-cartResponse?id=${o.id}">Add
                        To Cart</a>
                    </button>
                    <button class="btn btn-outline-info"><a style="text-decoration: none">Buy Now</a></button>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>


<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</body>
</html>
