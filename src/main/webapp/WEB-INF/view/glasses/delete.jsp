<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Delete</title>
    <style>
        div{
            text-align: center;
        }
    </style>
</head>
<body>
<form action="/delete" method="post">
    <div class="header">
    <input type="hidden" name="id" value="${glassesDTO.getId()}">
    <h1>Are you sure ?</h1>
    <input type="submit" value="Delete" class="button">
    </div>
</form>

</body>
</html>
