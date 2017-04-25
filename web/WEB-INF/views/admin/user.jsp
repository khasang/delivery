<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Пользователь</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>

    <script type="text/javascript">
        var service = '/admin/users';
        var RestPostAddUser = function () {
            var JSONObject = {
                'login': $('#login').val(),
                'role': $('#role').val(),
                'password': $('#password').val(),
                'active': $('#active').prop('checked')
            }
            $.ajax({
                type: 'POST',
                url: service + "/add",
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(JSONObject),
                dataType: 'json',
                async: false,
                success: function (result) {
                    window.location.replace('/admin/users');
                },
                error: function (jqXHR, textStatus, errorThrpwn) {
                    $('#response').html(JSON.stringify(jqXHR));
                }
            });
        };
    </script>
</head>
<body>
    <fieldset>
        <legend>Пользователь</legend>
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
                <button type="submit" onclick="RestPostAddUser()" class="btn btn-default">Сохранить</button>
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
