<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>

<body>
<script type="text/javascript">
    var service = '/news';
    var RestGetById = function (id) {
        $.ajax({
            type: 'GET',
            url: service + "/get/id/" +id,
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

<script type="text/javascript">
    var service = '/news';
    var RestGet = function () {
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
    <tr>
        <td>
            <button type="button" onclick="RestGetById($('#getNewsID').val())">Get news by Id</button>
            Id: <input id = "getNewsID" value="3" size="3"/>
        </td>
    </tr>
</table>

<table class="table">
        <td>
            <button type="button" onclick="RestGet()">Show all news</button>
        </td>
    </tr>
</table>
<div class="panel panel-default">
    <div class="panel-heading">
        <strong>RESPONSE</strong>
    </div>
    <div class="panel-body" id="response"></div>
</div>
</body>
</html>
