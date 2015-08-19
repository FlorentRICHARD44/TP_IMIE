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

var ProductModel = function() {
    Subject.call(this);
    var self = this;
    var productList = [];
    var prodStorage = new ProductStorage();
    this.init = function() {
        var p1 = new Product();
        p1.id = 1;
        p1.label = 'Vélo';
        p1.price = 299.99;
        p1.imageUrl = "img/velo.jpeg";
        var p2 = new Product();
        p2.id = 2;
        p2.label = 'Chaussures';
        p2.price = 24.49;
        p2.imageUrl = "img/chaussure.jpeg";
        var p3 = new Product();
        p3.id = 3;
        p3.label = 'Crayon';
        p3.price = 0.39;
        p3.imageUrl = "img/crayon.jpeg";
        productList.push(p1);
        productList.push(p2);
        productList.push(p3);
        //prodStorage.storeProducts(productList);
        self.notifyObservers(EVENT_MODEL.LIST_UPDATED);
    }
    this.getProductList = function() {return prodStorage.readProducts();};
    this.save = function(product) {
        productList = prodStorage.readProducts();
        if (product.id == "") {        
            var maxId = 0;
            for (var i in productList) {
                if (productList[i].id > maxId) {
                    maxId = productList[i].id;
                }
            }
            product.id = maxId + 1;
            productList.push(product);
        } else {
            for (var i in productList) {
                if (productList[i].id == product.id) {
                    productList[i] = product;
                    break;
                }
            }
        }
        prodStorage.storeProducts(productList);
        self.notifyObservers(EVENT_MODEL.LIST_UPDATED);
    }
    this.newProduct = function() {
        var p = new Product();
        self.notifyObservers(EVENT_MODEL.NEW, p);
    }
    this.editProduct = function(product) {
        self.notifyObservers(EVENT_MODEL.EDIT, product);
    }
    this.removeProduct = function(product) {
        productList = prodStorage.readProducts();
        for (var index in productList) {
            if (productList[index].id == product.id) {
                productList.splice(index, 1);
            }
        }
        prodStorage.storeProducts(productList);
        self.notifyObservers(EVENT_MODEL.LIST_UPDATED);
    }
}
