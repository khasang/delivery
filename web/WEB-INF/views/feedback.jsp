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
            <h1>Отзывы</h1>
            <c:if test="${!empty feedbacks}">
                <table border="1px">
                    <tr>
                        <th>Покупатель</th>
                        <th width="400">Отзыв</th>
                    </tr>
                    <c:forEach items="${feedbacks}" var="feedback">
                        <tr>
                            <td>
                                <table>
                                    <tr>
                                        <td>Здесь могло быть имя юзера</td>
                                    </tr>
                                    <tr>
                                        <td>${feedback.date}</td>
                                    </tr>
                                </table>
                            </td>
                            <td>${feedback.feedBackText}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </form:form>
    </div>
</body>
</html>
