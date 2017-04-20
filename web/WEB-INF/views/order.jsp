<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order web</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>

    <script type="text/javascript">
        var service = '/order/';
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
                    td.innerHTML = result[i].deliveryDate;
                    tr.appendChild(td);

                    td = document.createElement('td');
                    td.innerHTML = result[i].deliveryTime;
                    tr.appendChild(td);

                    td = document.createElement('td');
                    td.innerHTML = result[i].deliveryAddress;
                    tr.appendChild(td);

                    table.appendChild(tr);
                }
            } else {
                var tr = document.createElement('tr');

                var td = document.createElement('td');
                td.innerHTML = result.id;
                tr.appendChild(td);

                td = document.createElement('td');
                td.innerHTML = result.deliveryDate;
                tr.appendChild(td);

                td = document.createElement('td');
                td.innerHTML = result.deliveryTime;
                tr.appendChild(td);

                td = document.createElement('td');
                td.innerHTML = result.deliveryAddress;
                tr.appendChild(td);

                table.appendChild(tr);
              }
        };
        var RestGetById = function (id) {
            $.ajax({
                type: 'GET',
                url: service + "/get/uid/" + id,
                dataType: 'json',
                async: false,
                success: parseResult,
                error: function (jqXHR, textStatus, errorThrown) {
                    $('#response').html(JSON.stringify(jqXHR));
                }
            })
        };
    </script>
</head>

<body>
<table class="table">
    <tr>
        <td>Получить заказы по ID клиента</td>
        <td><code><strong>GET</strong>/order/get/uid/{id}</code></td>
        <td><input id="getOrderID" class="form-control" value="" placeholder="Id"/></td>
        <td>
            <button type="button" class="btn btn-info" onclick="RestGetById($('#getOrderID').val())">Получить</button>
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
        <th>Date</th>
        <th>Time</th>
        <th>Address</th>
        </thead>
        <tbody id="response"></tbody>
    </table>
</div>
</body>
</html>