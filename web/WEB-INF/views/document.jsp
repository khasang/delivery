<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
               error: function (jqXHR, textStatus, errorThrown) {
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
    </div>
</body>
</html>
