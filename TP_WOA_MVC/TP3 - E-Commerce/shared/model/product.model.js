// Event produced by the Model.
var EVENT_MODEL = {
    LIST_UPDATED: "list_updated",
    NEW: "new",
    EDIT: "edit"
}

// Class Product
var Product = function() {
    this.id = undefined;
    this.label = "";
    this.price = 0.00;
    this.imageUrl = "";
};

// Class AjaxRequest
var AjaxRequest = function(url, method, data, contentType) {
    this.url = url;
    this.method = method;
    this.data = data;
    this.contentType = contentType;
};

// Class SynchroAction:
var SynchroAction = function(ajaxRequest, doneMethod, failMethod) {
    this.ajaxRequest = ajaxRequest;
    this.done = doneMethod;
    this.fail = failMethod;
};

// Model for product.
var ProductModel = function() {
    Subject.call(this);
    var self = this;
    // Initialisation of the model.
    this.init = function() {
        var actionList = []
        self.prodStorage = new ProductStorage();
        self.prodStorage.storeServeurActions(actionList);
        self.synchronize();
        setInterval(self.synchronize, 10000);
    }
    // Getter for the product List from storage
    this.getProductList = function() {return self.prodStorage.readProducts();};
    // Save a product
    this.save = function(product) {
        productList = self.prodStorage.readProducts();
        var actionList = self.prodStorage.readServeurActions();
        if (product.id == "") {  // New Product to create.   
            product.id = null;
            actionList.push(new SynchroAction(new AjaxRequest('http://localhost:8080/Service_Rest/rest/products',
                                                              "POST",
                                                              product, "application/json"),
                                                          null,
                                                          null));
            self.prodStorage.storeServeurActions(actionList);
            productList.push(product);
        } else {  // Product to modify
            actionList.push(new SynchroAction(new AjaxRequest('http://localhost:8080/Service_Rest/rest/products',
                                                              "PUT",
                                                              product, "application/json"),
                                                          null,
                                                          null));
            self.prodStorage.storeServeurActions(actionList);
            for (var ind in productList) {
                if (productList[ind].id == product.id) {
                    productList[ind] = product;
                    break;
                }
            }
        }
        self.prodStorage.storeProducts(productList);
        self.notifyObservers(EVENT_MODEL.LIST_UPDATED);
    }
    // Prepare a new Producted to be edited.
    this.newProduct = function() {
        var p = new Product();
        self.notifyObservers(EVENT_MODEL.NEW, p);
    }
    // Edit an existing product.
    this.editProduct = function(product) {
        self.notifyObservers(EVENT_MODEL.EDIT, product);
    }
    // Delete a product.
    this.removeProduct = function(product) {
        var actionList = self.prodStorage.readServeurActions();
        actionList.push(new SynchroAction(new AjaxRequest("http://localhost:8080/Service_Rest/rest/products",
                                                          "DELETE",
                                                          product, "application/json"),
                                                 null,
                                                 null)); 
        self.prodStorage.storeServeurActions(actionList);
        productList = self.prodStorage.readProducts();
        for (var ind in productList) {
            if (productList[ind].id == product.id) {
                productList.splice(ind, 1);
                break;
            }
        }
        self.prodStorage.storeProducts(productList);
        self.notifyObservers(EVENT_MODEL.LIST_UPDATED);
    }
    // Synchronize the products with persistance in server.
    this.synchronize = function() {
        var actionList = self.prodStorage.readServeurActions();
        while(actionList.length > 0) {
            action = actionList.shift();            
            $.ajax({url: action.ajaxRequest.url,
                    method: action.ajaxRequest.method,
                    data: JSON.stringify(action.ajaxRequest.data),
                    contentType : action.ajaxRequest.contentType})
                    .done(function(data) {console.log("action done")})
                    .fail(function(data) {console.log("action fail")});
        }
        self.prodStorage.storeServeurActions(actionList);
        $.ajax({url: 'http://localhost:8080/Service_Rest/rest/products',
                method: "GET"})
                .done(function(data){self.prodStorage.storeProducts(data); self.notifyObservers(EVENT_MODEL.LIST_UPDATED);})
    }
}
