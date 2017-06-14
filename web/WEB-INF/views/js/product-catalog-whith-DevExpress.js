var productCatalogSectionStore = new DevExpress.data.CustomStore({

    load: function(loadOptions) {
        return $.getJSON("/products/getAllCatalogSections");
    },

    byKey: function(key) {
        return $.getJSON("/products/getCatalogSectionById/" + encodeURIComponent(key));
    },

    insert: function(values) {
        return $.post("/products/addCatalogSection", values);
    },

    update: function(key, values) {
        return $.ajax({
            url: "/products/updateCatalogSection",
            method: "PUT",
            data: values
        });
    },

    remove: function(key) {
        return $.ajax({
            url: "/products/deleteCatalogSection/" + encodeURIComponent(key),
            method: "DELETE"
        });
    }
});

var productCatalogSectionDataSource = new DevExpress.data.DataSource(productCatalogSectionStore);

$(document).ready(function() {
    $("#productCatalogSections").dxMenu({
        dataSource: productCatalogSectionDataSource,
        orientation: "vertical",
        displayExpr: "name"
    })
})
