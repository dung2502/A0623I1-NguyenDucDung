<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 1/5/2024
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <form action="/student" method="post">
        <input type="hidden" name="action" value="update">
        <input class="form-control" type="hidden" name="id" value="${student.code}">
        <label>Name</label>
        <input class="form-control" type="text" name="name" value="${student.nameStudent}">
        <label>Point</label>
        <input class="form-control" type="number" name="point" value="${student.point}">
        <label>Id Card</label>
        <input class="form-control" type="text" name="idCard" value="${student.idCard}">
        <label>Code Class</label>
        <select name="codeClass">
            <c:forEach var="classroom" items="${classrooms}">
                <c:if test="${classroom.codeClass == student.codeClass}">
                    <option value="${classroom.codeClass}" selected>
                            ${classroom.nameClass}
                    </option>
                </c:if>
                <c:if test="${classroom.codeClass != student.codeClass}">
                    <option value="${classroom.codeClass}">
                            ${classroom.nameClass}
                    </option>
                </c:if>
            </c:forEach>
        </select>
        <button type="submit" class="btn btn-primary">Create</button>
    </form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>
