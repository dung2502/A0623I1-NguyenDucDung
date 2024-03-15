<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Management Application</title>
    <link rel="stylesheet" href="../static/bootstrap-5.0.2-dist/css/bootstrap.css">
    <link rel="stylesheet" href="../static/css/style.css">
</head>
<body>
<div class="background-form container">
    <div align="center">
        <h1>Management</h1>
        <h2>
            <a href="phongTro?action=phongTro">List All</a>
        </h2>
        <form method="post" class="form">
            <caption>
                <h2>Add New Student</h2>
            </caption>
            <table border="1" cellpadding="5" class="table table-light table-striped container">
                <tr>
                    <th>Mã phòng trọ:</th>
                    <td>
                        <input  type="text" name="ma_phong_tro" id="ma_phong_tro" size="45" style="width: 370px; height: 30px; " pattern="[A-Za-zĐđÀ-ỹ ]{5,50}" oninvalid="this.setCustomValidity('Vui lòng nhập theo định dạng!')" oninput="setCustomValidity('')" />
                    </td>
                </tr>
                <tr>
                    <th>Tên người thuê trọ:</th>
                    <td>
                        <input type="text" name="ten_nguoi_thue" id="ten_nguoi_tue" size="45" style="width: 370px; height: 30px;"/>
                    </td>
                </tr>
                <tr>
                    <th>Số điện thoại:</th>
                    <td>
                        <input type="text" name="so_dien_thoai" id="so_dien_thoai" size="45" style="width: 370px; height: 30px;" pattern="^\d{10}$" oninvalid="this.setCustomValidity('Vui lòng nhập theo định dạng!')" oninput="setCustomValidity('')"/>
                    </td>
                </tr>
                <tr>
                    <th>Ngày bắt đầu thuê:</th>
                    <td>
                        <input type="date" name="ngay_thue" id="ngay_thue" size="45" style="width: 370px; height: 30px;"/>
                    </td>
                </tr>
                <tr>
                    <th>Hình thức thanh toán:</th>
                    <td>
<%--                        <select name="classId" id="classId" style="width: 370px; height: 30px;">--%>
<%--                            <c:forEach var="classes" items="${classesList}">--%>
<%--                                <option value="${classes.classId}" >${classes.nameClass}</option>--%>
<%--                            </c:forEach>--%>
<%--                        </select>--%>
                        <input type="text" name="ma_thanh_toan" id="ma_thanh_toan" style="width: 370px; height: 30px;"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Ghi chú:</th>
                    <td>
                        <input type="text" name="ghi_chu" id="ghi_chu" size="45" style="width: 370px; height: 30px;"/>
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
