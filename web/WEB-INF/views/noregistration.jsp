<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>
<body>
<script type="text/javascript">
    var service = '/noregistration';
    var RestGetreg = function (id) {
        $.ajax({
            type: 'GET',
            url: service + "/get/id/" + id,
            dataType: 'json',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result));
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR));
            }
        })
    }
    var RestPost = function (client_name) {
        var JSONObject = {
            'name': client_name,
            'phoneNumber': "5555555555555555",
            'address': "Klond"
        }
        $.ajax({
            type: 'POST',
            url: service + "/add",
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(JSONObject),
            dataType: 'json',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result));

            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR));
            }
        });
    };
</script>
<jsp:include page="header.jsp"/>
<form class="form-horizontal">
    <div class="form-group">
        <div class="col-xs-offset-5 col-xs-3">
            <p><strong>Данные для заказа</strong></p>
        </div>
        <label for="postName" class="col-xs-5 control-label">Имя:</label>
        <div class="col-xs-3">
            <input type="name" class="form-control" id="postName" placeholder="Введите имя">
        </div>
    </div>
    <div class="form-group">
        <label for="phoneNumber" class="col-xs-5 control-label">Телефон:</label>
        <div class="col-xs-3">
            <input type="phoneNumber" class="form-control" id="phoneNumber" placeholder="Введите телефон">
        </div>
    </div>
    <div class="form-group">
        <label for="inputaddres" class="col-xs-5 control-label">Адрес:</label>
        <div class="col-xs-3">
            <input type="addres" class="form-control" id="inputaddres" placeholder="Введите адрес доставки">
        </div>
    </div>
    <div class="form-group">
        <div class="col-xs-offset-5 col-xs-3">
            <button type="button" onclick="RestPost($('#postName').val())">Подтвердить</button>
        </div>
    </div>
</form>

<table class="table">
    <thead/>
    <tr>
        <th>ID</th>
        <th>NAME</th>
    </tr>
    <tbody/>
    <tr>
        <td>Get NoregCustomer by id</td>
        <td><code><strong>GET</strong>/noregistration/get/id/{id}</code></td>
        <td>
            Id: <input id="getNoRegistrationCustomerID" value="3"/>
            <button type="button" onclick="RestGetreg($('#getNoRegistrationCustomerID').val())">Select</button>
        </td>
    </tr>
   </table>
<div class="panel panel-default">
    <div class="panel-heading">
        <strong>RESPONSE</strong>
    </div>
    <div class="panel-body" id="response"></div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
