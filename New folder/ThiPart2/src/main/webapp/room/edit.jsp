
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Management Application</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="../static/css/style.css">
</head>
<body>
<div class="background-form container">
    <div align="center">
        <h1>Product Management</h1>
        <h2>
            <a href="elementManager?action=elementManager">List All Product</a>
        </h2>
        <form method="post" accept-charset="UTF-8" class="form">
            <table border="1" cellpadding="5" class="table table-light table-striped container">
                <tr>
                    <td colspan="2" align="center">
                        <h2>Edit Product</h2>
                    </td>
                </tr>
                <c:if test="${product != null}">
                    <input type="hidden" name="id" value="<c:out value='${product.id}' />" style="width: 370px; height: 30px;"/>
                </c:if>
                <tr>
                    <th>Product Name:</th>
                    <td>
                        <input type="text" name="name" size="45" style="width: 370px; height: 30px;"
                               value="<c:out value='${product.product_name}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Price</th>
                    <td>
                        <input type="tetx" name="price" size="45" style="width: 370px; height: 30px;"
                               value="<c:out value='${product.price}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Quantity</th>
                    <td>
                        <input type="tetx" name="quantity" size="45" style="width: 370px; height: 30px;"
                               value="<c:out value='${product.quantity}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>color:</th>
                    <td>
                        <input type="text" name="color" id="color" size="45" style="width: 370px; height: 30px;"
                               value="<c:out value='${product.color}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Category:</th>
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

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</div>
</body>
</html>