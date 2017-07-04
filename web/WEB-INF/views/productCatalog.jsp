<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Delivery - Разделы каталога продуктов</title>
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.js"></script>
        <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <script type="text/javascript" src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script type="text/javascript" src="js/dx.all.js"></script>
        <script type="text/javascript" src="js/product-catalog-sections-crud.js"></script>
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" type="text/css" href="css/dx.common.css" />
        <link rel="stylesheet" type="text/css" href="css/dx.light.css" />
        <link rel="stylesheet" type="text/css" href="css/delivery.css" />

    </head>

    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-4"></div>
                <div class="col-md-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">Разделы каталога продуктов</div>
                        <table class="table table-condensed">
                            <tbody id="sections">
                            </tbody>
                        </table>
                        <div class="btn-group btn-group-xs">
                            <button id="addButton" class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title="Добавить">
                                <span class="glyphicon glyphicon-plus"></span>
                            </button>
                            <button id="editButton" class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title="Переименовать">
                                <span class="glyphicon glyphicon-pencil"></span>
                            </button>
                            <button id="deleteButton" class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title="Удалить">
                                <span class="glyphicon glyphicon-trash"></span>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div id="add-modifySectionDialog">
            <form id="add-modifySectionForm">
                <div id="sectionNameFormGroup" class="form-group">
                    <label class="control-label" for="sectionNameFormInput">Раздел</label>
                    <input type="text" id="sectionNameFormInput" name="name" class="form-control">
                </div>
                <input type="hidden" id="sectionIdFormInput" name="id">
            </form>
        </div>

        <div id="deleteSectionDialog">
            <p>
                <span class="glyphicon glyphicon-question-sign"></span>
                Уверены, что хотите удалить выбранные разделы каталога?
            </p>
        </div>

        <div id="loadPanel"></div>
    </body>
</html>