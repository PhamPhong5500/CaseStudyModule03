
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save</title>
</head>
<body>
<form action="/save" method="post">
    <label>Name: </label>
    <input type="text" name="name" value="${glassesDTO.getName}"> <br><br>
    <label>Price: </label>
    <input type="text" name="price" value="${glassesDTO.getPrice}"> <br><br>
    <label>Quantity: </label>
    <input type="text" name="quantity" value="${glassesDTO.getQuantity}"> <br><br>
    <label>Brand: </label>
    <input type="text" name="brand" value="${glassesDTO.getBrand}"> <br><br>
    <input type="submit" value="Submit">
</form>

</body>
</html>
