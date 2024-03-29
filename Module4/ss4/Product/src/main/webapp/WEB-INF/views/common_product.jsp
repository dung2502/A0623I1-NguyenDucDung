<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Student Manager</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" th:href="@{/static/css/style.css}"/>
</head>
<body>
<div th:fragment="headerProduct">
    <div class="header bg-light">
        <div class="logo">
            <img th:src="@{/static/images/logo.png}" class="img" alt="logo">
        </div>
        <div class="tittle">
            <h2>Product Management</h2>
        </div>
    </div>
</div>

<div th:fragment="footerProduct">
    <div class="footer bg-light">
        <span>Designed by DVK</span>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>