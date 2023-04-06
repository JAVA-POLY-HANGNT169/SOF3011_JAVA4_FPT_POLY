<%--
  Created by IntelliJ IDEA.
  User: tuane
  Date: 3/31/2023
  Time: 5:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container .bg-light">
    <div class="row">
        <div class="col-lg-8 bg-light">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Tên Sản Phẩm</th>
                    <th scope="col">Dòng Sản Phẩm</th>
                    <th scope="col">Năm bảo hàng</th>
                    <th scope="col">Màu Sắc</th>
                    <th scope="col">Số Lượng</th>
                    <th scope="col">Giá Bán</th>
                    <th scope="col">Tổng Tiền</th>

                    <th scope="col">Thao Tác</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${productCartResponseList}" var="o" varStatus="positon">
                    <tr>
                        <th scope="row">${positon.index + 1}</th>
                        <td>${o.tenSP}</td>
                        <td>${o.dongSP}</td>
                        <td>${o.namBH}</td>
                        <td>${o.tenMauSac}</td>
                        <td>${o.soLuong}</td>
                        <td>${o.giaBan}</td>
                        <td>${o.totalMount()}</td>

                        <td>

                            <button class="btn btn-outline-info"><a style="text-decoration: none"
                                                                    href="/remove?id=${positon.index}">Delete</a>
                            </button>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>

            </table>
        </div>
        <div class="col-lg-4 bg-info">
            <table class="table table-hover">
                <tr>
                    <td><h6>Tổng Tiền</h6></td>
                    <td><h6>${totalCount}</h6></td>
                </tr>
                <tr>
                    <td><h6>Phí VAT</h6></td>
                    <td><h6>0 VND</h6></td>
                </tr>
                <tr>
                    <td><h6>Phí Shipping, Handle</h6></td>
                    <td><h6>0 VND</h6></td>
                </tr>
                <tr>
                    <td><h6>Thành Tiền</h6></td>
                    <td><h6>${totalCount}</h6></td>
                </tr>

            </table>

            <button class="btn btn-outline-info"><a style="text-decoration: none"
                                                    href="">Thanh Toán</a>
            </button>
        </div>
    </div>
</div>


<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

</body>
</html>
