<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Student Management Application</title>
    <link rel="stylesheet" href="../static/bootstrap-5.0.2-dist/css/bootstrap.css">
    <link rel="stylesheet" href="../static/css/style.css">
</head>
<body>
<div class="background-form container">
    <div align="center">
        <h1>Student Management</h1>
        <h2>
            <a href="studentsManager?action=studentsManager">List All Student</a>
        </h2>
        <form method="post" class="form">
            <caption>
                <h2>Add New Student</h2>
            </caption>
            <table border="1" cellpadding="5" class="table table-light table-striped container">
                <tr>
                    <th>Student Full Name:</th>
                    <td>
                        <input  type="text" name="name" id="name" size="45" style="width: 370px; height: 30px; " pattern="[A-Za-zĐđÀ-ỹ ]{4,50}" oninvalid="this.setCustomValidity('Vui lòng nhập theo định dạng!')" oninput="setCustomValidity('')" />
                    </td>
                </tr>
                <tr>
                    <th>Date of birth:</th>
                    <td>
                        <input type="date" name="dob" id="dob" size="45" style="width: 370px; height: 30px;"/>
                    </td>
                </tr>
                <tr>
                    <th>Gender:</th>
                    <td>
                        <input type="checkbox" id="gender1" name="gender" value="Nam">
                        <label for="gender1"> Nam</label>
                        <input type="checkbox" id="gender2" name="gender" value="Nam">
                        <label for="gender2"> Nữ</label>
                    </td>
                </tr>
                <tr>
                    <th>Phone:</th>
                    <td>
                        <input type="text" name="phone" id="phone" size="45" style="width: 370px; height: 30px;"/>
                    </td>
                </tr>
                <tr>
                    <th>Class:</th>
                    <td>
                        <select name="classId" id="classId" style="width: 370px; height: 30px;">
                            <c:forEach var="classes" items="${classesList}">
                                <option value="${classes.classId}" >${classes.nameClass}</option>
                            </c:forEach>
                        </select>
<%--                        <input type="text" name="classId" id="classId" style="width: 370px; height: 30px;"--%>
<%--                        />--%>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
