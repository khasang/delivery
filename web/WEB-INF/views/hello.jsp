<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3/1/1//jquery.min.js" type="text/javascript">
    </script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>
<body>
<p>${info}</p>
<p>${answ}</p>
<jsp:include page="header.jsp"/>
<jsp:include page="news.jsp"/>
<form class="form-horizontal">
    <div class="form-group">
        <div class="col-xs-offset-5 col-xs-3">
            <p><strong>Вход</strong></p>
        </div>
    </div>
    <div class="form-group">
        <label for="Email" class="col-xs-5 control-label">Login:</label>
        <div class="col-xs-3">
            <input type="Email" class="form-control" id="Email" placeholder="Введите Email">
        </div>
    </div>
    <div class="form-group">
        <div class="col-xs-offset-5 col-xs-4">
            <button type="button">Войти</button>
        </div>
    </div>
    <div class="form-group">
        <div class="col-xs-offset-5 col-xs-4">
            <p><b>Вы у нас впервые?</b></p>
            </p>
            <p><a href="/customer">Регистрация</a></p>
            <p><a href="/noregistration">Без регистрации</a></p>
        </div>
    </div>
</form>
</center>
<jsp:include page="footer.jsp"/>
</body>
</html>
