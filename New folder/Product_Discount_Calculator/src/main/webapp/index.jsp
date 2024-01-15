<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Currency Converter</title>
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2>Currency Converter</h2>
<form action="/calculate" method="post">
  <label>List Price: </label><br/>
  <input type="text" name="list_price" placeholder="List_Price" value="0"/><br/>
  <label>Discount Percent: </label><br/>
  <input type="text" name="discount_percent" placeholder="Discount_Percent" value="0"/><br/>
  <input type = "submit" id = "submit" value = "Converter"/>
</form>
</body>
</html>