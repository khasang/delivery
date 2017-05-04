<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- DevExtreme dependencies -->
    <script src="https://code.jquery.com/jquery-3.2.1.js" integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE=" crossorigin="anonymous"></script>
    <!-- DevExtreme themes -->
    <link rel="stylesheet" type="text/css" href="https://cdn3.devexpress.com/jslib/16.2.6/css/dx.common.css" />
    <link rel="stylesheet" type="text/css" href="https://cdn3.devexpress.com/jslib/16.2.6/css/dx.light.css" />
    <!-- A DevExtreme library -->
    <script type="text/javascript" src="https://cdn3.devexpress.com/jslib/16.2.6/js/dx.all.js"></script>
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
        </div>
    </div>
</body>
</html>