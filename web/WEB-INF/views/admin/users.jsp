<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/js/jquery.min.js" var="jquery"/>
<spring:url value="/js/admin/users.js" var="jusers"/>
<spring:url value="/css/bootstrap.css" var="bootstrap"/>

<html>
<head>
    <title>Title</title>
    <script src="${jquery}" type="text/javascript"></script>
    <script src="${jusers}" type="text/javascript"></script>
    <link href="${bootstrap}" rel="stylesheet"/>
</head>

<body>
<div class="panel panel-default">
    <div class="panel-heading"><strong>Пользователи</strong></div>

    <table class="table table-hover table-condensed">
        <thead>
        <th>Логин</th>
        <th>Роль</th>
        <th>Активен</th>
        <th>#</th>
        </thead>
        <tbody id="response"></tbody>
    </table>
</div>
<a href="/admin/adduser" class="btn btn-default">
    <span class="glyphicon glyphicon-plus"></span>
    Новый пользователь
</a>
</body>
</html>
