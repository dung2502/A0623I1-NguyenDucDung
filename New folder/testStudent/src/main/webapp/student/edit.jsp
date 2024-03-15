<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
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
        <form method="post" accept-charset="UTF-8" class="form">
            <table border="1" cellpadding="5" class="table table-light table-striped container">
                <tr>
                    <td colspan="2" align="center">
                        <h2>Edit Student</h2>
                    </td>
                </tr>
                <c:if test="${student != null}">
                    <input type="hidden" name="id" value="<c:out value='${student.id}' />"
                           style="width: 370px; height: 30px;"/>
                </c:if>
                <tr>
                    <th>Student Name:</th>
                    <td>
                        <input type="text" name="name" size="45" style="width: 370px; height: 30px;"
                               value="<c:out value='${student.name}' />"
                        />
                        <%--                        <span class="text-danger fs-6 danger">${error.nameError}</span>--%>
                    </td>
                </tr>
                <tr>
                    <th>Date of birth:</th>
                    <td>
                        <input type="date" name="date" size="45" style="width: 370px; height: 30px;"
                               value="<c:out value='${student.date}' />"
                        />
                        <%--                        <span class="text-danger fs-6 danger">${error.dobError}</span>--%>
                    </td>
                </tr>
                <tr>
                    <th>Gender:</th>
                    <td>
                        <c:if test="${student.gender == 'Nam'}">
                            <input type="checkbox" id="gender1" name="gender" value="Nam" checked>
                            <label for="gender1"> Nam</label>
                            <input type="checkbox" id="gender2" name="gender" value="Nữ">
                            <label for="gender2"> Nữ</label>
                        </c:if>
                        <c:if test="${student.gender != 'Nam'}">
                            <input type="checkbox" id="gender1" name="gender" value="Nam">
                            <label for="gender1"> Nam</label>
                            <input type="checkbox" id="gender2" name="gender" value="Nữ" checked>
                            <label for="gender2"> Nữ</label>
                        </c:if>
                        <%--                        <span  class="text-danger fs-6 danger">${error.genderError}</span>--%>
                    </td>
                </tr>
                <tr>
                    <th>Phone:</th>
                    <td>
                        <input type="text" name="phone" id="phone" size="45" style="width: 370px; height: 30px;"
                               value="<c:out value='${student.phoneNumber}' />"
                        />
                        <%--                        <span  class="text-danger fs-6 danger">${error.phoneNumberError}</span>--%>
                    </td>
                </tr>
                <tr>
                    <th>Class:</th>
                    <td>

                        <select name="classId" id="classId" style="width: 370px; height: 30px;">
                            <c:forEach var="classes" items="${classesList}">
                                <c:if test="${classes.classId eq student.classID}">
                                    <option value="${classes.classId}" selected>${classes.nameClass}</option>
                                </c:if>
                                <c:if test="${classes.classId ne student.classID}">
                                    <option value="${classes.classId}">${classes.nameClass}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                        <%--                        <input type="text" name="classId" id="classId" style="width: 370px; height: 30px;"--%>
                        <%--                               value="<c:out value='${student.classID}' />"--%>
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