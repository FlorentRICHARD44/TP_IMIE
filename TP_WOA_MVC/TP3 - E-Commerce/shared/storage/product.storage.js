
var SynchroAction = function(ajaxRequest, doneMethod, failMethod) {
    this.ajaxRequest = ajaxRequest;
    this.done = doneMethod;
    this.fail = failMethod;
};


var ProductStorage = function() {
    var self = this;
    this.storeProducts = function(productList) {
        localStorage.setItem("productList", JSON.stringify(productList));
    }
    this.readProducts = function() {
        return JSON.parse(localStorage.getItem("productList"));
    }
    this.storeServeurActions = function(actionList) {
        localStorage.setItem("synchroActions", JSON.stringify(actionList));
    }
    this.readServeurActions = function() {
        return JSON.parse(localStorage.getItem("synchroActions"));
    }
}

