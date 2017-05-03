<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
   </head>
<body>
<jsp:include page="header.jsp"/>
<form class="form-horizontal">
    <div class="form-group">
        <div class="col-xs-offset-5 col-xs-3">
            <p><strong>РЕГИСТРАЦИЯ</strong></p>
        </div>
        <label for="postName" class="col-xs-5 control-label">Имя:</label>
        <div class="col-xs-3">
            <input type="name" class="form-control" id="postName" placeholder="Введите имя">
        </div>
    </div>
    <div class="form-group">
        <label for="inputaddres" class="col-xs-5 control-label">Адрес:</label>
        <div class="col-xs-3">
            <input type="addres" class="form-control" id="inputaddres" placeholder="Введите адрес доставки">
        </div>
    </div>
    <div class="form-group">
        <label for="phoneNumber" class="col-xs-5 control-label">Телефон:</label>
        <div class="col-xs-3">
            <input type="phoneNumber" class="form-control" id="phoneNumber" placeholder="Введите телефон">
        </div>
    </div>
    <div class="form-group">
        <label for="inputemail" class="col-xs-5 control-label">Email:</label>
        <div class="col-xs-3">
            <input type="email" class="form-control" id="inputemail" placeholder="Введите email">
        </div>
    </div>

    <div class="form-group">
        <div class="col-xs-offset-5 col-xs-3">
            <button type="button" onclick="RestPost($('#postName').val())">Подтвердить</button>
        </div>
    </div>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>
