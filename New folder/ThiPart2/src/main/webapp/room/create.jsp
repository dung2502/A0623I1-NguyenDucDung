<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product Management Application</title>
    <link rel="stylesheet" href="../static/bootstrap-5.0.2-dist/css/bootstrap.css">
    <link rel="stylesheet" href="../static/css/style.css">
</head>
<body>
<div class="background-form container">
    <div align="center">
        <h1>Product Management</h1>
        <h2>
            <a href="elementManager?action=elementManager">List All Product</a>
        </h2>
        <form method="post" class="form">
            <caption>
                <h2>Add New Product</h2>
            </caption>
            <table border="1" cellpadding="5" class="table table-light table-striped container">
                <tr>
                    <th>Product Name:</th>
                    <td>
                        <input  type="text" name="product_name" id="product_name" size="45" style="width: 370px; height: 30px; " required />
                    </td>
                </tr>
                <tr>
                    <th>Price:</th>
                    <td>
                        <input  type="text" name="price" id="price" size="45" style="width: 370px; height: 30px; " required />
                    </td>
                </tr>
                <tr>
                    <th> Quantity: </th>
                    <td>
                        <input  type="text" name="quantity" id="quantity" size="45" style="width: 370px; height: 30px; " required  />
                    </td>
                </tr>
                <tr>
                    <th> Color: </th>
                    <td>
                        <input  type="text" name="color" id="color" size="45" style="width: 370px; height: 30px; " required/>
                    </td>
                </tr>

                <tr>
                    <th> Category :</th>
                    <td>
                        <select name="category_code" id="category_code" class="input" required>
                            <option value="1">iPhone</option>
                            <option value="2">Tivi</option>
                            <option value="3">Tủ lạnh</option>
                            <option value="4">Máy giặt</option>
                        </select>
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
