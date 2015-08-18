var EVENT_MODEL = {
    LIST_UPDATED: "list_updated",
    NEW: "new",
    EDIT: "edit"
}

var Product = function() {
    var id;
    var label = "";
    var price = 0.00;
    var imageUrl = "";
    this.getId = function() {return id;};
    this.setId = function(newId) {id = newId;};
    this.getLabel = function() {return label;};
    this.setLabel = function(newLabel) {label = newLabel;};
    this.getPrice = function() {return price;};
    this.setPrice = function(newPrice) {price = newPrice;};
    this.getImageUrl = function() {return imageUrl;};
    this.setImageUrl = function(newImageUrl) {imageUrl = newImageUrl;};
};

var ProductModel = function() {
    Subject.call(this);
    var self = this;
    var productList = [];
    this.init = function() {
        var p1 = new Product();
        p1.setId(1);
        p1.setLabel('Vélo');
        p1.setPrice(299.99);
        p1.setImageUrl("img/velo.jpeg");
        var p2 = new Product();
        p2.setId(2);
        p2.setLabel('Chaussures');
        p2.setPrice(24.49);
        p2.setImageUrl("img/chaussure.jpeg");
        var p3 = new Product();
        p3.setId(3);
        p3.setLabel('Crayon');
        p3.setPrice(0.39);
        p3.setImageUrl("img/crayon.jpeg");
        productList.push(p1);
        productList.push(p2);
        productList.push(p3);
        self.notifyObservers(EVENT_MODEL.LIST_UPDATED);
    }
    this.getProductList = function() {return productList;};
    this.save = function(product) {
        if (product.getId() == "") {        
            var maxId = 0;
            for (var i in productList) {
                if (productList[i].getId() > maxId) {
                    maxId = productList[i].getId();
                }
            }
            product.setId(maxId + 1);
            productList.push(product);
        } else {
            for (var i in productList) {
                if (productList[i].getId() == product.getId()) {
                    productList[i] = product;
                    break;
                }
            }
        }
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
        productList.splice(productList.indexOf(product), 1);
        self.notifyObservers(EVENT_MODEL.LIST_UPDATED);
    }
}
