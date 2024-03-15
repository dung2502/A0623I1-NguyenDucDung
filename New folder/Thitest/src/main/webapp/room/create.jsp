<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Room Management Application</title>
    <link rel="stylesheet" href="../static/bootstrap-5.0.2-dist/css/bootstrap.css">
    <link rel="stylesheet" href="../static/css/style.css">
</head>
<body>
<div class="background-form container">
    <div align="center">
        <h1>Room Management</h1>
        <h2>
            <a href="roomsManager?action=roomsManager">List All Student</a>
        </h2>
        <form method="post" class="form">
            <caption>
                <h2>Add New Room</h2>
            </caption>
            <table border="1" cellpadding="5" class="table table-light table-striped container">
                <tr>
                    <th>Room ID:</th>
                    <td>
                        <input  type="text" name="room_id" id="room_id" size="45" style="width: 370px; height: 30px; " />
                    </td>
                </tr>
                <tr>
                    <th>Person Name:</th>
                    <td>
                        <input  type="text" name="person_name" id="person_name" size="45" style="width: 370px; height: 30px; " required pattern="[A-Za-zĐđÀ-ỹ ]{4,50}" oninvalid="this.setCustomValidity('Tên người thuê phải là ký tự chữ cái từ 5 đến 50 ký tự')" oninput="setCustomValidity('')" />
                    </td>
                </tr>
                <tr>
                    <th>Phone Number:</th>
                    <td>
                        <input type="text" name="phone_number" id="phone_number" size="45" style="width: 370px; height: 30px;" required pattern="\d{10}" oninvalid="this.setCustomValidity('Vui lòng nhập đúng 10 chữ số')" oninput="setCustomValidity('')"/>
                    </td>
                </tr>
                <tr>
                    <th>Rental Start Date:</th>
                    <td>
                        <input type="date" name="rental_start_date" id="rental_start_date" size="45" style="width: 370px; height: 30px; " required oninvalid="this.setCustomValidity('Vui lòng nhập đúng quy định YY/MM/DD')" oninput="setCustomValidity('')"/>
                    </td>
                </tr>

                <tr>
                    <th>Payments :</th>
                    <td>
                        <select name="payment_code" id="payment_code" class="input" required>
                            <option value="1">Theo Tháng</option>
                            <option value="2">Theo Quý</option>
                            <option value="3">Theo Năm</option>
                        </select>
<%--                        <select name="payment_code" id="payment_code" style="width: 370px; height: 30px;">--%>
<%--                            <c:forEach var="bill" items="${ListRoom1}">--%>
<%--                                <option value="${bill.payment_code}" >${bill.payments}</option>--%>
<%--                            </c:forEach>--%>
<%--                        </select>--%>
<%--                        <input type="text" name="payment_code" id="payment_code" style="width: 370px; height: 30px;"/>--%>
                    </td>
                </tr>
                <tr>
                    <th>Note :</th>
                    <td>
                        <input type="text" name="note" id="note" size="45" style="width: 370px; height: 30px;" required oninvalid="this.setCustomValidity('Vui lòng nhập nguyện vọng của bạn')" oninput="setCustomValidity('')" />
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
