<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" language="java"%>
<html>
<head>
    <title>Show product image</title>
</head>
<body>
<form method="GET" action="/products/images/show">
    Product id: <input type="text" name="productId">
    <input type="submit" value="Show"> Press here to upload the image!
</form>
<image src="/products/getImageById/1"></image>
</body>
</html>
