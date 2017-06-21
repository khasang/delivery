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
        var sectionName = $("#addSectionForm input[name='name']")[0].value;
        var json;
        if (sectionName.length !== 0) {
            json = $("#addSectionForm").serializeJSON();
            $.ajax("/products/addCatalogSection", {
                method: "POST",
                dataType: "json",
                data: json,
                timeout: 180000,
                contentType: "application/json; charset=UTF-8",
                success: function (data, textStatus, jqXHR) {
                    addProductCatalogSectionDialog.dialog("close");
                    showCatalogSections();
                },
                error: function (jqXHR, textStatus, errorThrown ) {
                    if (textStatus === "timeout") {
                        $("body").popover({
                            content: "Нет ответа от сервера",
                            title: "Ошибка сервера",
                            selector: "#addSectionDialog"
                        });
                    }
                    else {
                        $("body").popover({
                            content: errorThrown,
                            title: "Ошибка сервера",
                            selector: "#addSectionDialog"
                        });
                    }
                }
            });
        }
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
        title: "Добавление нового раздела",
        buttons: {
            "Создать": addSection,
            "Отмена": function() {
                addProductCatalogSectionDialog.dialog("close")
            }
        },
        close: function() {
            $("#addSectionForm")[0].reset();
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
