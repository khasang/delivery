<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>

    <script type="text/javascript">
        var service = '/admin/users';
        var parseResult = function (result) {
            var table = document.getElementById('response');
          
            while(table.firstChild){
                table.removeChild(table.firstChild);
            }

            if (result.length) {
                for (var i=0; i < result.length; i++) {
                    var tr = document.createElement('tr');

                    var td = document.createElement('td');
                    td.innerHTML = result[i].id;
                    tr.appendChild(td);

                    td = document.createElement('td');
                    td.innerHTML = result[i].login;
                    tr.appendChild(td);

                    td = document.createElement('td');
                    td.innerHTML = result[i].role;
                    tr.appendChild(td);

                    td = document.createElement('td');
                    td.innerHTML = result[i].active;
                    tr.appendChild(td);

                    table.appendChild(tr);
                }
            } else {
                var tr = document.createElement('tr');

                var td = document.createElement('td');
                td.innerHTML = result.id;
                tr.appendChild(td);

                td = document.createElement('td');
                td.innerHTML = result.login;
                tr.appendChild(td);

                td = document.createElement('td');
                td.innerHTML = result.role;
                tr.appendChild(td);

                td = document.createElement('td');
                td.innerHTML = result.active;
                tr.appendChild(td);

                table.appendChild(tr);
            }
        };

        var RestGetById = function (id) {
            $.ajax({
                type: 'GET',
                url: service + "/get/id/" + id,
                dataType: 'json',
                async: false,
                success: parseResult,
                error: function (jqXHR, textStatus, errorThrown) {
                    $('#response').html(JSON.stringify(jqXHR));
                }
            })
        };
        var RestGetAll = function (all) {
            $.ajax({
                type: 'GET',
                url: service + "/all",
                dataType: 'json',
                async: false,
                success: parseResult,
                error: function (jqXHR, textStatus, errorThrown) {
                    $('#response').html(JSON.stringify(jqXHR));
                }
            })
        };
        var RestGetByLogin = function (login) {
            $.ajax({
                type: 'GET',
                url: service + "/get/login/" + login,
                dataType: 'json',
                async: false,
                success: parseResult,
                error: function (jqXHR, textStatus, errorThrown) {
                    $('#response').html(JSON.stringify(jqXHR));
                }
            })
        }
    </script>
</head>

<body>
<table class="table">
    <tr>
        <td>Получить всех пользователей</td>
        <td><code><strong>GET</strong>/admin/users/all"</code></td>
        <td></td>
        <td>
            <button type="button" class="btn btn-info" onclick="RestGetAll()">Получить</button>
        </td>
    </tr>
    <tr>
        <td>Получить пользователя по ID</td>
        <td><code><strong>GET</strong>/admin/users/get/id/{id}"</code></td>
        <td><input id="getDocumentID" class="form-control" value="" placeholder="Id"/></td>
        <td>
            <button type="button" class="btn btn-info" onclick="RestGetById($('#getDocumentID').val())">Получить</button>
        </td>
    </tr>
    <tr>
        <td>Получить пользователя по логину</td>
        <td><code><strong>GET</strong>/admin/users/get/login/{login}"</code></td>
        <td><input id="getDocumentLOG" class="form-control" value="" placeholder="Login"/></td>
        <td>
            <button type="button" class="btn btn-info" onclick="RestGetByLogin($('#getDocumentLOG').val())">Получить</button>
        </td>
    </tr>
</table>

<div class="panel panel-default">
    <div class="panel-heading">
        <strong>RESPONSE</strong>
    </div>
    <table class="table table-hover table-condensed">
        <thead>
        <th>#</th>
        <th>LOGIN</th>
        <th>ROLE</th>
        <th>ACTIVE</th>
        </thead>
        <tbody id="response"></tbody>
    </table>
</div>
</body>
</html>
