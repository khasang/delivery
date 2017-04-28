<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" language="java"%>
<html>
<head>
    <title>Upload product image file</title>
</head>
<body>
<form method="POST" action="/products/addImage"  enctype="multipart/form-data">
    Image to upload: <input type="file" name="file" class="file">

    Product id: <input type="text" name="productId">


    <input type="submit" value="Upload"> Press here to upload the image!
</form>
</body>
</html>
