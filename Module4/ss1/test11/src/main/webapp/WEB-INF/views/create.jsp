<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Form</h2>
<form:form action="/create/create-user" method="post" modelAttribute="user">
    <p>User Name : </p>
    <form:input type="text" path="username"/>
    <p>Password : </p>
    <form:input type="text" path="password"/>
    <br>
    <button type="submit"> create </button>
</form:form>
</body>
</html>
