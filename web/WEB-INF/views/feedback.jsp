<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Отзывы</title>
</head>
<body>
    <div align="center">
        <h3>Отзывы покупателей</h3>
        <br/>
        <form:form action="/feedback/add" method="POST" modelAttribute="feedbackDto">
            <form:input path="text" placeholder="Оставьте отзыв..."/>
            <br/>
            <c:forEach items="${feedbacks}" var="feedback">
                <c:out value="${feedback.feedBackText}"/>
                <br/>
            </c:forEach>
        </form:form>
    </div>
</body>
</html>
