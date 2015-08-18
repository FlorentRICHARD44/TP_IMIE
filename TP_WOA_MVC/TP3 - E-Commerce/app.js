$(function() {
    var productModel = new ProductModel();
    var productListView = new ProductListView(productModel);
    var productEditView = new ProductEditView();
    var ctrl = new Controller(productListView, productEditView, productModel);
});

