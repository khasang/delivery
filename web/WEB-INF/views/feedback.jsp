<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Отзывы</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <style>
        table {
            table-layout: fixed;
            width: 100%;
        }

        td {
            overflow-x: hidden;
            word-wrap: break-word;
        }
    </style>
</head>
<body onload="AllFeedBacks()">
<script type="text/javascript">
    var table = '';
    var thead = '';
    var tr = '';
    var tbody = '';

    table = document.createElement('table');
    table.className = "table table-bordered";
    thead = document.createElement('thead');
    tr = document.createElement('tr');
    tr.className = "active";
    tr.innerHTML = '<th width="20%">Дата</th><th>Текст</th>';
    thead.appendChild(tr);

    var service = '/feedback';
    var AddFeedBack = function (feedback_date, feedback_text) {
        var JSONObject = {
            'date': feedback_date,
            'feedBackText': feedback_text

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

    var AllFeedBacks = function () {
        table.innerHTML='';
        $.ajax({
            type: 'GET',
            url: service + "/all",
            dataType: 'json',
            async: false,
            success: function (result) {
                $('#respons').html(JSON.stringify(result));
                if(result.length > 0){
                    tbody = document.createElement('tbody');
                    for(var i = result.length-1; i >= 0; i--){
                        tbody.innerHTML += '<tr class="info"><td>' + new Date(result[i].date) +
                            '</td><td><table width="100%"><tr><th>' +
                            '<button id ="btnId' + i.val() + '" value="' + i.val() + '" ' +
                            'onclick="DelText($(\'#btnId\').val()); AllFeedBacks()" ' +
                            'type="button" class="btn btn-primary pull-right btn-sx">' +
                            '<span class="glyphicon glyphicon-remove">' +
                            '</span></button>' +
                            '</th></tr><tr><td width="100%">' + result[i].feedBackText
                            + '</td></tr></table></td></tr>';
                    }

                    table.appendChild(thead);
                    table.appendChild(tbody);
                    document.getElementById('feedbacks').appendChild(table);
                }


            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#respons').html(JSON.stringify(jqXHR));
            }
        });


    };
    var DelText = function (id) {

        $.ajax({
            type: 'DELETE',
            url: service + "/delete/" + id,
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result));
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR));
            }
        })
    };
</script>
<div class="col-md-3">
</div>
<div class="col-md-6 table-responsive">
    <textarea rows="4" class="form-control" id="feedBackText" placeholder="Нам важно Ваше мнение.. (нет)"></textarea>
    <button class="btn btn-large btn-primary btn-block" type="button"
            onclick="AddFeedBack(new Date().toJSON(),$('#feedBackText').val()); AllFeedBacks()">Оставить отзыв
    </button>

    <br>
    <table width="100%" id ="feedbacks">
    </table>
</div>
<div class="col-md-3">
</div>
</body>
</html>