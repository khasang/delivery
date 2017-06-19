<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Delivery - Разделы каталога продуктов</title>
        <script type="text/javascript" src="/js/jquery.min.js"></script>
        <script type="text/javascript" src="/js/jquery-ui.min.js"></script>
        <script type="text/javascript" src="/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="/js/product-catalog-sections-crud.js"></script>
        <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="/css/jquery-ui.min.css">
        <link rel="stylesheet" type="text/css" href="/css/jquery-ui.theme.min.css">
        <link rel="stylesheet" type="text/css" href="/css/bootstrap-theme.min.css" />
        <link rel="stylesheet" type="text/css" href="/css/delivery.css" />

    </head>

    <body>

    <div class="container-fluid">
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <div class="panel panel-default">
                    <div class="panel-heading">Разделы каталога продуктов</div>
                    <form id="sectionsForm">
                        <table class="table table-condensed">
                            <tbody id="sections">
                            </tbody>
                        </table>
                        <div class="btn-group btn-group-xs">
                            <button id="addButton" class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title="Добавить">
                                <span class="glyphicon glyphicon-plus"></span>
                            </button>
                            <button id="editButton" disabled class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title="Переименовать">
                                <span class="glyphicon glyphicon-pencil"></span>
                            </button>
                            <button id="deleteButton" disabled class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title="Удалить">
                                <span class="glyphicon glyphicon-trash"></span>
                            </button>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-md-4"></div>
        </div>
    </div>

    <div id="addSectionForm" title="Добавление нового раздела каталога продуктов">

    </div>

    </body>
</html>