<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
        <form:button type="submit">Добавить</form:button>
    </form:form>
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
                                <td>
                                    <c:set var="cleanedDateTime" value="${fn:replace(feedback.date, 'T', ' ')}"/>
                                    <fmt:parseDate value="${ cleanedDateTime }" pattern="yyyy-MM-dd HH:mm"
                                                   var="parsedDateTime" type="both"/>
                                    <fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${ parsedDateTime }"/>
                                </td>
                            </tr>
                        </table>
                    </td>
                    <td>${feedback.feedBackText}</td>
                    <td>
                        <form:form action="/feedback/delete" method="POST">
                            <input type="hidden" name="feedbackId" value="${feedback.id}"/>
                            <input type="submit" value="Удалить">
                        </form:form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
</body>
</html>
