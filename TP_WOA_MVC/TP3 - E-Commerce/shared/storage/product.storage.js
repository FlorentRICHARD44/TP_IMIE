var ProductStorage = function() {
    this.storeProducts = function(productList) {
        localStorage.setItem("productList", JSON.stringify(productList));
    }
    this.readProducts = function() {
        return JSON.parse(localStorage.getItem("productList"));
    }
}

