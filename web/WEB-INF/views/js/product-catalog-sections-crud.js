$(document).ready(function () {
    var addProductCatalogSectionDialog;

    function showCatalogSections () {
        $.getJSON("/products/getAllCatalogSections", function (resp) {
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
        });
    }

    function addSection() {
        var valid = true;
        addProductCatalogSectionDialog.dialog("close");
        return valid;
    }

    showCatalogSections();

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

    addProductCatalogSectionDialog = $("#addSectionDialog").dialog({
        autoOpen: false,
        modal: true,
        height: "auto",
        width: "auto",
        buttons: {
            "Создать": addSection,
            "Отмена": function() {
                addProductCatalogSectionDialog.dialog("close");
            }
        },
        close: function() {
            $("#addSectionForm").reset();
            $("#sectionName").removeClass("ui-state-error");
        }
    });

    $("#addButton").on("click", function () {
        addProductCatalogSectionDialog.dialog("open");
        showCatalogSections();
    });

    $("#addSectionForm").on("submit", function(event) {
        event.preventDefault();
        addSection();
    });

});
