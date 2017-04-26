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
</head>
<body onload="AllFeedBacks()">
<script type="text/javascript">
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
        $.ajax({
            type: 'GET',
            url: service + "/all",
            dataType: 'json',
            async: false,
            success: function (result) {
                var JSONobj = JSON.stringify(result);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#respons').html(JSON.stringify(jqXHR));
            }
        })
    };
</script>
<div class="col-md-3">
</div>
<div class="col-md-6 table-responsive">
    <table class="table table-bordered">
        <thead>
        <tr>
            <textarea rows="4" class="form-control" id="feedBackText"
                      placeholder="Нам важно Ваше мнение.. (нет)"></textarea>
            <button class="btn btn-large btn-primary btn-block" type="button"
                    onclick="AddFeedBack(new Date().toJSON(),$('#feedBackText').val()); AllFeedBacks()">Оставить отзыв
            </button>

        </tr>
        <br>
        <tr class="active">
            <td width="100">Дата</td>
            <td width="300">
                Отзыв
            </td>
        </tr>
        </thead>
        <tbody>
        <tr class="info">
            <td></td>
            <td>
            </td>
        </tr>
        </tbody>
    </table>
</div>
<div class="col-md-3">
</div>
</body>
</html>
