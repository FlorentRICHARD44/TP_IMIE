/******************************
/ Pattern Observer
/*****************************/
// Observer: Interface for an observer.
var Observer = function() {
    this.notify = function(msg, val) {
        throw "Cet objet observer ne peut rien faire";        
    };
};
// Subject: Interface for a subject to be observed.
var Subject = function() {
    var observers = [];  // Set of observers
    this.registerObserver = function(obs) {
        if(observers.indexOf(obs) < 0) {
            observers.push(obs);
        }
    };
    this.unregisterObserver = function(obs) {
        observers.splice(observers.indexOf(obs), 1);
    };
    this.notifyObservers = function(msg, val) {
        observers.forEach(function(obs) { obs.notify(msg, val);});
    };
};

