var EVENT_CTRL = {
    EDIT_PRODUCT : "edit_product",
    NEW_PRODUCT : "new_product",
    DEL_PRODUCT : "del_product",
    LIST_PRODUCT : "list_product",
    SAVE_PRODUCT: "save_product"
}; 

var Controller = function(prodListView, prodEditView, prodModel) {
    Observer.call(this);
    var self = this;
    prodModel.registerObserver(prodListView);  // List View observes Model
    prodModel.registerObserver(prodEditView);  // Edit View observes Model
    prodListView.registerObserver(this);       // Controller observes List View
    prodEditView.registerObserver(this);       // Controller observes Edit View
    prodModel.init();
    this.notify = function(msg, val) {
        switch(msg) {
            case EVENT_CTRL.EDIT_PRODUCT: prodModel.editProduct(val); break;
            case EVENT_CTRL.LIST_PRODUCT: prodListView.show(); break;
            case EVENT_CTRL.NEW_PRODUCT: prodModel.newProduct(); break;
            case EVENT_CTRL.DEL_PRODUCT: prodModel.removeProduct(val); break;
            case EVENT_CTRL.SAVE_PRODUCT: prodModel.save(val);
                                          break;
        }
    };
};
