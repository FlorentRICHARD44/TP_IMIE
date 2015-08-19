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
    //prodModel.registerObserver(prodEditView);  // Edit View observes Model
    prodListView.registerObserver(this);       // Controller observes List View
    prodEditView.registerObserver(this);       // Controller observes Edit View
    prodModel.init();
    this.notify = function(msg, val) {
        switch(msg) {
            case EVENT_CTRL.EDIT_PRODUCT: self.applyEditView();
                                          prodModel.editProduct(val);
                                          break;
            case EVENT_CTRL.LIST_PRODUCT: self.applyListView();
                                          prodListView.show();
                                          break;
            case EVENT_CTRL.NEW_PRODUCT: self.applyEditView();
                                         prodModel.newProduct();
                                         break;
            case EVENT_CTRL.DEL_PRODUCT: prodModel.removeProduct(val); break;
            case EVENT_CTRL.SAVE_PRODUCT: console.log("ctrl save action");
                                          self.applyListView();
                                          prodModel.save(val); break;
        }
    };
    this.applyEditView = function() {
        prodModel.unregisterObserver(prodListView);
        prodModel.registerObserver(prodEditView);
        prodListView.hide();
        prodEditView.show();
    }
    this.applyListView = function() {
        prodModel.unregisterObserver(prodEditView);
        prodModel.registerObserver(prodListView);
        prodEditView.hide();
        prodListView.show();
    }
};
