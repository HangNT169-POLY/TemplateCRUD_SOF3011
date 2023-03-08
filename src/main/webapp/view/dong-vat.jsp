<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 06/03/2023
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<header>
    <h3 style="text-align: center;">Quản Lý Đông Vât</h3>
    <section>
        <a href="/dong-vat/view-add" class="btn btn-success " tabindex="-1" role="button"
           aria-disabled="true">Add</a>
    </section>
</header>
<main class="container">
    <section>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Tên</th>
                <th scope="col">Cân nặng</th>
                <th scope="col">Giới tính</th>
                <th scope="col">Năm sinh</th>
                <th scope="col">Chức năng</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${dongvats}" var="l">
                <tr>
                    <td>${l.id}</td>
                    <td>${l.ten}</td>
                    <td>${l.canNang}</td>
                    <td>${l.gioiTinh}</td>
                    <td>${l.namSinh}</td>
                    <td>
                        <a href="/dong-vat/detail?id=${l.id}" class="btn btn-primary " tabindex="-1" role="button"
                           aria-disabled="true">Detail</a>
                        <a href="/dong-vat/view-update?id=${l.id}" class="btn btn-success " tabindex="-1" role="button"
                           aria-disabled="true">Update</a>
                        <a href="/dong-vat/delete?id=${l.id}" class="btn btn-danger " tabindex="-1" role="button"
                           aria-disabled="true">Remove</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </section>
</main>
<footer><p style="text-align: center;">HangNT169</p></footer>
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