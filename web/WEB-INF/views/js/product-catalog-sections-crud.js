$(document).ready(function () {
    $.getJSON("/products/getAllCatalogSections", function (resp, status) {
        var sections = "";
        $.each( resp, function( key, value ) {
            sections += "<tr>";
            sections += "<td>";
            sections += value.name;
            sections += "</td>";
            sections += "</tr>";
        });
        $("#sections").add(sections);
    })
})
