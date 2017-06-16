<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Delivery - Разделы каталога продуктов</title>
        <!-- DevExtreme dependencies -->
        <%--<script src="https://code.jquery.com/jquery-3.2.1.js" integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE=" crossorigin="anonymous"></script>--%>
        <!-- DevExtreme themes -->
        <%--<link rel="stylesheet" type="text/css" href="https://cdn3.devexpress.com/jslib/16.2.6/css/dx.common.css" />--%>
        <%--<link rel="stylesheet" type="text/css" href="https://cdn3.devexpress.com/jslib/16.2.6/css/dx.light.css" />--%>
        <!-- A DevExtreme library -->
        <%--<script type="text/javascript" src="https://cdn3.devexpress.com/jslib/16.2.6/js/dx.all.js"></script>--%>
        <script type="text/javascript" src="/js/jquery.min.js"></script>
        <script type="text/javascript" src="/js/product-catalog-sections-crud.js"></script>
        <link rel="stylesheet" type="text/css" href="/css/bootstrap.css" />
        <link rel="stylesheet" type="text/css" href="/css/bootstrap-theme.css" />
    </head>

    <body class="dx-viewport">

        <div class="panel panel-default">
            <div class="panel-heading">Разделы каталога продуктов</div>
            <table class="table table-hover table-condensed">
                <tbody id="sections">
                </tbody>
            </table>
            <div class="btn-group btn-group-xs">
                <button type="button" class="btn btn-default">
                    <span class="glyphicon glyphicon-plus"></span>
                    Добавить
                </button>
                <button type="button" class="btn btn-default">
                    <span class="glyphicon glyphicon-pencil"></span>
                    Переименовать
                </button>
                <button type="button" class="btn btn-default">
                    <span class="glyphicon glyphicon-trash"></span>
                    Удалить
                </button>
            </div>
        </div>

    </body>
</html>