$(document).ready(function () {
    var add_modifySectionDialog;
    var loadPanel;
    var modificationMode = {
        addition : {value: 0},
        edition: {value: 1}
    };
    var currentSectionModificationMode;

    function showCatalogSections () {
        $("#loadPanel").dxLoadPanel("show");
        $.ajax("/products/getAllCatalogSections", {
            method: "GET",
            dataType: "json",
            timeout: 10000,
            contentType: "application/json; charset=UTF-8",
        })
            .done(function (resp) {
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
                var sectionsElement = $("#sections");
                sectionsElement.empty();
                sectionsElement.html(sectionsHtml);
                $("#loadPanel").dxLoadPanel("hide");
            })
            .fail(function (jqXHR, textStatus, errorThrown ) {
                $("#loadPanel").dxLoadPanel("hide");
                if (textStatus === "timeout") {
                    DevExpress.ui.notify("Нет ответа от сервера", "error");
                }
                else {
                    DevExpress.ui.notify("Ошибка сервера: " + jqXHR.status + " " + errorThrown, "error");
                }
            });
    }

    function addSection() {
        var sectionName = $("#sectionNameFormInput")[0].value;
        var json;
        if (sectionName.length !== 0) {
            json = {
                name: sectionName
            };
            $.ajax("/products/addCatalogSection", {
                method: "POST",
                dataType: "json",
                data: JSON.stringify(json),
                timeout: 10000,
                contentType: "application/json; charset=UTF-8",
            })
            .done(function () {
                add_modifySectionDialog.dialog("close");
                showCatalogSections();
            })
            .fail(function (jqXHR, textStatus, errorThrown ) {
                if (textStatus === "timeout") {
                    DevExpress.ui.notify("Нет ответа от сервера", "error");
                }
                else {
                    DevExpress.ui.notify("Ошибка сервера: " + jqXHR.status + " " + errorThrown, "error");
                }
            });
        }
        else {
            $("#sectionNameFormGroup").addClass("has-error");
            DevExpress.ui.notify("Наименование раздела каталога не может быть пустым", "error", 2000);
        }
    }

    $("tbody#sections").selectable({
        stop: function () {
            var numSelected = $(".ui-selected").length;
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

    add_modifySectionDialog = $("#add-modifySectionDialog").dialog({
        autoOpen: false,
        modal: true,
        title: "Добавление нового раздела",
        closeText: "Отмена",
        buttons: {
            "Создать": addSection,
            "Отмена": function() {
                add_modifySectionDialog.dialog("close")
            }
        },
        close: function() {
            $("#add-modifySectionForm")[0].reset();
            $("#sectionNameFormGroup").removeClass("has-error");
        }
    });

    $("#addButton").on("click", function () {
        currentSectionModificationMode = modificationMode.addition;
        add_modifySectionDialog.dialog.options("title", "Добавление нового раздела");
        add_modifySectionDialog.dialog("open");
    });

    $("#add-modifySectionForm").on("submit", function(event) {
        event.preventDefault();
        if (currentSectionModificationMode === modificationMode.addition) {
            addSection();
        }
    });

    $("#sectionNameFormInput").on("input", function () {
        $("#sectionNameFormGroup").removeClass("has-error");
    });

    loadPanel = $("#loadPanel").dxLoadPanel({
        shadingColor: "rgba(0,0,0,0.4)",
        position: { of: "#sections" },
        visible: false,
        showIndicator: true,
        showPane: true,
        shading: true,
        closeOnOutsideClick: false
    });

    showCatalogSections();
});
