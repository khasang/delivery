<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Пользователь</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>
<body>
<form class="form-horizontal" role="form" action="#" th:action="@{/admin/users/add}" th:object="${user}" method="post">
    <fieldset>
        <legend>Пользователь</legend>
        <div class="form-group">
            <label for="login" class="col-sm-2 control-label">Логин</label>
            <div class="col-sm-10">
                <input type="text" th:field="*{login}" class="form-control" id="login" placeholder="Логин">
            </div>
        </div>
        <div class="form-group">
            <label for="role" class="col-sm-2 control-label">Роль</label>
            <div class="col-sm-10">
                <select class="form-control" th:field="*{role}" id="role" placeholder="Роль">
                    <option>ROLE_ADMIN</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">Пароль</label>
            <div class="col-sm-10">
                <input type="password" th:field="*{password}" class="form-control" id="password" placeholder="Password">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <div class="checkbox">
                    <label>
                        <input type="checkbox" th:field="*{active}" id="active"> Активен
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Сохранить</button>
            </div>
        </div>
    </fieldset>
</form>
</body>
</html>
