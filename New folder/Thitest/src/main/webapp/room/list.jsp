
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Management Application</title>
    <link rel="stylesheet" href="../static/bootstrap-5.0.2-dist/css/bootstrap.css">
    <link href="https://cdn.datatables.net/1.13.7/css/dataTables.bootstrap5.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../static/css/style.css">
</head>
<body>
<div class="logo">
    <a href="/index.jsp">
        <img src="../static/images/logo.png" alt="logo" class="logo" width="50px"
             style="border-radius: 10px; position: absolute">
    </a>
</div>
<div align="center" class="container">
    <h1 class="text-white">Room Management</h1>
    <h2 class="add">
        <a href="/roomsManager?action=create" class="text-warning">Add New Room</a>
    </h2>
    <form class="d-flex" role="search" action="/roomsManager?action=search" method="post">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="room_id">
        <button class="btn btn-outline-success bg-white" type="submit">Search</button>
    </form>
    <caption><h2 class="text-white">List of Students</h2></caption>
    <table border="1" cellpadding="5" width="100%" class="table table-light table-striped" id="example">
        <thead>
        <tr>
            <th>STT</th>
            <th>Mã phòng trọ</th>
            <th>Tên người thuê trọ</th>
            <th>Số điện thoại</th>
            <th>Ngày bắt đầu thuê</th>
            <th>Hình thức thanh toán</th>
            <th>Ghi chú</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="room" items="${ListRoom}">
            <tr>
                <td><c:out value="${room.id}"/></td>
                <td><c:out value="${room.room_id}"/></td>
                <td><c:out value="${room.person_name}"/></td>
                <td><c:out value="${room.phone_number}"/></td>
                <td><c:out value="${room.rental_start_date}"/></td>
                <td><c:out value="${room.payments}"/></td>
                <td><c:out value="${room.note}"/></td>
                <td>
                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" onclick="deleteModal(${room.id})" data-bs-target="#exampleModal">
                        Delete
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <p id="info"></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" onclick="confirmDelete()">Save changes</button>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script src="https://cdn.datatables.net/1.13.7/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.13.7/js/dataTables.bootstrap5.min.js"></script>
<script>
    new DataTable('#example');
    let codeDelete = -1;

    function deleteModal(code) {
        codeDelete = code;
        document.getElementById("info").innerText = "Do you want delete this room " + code + "?"
    }

    function confirmDelete() {
        window.location.href = "/roomsManager?action=delete&id="+codeDelete;
    }
    let display = document.getElementById("example_filter");
    display.style.display = "none";
</script>
</body>
</html>
