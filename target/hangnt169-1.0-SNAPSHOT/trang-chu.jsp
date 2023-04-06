<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 14/03/2023
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<header style="text-align: center"><h1>Đây không phải Header</h1></header>
<main>
    <section>
        <form action="/may-tinh/add" method="post">
            Tên: <input type="text" name="ten" value="${mayTinh.ten}"> <br>
            Giá: <input type="text" name="gia" value="${mayTinh.gia}"> <br>
            Bộ nhớ: <input type="text" name="boNho" value="${mayTinh.boNho}"> <br>
            Màu sắc: <input type="radio" name="mauSac" value="Đen" ${mayTinh.mauSac == "Đen" ? "checked" : ""} checked>Đen
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
            <button type="submit">Add</button>
        </form>
    </section>
    <br>
    <section>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Mã</th>
                <th scope="col">Tên</th>
                <th scope="col">Giá</th>
                <th scope="col">Bộ nhớ</th>
                <th scope="col">Màu sắc</th>
                <th scope="col">Hãng</th>
                <th scope="col">Miêu tả</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="mt">
                <tr>
                    <td>${mt.ma}</td>
                    <td>${mt.ten}</td>
                    <td>${mt.gia}</td>
                    <td>${mt.boNho}GB</td>
                    <td>${mt.mauSac}</td>
                    <td>${mt.hang}</td>
                    <td>${mt.mieuTa}</td>
                    <td>
                        <a href="/may-tinh/detail?ma=${mt.ma}" class="btn btn-success " role="button"
                           data-bs-toggle="button" aria-pressed="true">Detailk</a>
                        <a href="/may-tinh/remove?ma=${mt.ma}" class="btn btn-danger " role="button"
                           data-bs-toggle="button" aria-pressed="true">Delete</a>
                        <a href="/may-tinh/view-update?ma=${mt.ma}" class="btn btn-primary " role="button"
                           data-bs-toggle="button" aria-pressed="true">Update</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </section>
</main>
<footer style="text-align: center"><h1>Đây không phải là Footer</h1></footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
        integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
        crossorigin="anonymous"></script>
</body>
</html>