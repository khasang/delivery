<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>JMS receive</title>
</head>
<body>
<h1>Orders received from JMS</h1>
<ul>
    <c:forEach items="${response}" var="value">
        <li><c:out value="${value.id}"/></li>
    </c:forEach>
</ul>
</body>
</html>
