var EVENT_MODEL = {
    LIST_UPDATED: "list_updated",
    NEW: "new",
    EDIT: "edit"
}

var Product = function() {
    this.id = undefined;
    this.label = "";
    this.price = 0.00;
    this.imageUrl = "";
};

var AjaxRequest = function(url, method, data, contentType) {
    this.url = url;
    this.method = method;
    this.data = data;
    this.contentType = contentType;
};

var ProductModel = function() {
    Subject.call(this);
    var self = this;
    this.init = function() {
        var actionList = []
        self.prodStorage = new ProductStorage();
        self.prodStorage.storeServeurActions(actionList);
        self.synchronize();
        setInterval(self.synchronize, 10000);
    }
    this.getProductList = function() {return self.prodStorage.readProducts();};
    this.save = function(product) {
        console.log("model save")
        productList = self.prodStorage.readProducts();
        var actionList = self.prodStorage.readServeurActions();
        if (product.id == "") {        
            product.id = null;
            actionList.push(new SynchroAction(new AjaxRequest('http://localhost:8080/Service_Rest/rest/products',
                                                              "POST",
                                                              product, "application/json"),
                                                          null,
                                                          null));
            self.prodStorage.storeServeurActions(actionList);
        } else {
            actionList.push(new SynchroAction(new AjaxRequest('http://localhost:8080/Service_Rest/rest/products',
                                                              "PUT",
                                                              product, "application/json"),
                                                          null,
                                                          null));
            self.prodStorage.storeServeurActions(actionList);
        }
    }
    this.newProduct = function() {
        var p = new Product();
        self.notifyObservers(EVENT_MODEL.NEW, p);
    }
    this.editProduct = function(product) {
        self.notifyObservers(EVENT_MODEL.EDIT, product);
    }
    this.removeProduct = function(product) {
        var actionList = self.prodStorage.readServeurActions();
        actionList.push(new SynchroAction(new AjaxRequest("http://localhost:8080/Service_Rest/rest/products",
                                                          "DELETE",
                                                          product, "application/json"),
                                                 null,
                                                 null)); 
        self.prodStorage.storeServeurActions(actionList);
        
    }
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
