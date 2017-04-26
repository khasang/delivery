<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CountryDetails</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>

    <script type="text/javascript">
        var service = '/country';

        var parseCountryByCode = function (result) {
            var table = document.getElementById('response');

            while (table.firstChild) {
                table.removeChild(table.firstChild);
            }

            if (result.length) {
                for (var i = 0; i < result.length; i++) {
                    var tr = document.createElement('tr');

                    var td = document.createElement('td');
                    td.innerHTML = result[i].countryCode;
                    tr.appendChild(td);

                    td = document.createElement('td');
                    td.innerHTML = result[i].name;
                    tr.appendChild(td);

                    table.appendChild(tr);
                }
            } else {
                var tr = document.createElement('tr');

                var td = document.createElement('td');
                td.innerHTML = result.countryCode;
                tr.appendChild(td);

                td = document.createElement('td');
                td.innerHTML = result.name;
                tr.appendChild(td);

                table.appendChild(tr);
            }
        };
        var parseCurrencyByName = function (result) {
            var table = document.getElementById('response');

            while (table.firstChild) {
                table.removeChild(table.firstChild);
            }

            if (result.length) {
                for (var i = 0; i < result.length; i++) {
                    var tr = document.createElement('tr');

                    var td = document.createElement('td');
                    td.innerHTML = result[i].name;
                    tr.appendChild(td);

                    td = document.createElement('td');
                    td.innerHTML = result[i].currency;
                    tr.appendChild(td);

                    table.appendChild(tr);
                }
            } else {
                var tr = document.createElement('tr');

                var td = document.createElement('td');
                td.innerHTML = result.name;
                tr.appendChild(td);

                td = document.createElement('td');
                td.innerHTML = result.currency;
                tr.appendChild(td);

                table.appendChild(tr);
            }
        };

        var RestGetByCode = function (code) {
            $.ajax({
                type: 'GET',
                url: service + "/code/" + code,
                dataType: 'json',
                async: false,
                success: parseCountryByCode,
                error: function (jqXHR, textStatus, errorThrown) {
                    $('#response').html(JSON.stringify(jqXHR));
                }
            })
        };

        var RestGetCurrency = function (country) {
            $.ajax({
                type: 'GET',
                url: service + "/" + country,
                dataType: 'json',
                async: false,
                success: parseCurrencyByName,
                error: function (jqXHR, textStatus, errorThrown) {
                    $('#response').html(JSON.stringify(jqXHR));
                }
            });
        };
    </script>


</head>
<body>
<table class="table">
    <tr>
        <td>Узнать детали о стране</td>
    </tr>
    <tr>
        <td><code><strong>GET</strong>/country/code/{code}</code></td>
        <td><input id="getCountryByCode" class="form-control" value="" placeholder="CountryCode"/></td>
        <td>
            <button type="button" class="btn btn-info" onclick="RestGetByCode($('#getCountryByCode').val())">
                Получить
            </button>
        </td>
    </tr>
    <tr>
        <td><code><strong>GET</strong>/country/{country}</code></td>
        <td><input id="getCurrencyByName" class="form-control" value="" placeholder="CountryName"/></td>
        <td>
            <button type="button" class="btn btn-info" onclick="RestGetCurrency($('#getCurrencyByName').val())">
                Получить
            </button>
        </td>
    </tr>
</table>

<div class="panel panel-default">
    <div class="panel-heading">
        <strong>RESPONSE</strong>
    </div>
    <table class="table table-hover table-condensed">
        <thead>
        </thead>
        <tbody id="response"></tbody>
    </table>
</div>
</body>
</html>
