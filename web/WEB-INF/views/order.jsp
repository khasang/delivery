<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order web</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>

    <script type="text/javascript">
        var service = '/order';
        var parseResult = function (result) {
            var table = document.getElementById('response');

            while(table.firstChild){
                table.removeChild(table.firstChild);
            }

            if (result.length) {
                for (var i=0; i < result.length; i++) {
                    var tr = document.createElement('tr');
//					tr.setAttribute(onclick.getBasket);

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
                //tr.setAttribute(onclick.getBasket);

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
        var getBasket = function() {
            var id = this.childNode[0].innerHTML;
            $.ajax({
                type: 'GET',
                url: service + "basket/get/id/" + id,
                dataType: 'json',
                async: false,
                success: parseResultBasket,
                error: function (jqXHR, textStatus, errorThrown) {
                    $('#response').html(JSON.stringify(jqXHR));
                }
            })

        };
        var parseResultBasket = function (result) {
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
                    td.innerHTML = result[i].itemId;
                    tr.appendChild(td);

                    td = document.createElement('td');
                    td.innerHTML = result[i].quantity;
                    tr.appendChild(td);

                    table.appendChild(tr);
                }
            } else {
                var tr = document.createElement('tr');

                var td = document.createElement('td');
                td.innerHTML = result.id;
                tr.appendChild(td);

                td = document.createElement('td');
                td.innerHTML = result.itemId;
                tr.appendChild(td);

                td = document.createElement('td');
                td.innerHTML = result.quantity;
                tr.appendChild(td);

                table.appendChild(tr);
            }
        };
        var RestPost = function (userId,time,date,address) {
            var JSONObject = {
                'userId': userId,
                'deliveryTime':time.toString()+":00",
                'deliveryDate':date.toString(),
                'deliveryAddress':address
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
                error: function (jqXHR, textStatus, errorThrpwn) {
                    $('#response').html(JSON.stringify(jqXHR));
                }
            });
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
    <tr>
        <td>Добавить новый заказ</td>
        <td><code><strong>POST</strong>/order/add</code></td>
        <td>
            <form class="form-horizontal">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="userid">UserId:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="userid" placeholder="Enter user ID" value="user_id">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="time">Time:</label>
                    <div class="col-sm-10">
                        <input type="time" class="form-control" id="time" placeholder="Enter delivery time" value="time">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="date">Date:</label>
                    <div class="col-sm-10">
                        <input type="date" class="form-control" id="date" placeholder="Enter delivery date" value="date">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="address">Address:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="address" placeholder="Enter delivery address" value="address">
                    </div>
                </div>
                <%--UserID: <input type="text" id="UserId" value="user_id"/>--%>
                <%--Time: <input type="time" id="time" value="time"/>--%>
                <%--Date: <input type="date" id="date" value="date"/>--%>
                <%--Address: <input type="text" id="address" value="address"/>--%>
                <button type="button" class="btn btn-info"
                        onclick="RestPost($('#userid').val()
                                            ,$('#time').val()
                                            ,$('#date').val()
                                            ,$('#address').val())">Создать заказ</button>
            </form>
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