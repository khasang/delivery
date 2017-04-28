<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
<<<<<<< HEAD
    <script src="https://code.jquery.com/jquery-3.2.1.js" integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE=" crossorigin="anonymous"></script>
    <script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.15/js/dataTables.bootstrap.min.js"></script>
    <script src="https://cdn.datatables.net/select/1.2.2/js/dataTables.select.min.js"></script>
    <script src="https://cdn.datatables.net/buttons/1.3.1/js/dataTables.buttons.min.js"></script>
    <script src="https://cdn.datatables.net/buttons/1.3.1/js/buttons.bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/select/1.2.2/css/select.bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.3.1/css/buttons.bootstrap.min.css">
</head>

<body>
<script type="text/javascript">
    var service = '/document';
    $(document).ready(function() {
        var table = $('#result').dataTable( {
            "ajax": {
                url: service + "/all/",
                type: "GET",
                "dataSrc": ""
            },
            "columns": [
                { "data" : "id", "visible" : false, "searchable" : false },
                { "data" : "name", "title": "Документ"},
                { "data" : "specificInnerInfo", "visible" : false, "searchable" : false }
            ]
        } );


        $('#result tbody').on( 'click', 'tr', function () {
            if ( $(this).hasClass('selected') ) {
                $(this).removeClass('selected');
            }
            else {
                table.$('tr.selected').removeClass('selected');
                $(this).addClass('selected');
            }
        } );

        $('#button').click( function () {
            table.row('.selected').remove().draw( true );
        } );
    } );
</script>

<div class="panel panel-default">
    <div class="panel-heading">
        <strong>Documents</strong>
        <button id="button">Del</button>
    </div>
    <div class="panel-body">
        <table class="table" id="result">
            <thead>
                <tr>
                    <th>id</th>
                    <th>name</th>
                    <th>specificInnerInfo</th>
                </tr>
            </thead>
        </table>
=======
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>

<body>
    <script type="text/javascript">
       var service = '/document';
       var RestGet = function (id) {
           $.ajax({
               type: 'GET',
               url: service + "/get/id/" +id,
               dataType: 'json',
               async: false,
               success: function (result) {
                   $('#response').html(JSON.stringify(result));
               },
               error: function (jqXHR, textStatus, errorThrown) {
                   $('#response').html(JSON.stringify(jqXHR));
               }
           })
       }
       var RestPost = function (client_name) {
           var JSONObject = {
               'name': client_name
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
    </script>


    <table class="table">
        <thead/>
        <tr>
            <th>ID</th>
            <th>NAME</th>
        </tr>
        <tbody/>
        <tr>
            <td>Get Document by id</td>
            <td><code><strong>GET</strong>/document/get/id/{id}</code></td>
            <td>
                Id: <input id = "getDocumentID" value="3"/>
                <button type="button" onclick="RestGet($('#getDocumentID').val())">Try</button>
            </td>
        </tr>
        <tr>
            <td>Add document</td>
            <td><code><strong>POST</strong>/document/add</code></td>
            <td>
                <form class="form-inline">
                    name: <input type="text" id="postName" value="documentName"/>
                    <button type="button" onclick="RestPost($('#postName').val())">Try</button>
                </form>
            </td>

        </tr>
    </table>
    <div class="panel panel-default">
        <div class="panel-heading">
            <strong>RESPONSE</strong>
        </div>
        <div class="panel-body" id="response"></div>
>>>>>>> development
    </div>
</div>
</body>
</html>