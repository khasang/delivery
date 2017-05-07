var service = '/admin/users';
var SaveUser = function () {
    var id = $('#id').val();
    if (id==-1) {
        var JSONObject = {
            'login': $('#login').val(),
            'role': $('#role').val(),
            'password': $('#password').val(),
            'active': $('#active').prop('checked')
        };
        $.ajax({
            type: 'POST',
            url: service + "/add",
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(JSONObject),
            dataType: 'json',
            async: false,
            success: function (result) {
                window.location.replace('/admin/users');
            },
            error: function (jqXHR, textStatus, errorThrpwn) {
                $('#response').html(JSON.stringify(jqXHR));
            }
        });
    } else {
        var JSONObject = {
            'id': $('#id').val(),
            'login': $('#login').val(),
            'role': $('#role').val(),
            'password': $('#password').val(),
            'active': $('#active').prop('checked')
        };
        $.ajax({
            type: 'PUT',
            url: service + "/update",
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(JSONObject),
            dataType: 'json',
            async: false,
            success: function (result) {
                window.location.replace('/admin/users');
            },
            error: function (jqXHR, textStatus, errorThrpwn) {
                $('#response').html(JSON.stringify(jqXHR));
            }
        });
    }
};

var GetUser = function () {
    var id = $('#id').val();
    if (id!=-1) {
        $.ajax({
            type: 'GET',
            url: service + "/get/id/" +id,
            dataType: 'json',
            async: false,
            success: function (result) {
                $('#login').val(result.login);
                $('#role').val(result.role);
                $('#active').val(result.active==true ? 'checked' : null);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR));
            }
        })
    }
};

window.onload=GetUser;
