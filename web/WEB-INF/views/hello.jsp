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
<center>
    <%--<form name="FormEnter"--%>
          <%--method="post"--%>
          <%--action="/registration">--%>
        <p></p>
        <p><strong>Регистрация</strong></p>
        <hr>
        <p>Телефон/Электронная почта</p>
        <p>
        <p><input type=textbox name="p" size="25" value=""></p>
        <p><input type=submit value="Вход"></p>
        <hr>
        <p>
            <a><b>??? ВХОД ЧЕРЕЗ СОЦСЕТИ ???</b></a>
        </p>
        <p>
        <p><b>Вы у нас впервые?</b></p>
        </p>
        <p><a href="/registration">Регистрация</a></p>
        <p><a href="/noregistration">Без регистрации</a></p>
    <%--</form>--%>
</center>
<jsp:include page="footer.jsp"/>
</body>
</html>
