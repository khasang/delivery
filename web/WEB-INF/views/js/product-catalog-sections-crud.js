$(document).ready(showCatalogSections());

function showCatalogSections() {
    $.getJSON("/products/getAllCatalogSections", function (resp, status) {
        var sectionsHtml = "";
        $.each( resp, function( key, value ) {
            sectionsHtml += "<tr>";
            sectionsHtml += "<td class=\"delivery-invisible\">";
            sectionsHtml += value.id;
            sectionsHtml += "</td>";
            sectionsHtml += "<td>";
            sectionsHtml += value.name;
            sectionsHtml += "</td>";
            sectionsHtml += "</tr>";
        });
        var sectionsElement = $("tbody#sections");
        sectionsElement.empty();
        sectionsElement.html(sectionsHtml);
    })
}

$(function () {
    var dialog;

    $("tbody#sections").selectable({
        stop: function () {
            var numSelected = $(".ui-selected", this).length;
            if (numSelected > 1) {
                $("#editButton").prop("disabled", true);
                $("#deleteButton").prop("disabled", false);
                return;
            }
            if (numSelected === 1) {
                $("#editButton").prop("disabled", false);
                $("#deleteButton").prop("disabled", false);
                return;
            }
            if (numSelected === 0) {
                $("#editButton").prop("disabled", true);
                $("#deleteButton").prop("disabled", true);
            }
        }
    });

    dialog = $("#addSectionForm").dialog({
        autoOpen: false,
        height: 400,
        width: 350,
        modal: true
    )}

    $("#addButton").on("click", function ({
        dialog.dialog("open");
    }))
});
