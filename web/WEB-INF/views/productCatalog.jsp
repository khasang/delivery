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
            productCatalogSectionDataSource.load();
            $("#productCatalogSections").dxMenu({
                dataSource: productCatalogSectionDataSource,
                orientation: "vertical"
            });
        })
    </script>

    <div class="panel panel-default">
        <div class="panel-heading">
            <strong>Documents</strong>
            <button id="button">Del</button>
        </div>
        <div id="productCatalogSections"></div>
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