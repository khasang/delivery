<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>

<body>
<p>**********************Get by ID****************************</p>
<script type="text/javascript">
    var service = '/admin/users';
    var RestGet = function (id) {
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
</script>

<table class="table">
    <thead/>
    <tr>
        <th>ID</th>
        <th>NAME</th>
    </tr>
    <tbody/>
    <tr>
        <td>Get users by id</td>
        <td><code><strong>GET</strong>/admin/users/get/id/{id}"</code></td>
        <td>
            Id: <input id="getDocumentID" value=""/>
            <button type="button" onclick="RestGet($('#getDocumentID').val())">Try</button>
        </td>
    </tr>
</table>
<p>**********************Get all****************************</p>
<script type="text/javascript">
    var service = '/admin/users';
    var RestGet2 = function (all) {
        $.ajax({
            type: 'GET',
            url: service + "/all",
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
</script>

<table class="table">
    <thead/>
    <tr>
        <th>ID</th>
        <th>NAME</th>
    </tr>
    <tbody/>
    <tr>
        <td>Get all</td>
        <td><code><strong>GET</strong>/admin/users/all"</code></td>
        <td>
            <button type="button" onclick="RestGet2($('#getDocumentID').val())">Try</button>
        </td>
    </tr>
</table>

<p>**********************Get Login****************************</p>
<script type="text/javascript">
    var service = '/admin/users';
    var RestGet3 = function (login) {
        $.ajax({
            type: 'GET',
            url: service + "/get/login/" + login,
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
</script>

<table class="table">
    <thead/>
    <tr>
        <th>ID</th>
        <th>NAME</th>
    </tr>
    <tbody/>
    <tr>
        <td>Get users by login</td>
        <td><code><strong>GET</strong>/admin/users/get/login/{login}"</code></td>
        <td>
            login: <input id="getDocumentLOG" value=""/>
            <button type="button" onclick="RestGet3($('#getDocumentLOG').val())">Try</button>
        </td>
    </tr>
</table>

<p>**************************************************</p>
<div class="panel panel-default">
    <div class="panel-heading">
        <strong>RESPONSE</strong>
    </div>
    <div class="panel-body" id="response"></div>
</div>
</body>
</html>
