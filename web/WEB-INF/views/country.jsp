<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CountryDetails</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>

    <script type="text/javascript">
        var service = '/country';

        var parseResult = function (result) {
            var table = document.getElementById('response');

            while (table.firstChild) {
                table.removeChild(table.firstChild);
            }
            var tr = document.createElement('tr');
            var td = document.createElement('td');

            if (result.length) {
                for (var i = 0; i < result.length; i++) {
                    tr = document.createElement('tr');
                    td = document.createElement('td');
                    td.innerHTML = "Country Code";
                    tr.appendChild(td);

                    td = document.createElement('td');
                    td.innerHTML = result[i].countryCode;
                    tr.appendChild(td);
                    table.appendChild(tr);

                    tr = document.createElement('tr');
                    td = document.createElement('td');
                    td.innerHTML = "Name";
                    tr.appendChild(td);

                    td = document.createElement('td');
                    td.innerHTML = result[i].name;
                    tr.appendChild(td);
                    table.appendChild(tr);

                    tr = document.createElement('tr');
                    td = document.createElement('td');
                    td.innerHTML = "Currency";
                    tr.appendChild(td);

                    td = document.createElement('td');
                    td.innerHTML = result[i].currency;
                    tr.appendChild(td);
                    table.appendChild(tr);

                    tr = document.createElement('tr');
                    td = document.createElement('td');
                    td.innerHTML = "CurrencyCode";
                    tr.appendChild(td);

                    td = document.createElement('td');
                    td.innerHTML = result[i].currencyCode;
                    tr.appendChild(td);
                    table.appendChild(tr);
                }
            } else {
                tr = document.createElement('tr');
                td = document.createElement('td');
                td.innerHTML = "Country Code";
                tr.appendChild(td);

                td = document.createElement('td');
                td.innerHTML = result.countryCode;
                tr.appendChild(td);
                table.appendChild(tr);

                tr = document.createElement('tr');
                td = document.createElement('td');
                td.innerHTML = "Name";
                tr.appendChild(td);

                td = document.createElement('td');
                td.innerHTML = result.name;
                tr.appendChild(td);
                table.appendChild(tr);

                tr = document.createElement('tr');
                td = document.createElement('td');
                td.innerHTML = "Currency";
                tr.appendChild(td);

                td = document.createElement('td');
                td.innerHTML = result.currency;
                tr.appendChild(td);
                table.appendChild(tr);

                tr = document.createElement('tr');
                td = document.createElement('td');
                td.innerHTML = "CurrencyCode";
                tr.appendChild(td);

                td = document.createElement('td');
                td.innerHTML = result.currencyCode;
                tr.appendChild(td);
                table.appendChild(tr);
            }
        };

        var RestGetByCountryCode = function (code) {
            $.ajax({
                type: 'GET',
                url: service + "/code/" + code,
                dataType: 'json',
                async: false,
                success: parseResult,
                error: function (jqXHR, textStatus, errorThrown) {
                    $('#response').html(JSON.stringify(jqXHR));
                }
            })
        };

        var RestGetByCurrencyName = function (currencyName) {
            $.ajax({
                type: 'GET',
                url: service + "/currency/name/" + currencyName,
                dataType: 'json',
                async: false,
                success: parseResult,
                error: function (jqXHR, textStatus, errorThrown) {
                    $('#response').html(JSON.stringify(jqXHR));
                }
            })
        };

        var RestGetByCurrencyCode = function (currencyCode) {
            $.ajax({
                type: 'GET',
                url: service + "/currency/" + currencyCode,
                dataType: 'json',
                async: false,
                success: parseResult,
                error: function (jqXHR, textStatus, errorThrown) {
                    $('#response').html(JSON.stringify(jqXHR));
                }
            })
        };

        var RestGetCurrencyByCountry = function (country) {
            $.ajax({
                type: 'GET',
                url: service + "/name/" + country,
                dataType: 'json',
                async: false,
                success: parseResult,
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
        <td><input id="CountryCode" class="form-control" value="" placeholder="CountryCode"/></td>
        <td>
            <button type="button" class="btn btn-info" onclick="RestGetByCountryCode($('#CountryCode').val())">
                Получить
            </button>
        </td>
    </tr>
    <tr>
        <td><code><strong>GET</strong>/country/currency/name/{currencname}</code></td>
        <td><input id="CurrencyName" class="form-control" value="" placeholder="CurrencyName"/></td>
        <td>
            <button type="button" class="btn btn-info" onclick="RestGetByCurrencyName($('#CurrencyName').val())">
                Получить
            </button>
        </td>
    </tr>
    <tr>
        <td><code><strong>GET</strong>/country/currency/{currencycode}</code></td>
        <td><input id="CurrencyCode" class="form-control" value="" placeholder="CurrencyCode"/></td>
        <td>
            <button type="button" class="btn btn-info" onclick="RestGetByCurrencyCode($('#CurrencyCode').val())">
                Получить
            </button>
        </td>
    </tr>
    <tr>
        <td><code><strong>GET</strong>/country/name/{country}</code></td>
        <td><input id="Country" class="form-control" value="" placeholder="CountryName"/></td>
        <td>
            <button type="button" class="btn btn-info" onclick="RestGetCurrencyByCountry($('#Country').val())">
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
