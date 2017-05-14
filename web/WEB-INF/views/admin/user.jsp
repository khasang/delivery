<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/js/jquery.min.js" var="jquery"/>
<spring:url value="/js/admin/user.js" var="jusers"/>
<spring:url value="/css/bootstrap.css" var="bootstrap"/>

<html>
<head>
    <title>Пользователь</title>
    <script src="${jquery}" type="text/javascript"></script>
    <script src="${jusers}" type="text/javascript"></script>
    <link href="${bootstrap}" rel="stylesheet"/>
</head>
<body>
    <fieldset>
        <legend>Пользователь</legend>
        <input type="hidden" name="id" value="${id}" id="id">
        <div class="form-group">
            <label for="login" class="col-sm-2 control-label">Логин</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="login" placeholder="Логин">
            </div>
        </div>
        <div class="form-group">
            <label for="role" class="col-sm-2 control-label">Роль</label>
            <div class="col-sm-10">
                <select class="form-control" id="role" placeholder="Роль">
                    <option value="ROLE_ADMIN">Администратор</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">Пароль</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="password" placeholder="Password">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <div class="checkbox">
                    <label>
                        <input type="checkbox" id="active"> Активен
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" onclick="SaveUser()" class="btn btn-default">Сохранить</button>
            </div>
        </div>
    </fieldset>
    <div class="panel panel-default">
        <div class="panel-heading">
            <strong>RESPONSE</strong>
        </div>
        <div class="panel-body" id="response"></div>
    </div>
</body>
</html>
