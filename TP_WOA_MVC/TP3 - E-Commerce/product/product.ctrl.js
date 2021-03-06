// Events produced by the views.
var EVENT_CTRL = {
    EDIT_PRODUCT : "edit_product",
    NEW_PRODUCT : "new_product",
    DEL_PRODUCT : "del_product",
    LIST_PRODUCT : "list_product",
    SAVE_PRODUCT: "save_product"
}; 

// Controller
var Controller = function(prodListView, prodEditView, prodModel) {
    Observer.call(this);
    var self = this;

    this.init = function() {
        prodModel.registerObserver(prodListView);  // List View observes Model
        prodListView.registerObserver(this);       // Controller observes List View
        prodEditView.registerObserver(this);       // Controller observes Edit View
        prodModel.init();
        this.applyListView();
    }

    // Notify called by Subject(s)
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
            case EVENT_CTRL.SAVE_PRODUCT: self.applyListView();
                                          prodModel.save(val); break;
        }
    };

    // Apply the View Product Edition
    this.applyEditView = function() {
        prodModel.unregisterObserver(prodListView);
        prodModel.registerObserver(prodEditView);
        prodListView.hide();
        prodEditView.show();
    }

    // Apply the View Product List
    this.applyListView = function() {
        prodModel.unregisterObserver(prodEditView);
        prodModel.registerObserver(prodListView);
        prodEditView.hide();
        prodListView.show();
    }
};
