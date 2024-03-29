<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" th:href="@{/static/css/style.css}"/>
</head>
<body>
<div th:replace="~{common_product::headerProduct}">

</div>
<div class="container">
    <a href="/products/create">Create new Product</a>
    <div class="notify">
        <div th:if="${message}">
            <span th:text="${message}"></span>
        </div>
    </div>
    <h1>List Products</h1>
    <table border="1" class="table table-hover" id="example">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name Product</th>
            <th>Price</th>
            <th>Description</th>
            <th>Manufacturer</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <tr th:each="product: ${list}">
            <td th:text="${product.id}"></td>
            <td th:text="${product.name}"></td>
            <td th:text="${product.price}"></td>
            <td th:text="${product.description}"></td>
            <td th:text="${product.manufacturer}"></td>
            <td><button class="btn btn-primary" ><a th:href="@{/products/{id}/update (id = ${product.id})}" class="link-light">Update</a></button></td>
            <td><button class="btn btn-danger"><a th:href="@{/products/{id}/delete (id = ${product.id})}"class="link-light">Delete</a></button></td>
        </tr>
        </tbody>
    </table>
</div>
<div th:insert="~{common_product::footerProduct}">

</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>