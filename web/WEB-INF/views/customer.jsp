<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>

    <script type="text/javascript">
        var service = '/customer';
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
                    td.innerHTML = result[i].name;
                    tr.appendChild(td);

                    td = document.createElement('td');
                    td.innerHTML = result[i].address;
                    tr.appendChild(td);

                    td = document.createElement('td');
                    td.innerHTML = result[i].eMail;
                    tr.appendChild(td);

                    td = document.createElement('td');
                    td.innerHTML = result[i].phoneNumber;
                    tr.appendChild(td);

                    table.appendChild(tr);
                }
            } else {
                var tr = document.createElement('tr');

                var td = document.createElement('td');
                td.innerHTML = result.id;
                tr.appendChild(td);

                td = document.createElement('td');
                td.innerHTML = result.name;
                tr.appendChild(td);

                td = document.createElement('td');
                td.innerHTML = result.address;
                tr.appendChild(td);

                td = document.createElement('td');
                td.innerHTML = result.eMail;
                tr.appendChild(td);

                td = document.createElement('td');
                td.innerHTML = result.phoneNumber;
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

        var RestPost = function (name,address,eMail,phoneNumber) {
            var JSONObject = {
                'name': name,
                'address':address,
                'eMail':eMail,
                'phoneNumber':phoneNumber
            }
            $.ajax({
                type: 'PUT',
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
        <td>Get Customer by ID</td>
        <td><code><strong>GET</strong>/customer/get/id/{id}</code></td>
        <td><input id="getCustomerID" class="form-control" value="" placeholder="Id"/></td>
        <td>
            <button type="button" class="btn btn-info" onclick="RestGetById($('#getCustomerID').val())">Get</button>
        </td>
    </tr>
    <tr>
        <td>Add new Customer</td>
        <td><code><strong>PUT</strong>/customer/add</code></td>
        <td>
            <form class="form-horizontal">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="name">Name:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="name" placeholder="Enter Customer's name">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="eMail">E-mail:</label>
                    <div class="col-sm-10">
                        <input type="email" class="form-control" id="eMail" placeholder="Enter Customer's e-mail">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="address">Address:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="address" placeholder="Enter Customer's address">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="phoneNumber">phone number:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="phoneNumber" placeholder="Enter Customer's cellphone number">
                    </div>
                </div>
                <button type="button" class="btn btn-info"
                        onclick="RestPost($('#name').val()
                                            ,$('#address').val()
                                            ,$('#eMail').val()
                                            ,$('#phoneNumber').val())">Create new Customer</button>
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
        <th>ID</th>
        <th>Name</th>
        <th>E-mail</th>
        <th>Address</th>
        <th>Phone number</th>
        </thead>
        <tbody id="response"></tbody>
    </table>
</div>
</body>
</html>