$(document).ready(function () {
    $.getJSON("/products/getAllCatalogSections", function (resp, status) {
        var sectionsHtml = "";
        $.each( resp, function( key, value ) {
            sectionsHtml += "<tr>";
            sectionsHtml += "<td>";
            sectionsHtml += value.name;
            sectionsHtml += "</td>";
            sectionsHtml += "</tr>";
        });
        var sectionsElement = $("tbody#sections");
        sectionsElement.empty();
        sectionsElement.html(sectionsHtml);
    })
})
