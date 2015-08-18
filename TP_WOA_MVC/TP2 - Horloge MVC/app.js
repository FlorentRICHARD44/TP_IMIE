function zeroPad(number,base){
    var res = "" + number;
    while (res.length < base) {
        res = "0" + res;    
    }
    return res;
}

/******************************
/ Pattern Observer
/*****************************/
// Observer: Interface for an observer.
var Observer = function() {
    this.notify = function(msg) {
        throw new Exception("Cet objet observer ne peut rien faire");        
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
    this.notifyObservers = function(msg) {
        observers.forEach(function(obs) { obs.notify(msg);});
    };
};

$(function() {
    /****************************
    / Object View: Operations on the view.
    / -> Observer
    / -> Subject
    *****************************/
    var View = function() {
        Observer.call(this);
        Subject.call(this);
        var thisview = this;
        $('button#addhour').on('click', function() {
            thisview.notifyObservers('ADD_1_HOUR');
        });
        $('button#delhour').on('click', function() {
            thisview.notifyObservers('DEL_1_HOUR');
        });
        $('button#addminute').on('click', function() {
            thisview.notifyObservers('ADD_1_MINUTE');
        });
        $('button#delminute').on('click', function() {
            thisview.notifyObservers('DEL_1_MINUTE');
        });
        this.notify = function(msg) {
            $('#hour').text(zeroPad(model.getHour(), 2)); 
            $('#minute').text(zeroPad(model.getMinute(), 2)); 
            $('#second').text(zeroPad(model.getSecond(), 2));        
        }
    }

    /****************************
    / Object Model: Model of data and services
    / -> Subject
    *****************************/
    var Model = function() {
        Subject.call(this);
        var time = 0;
        this.getHour = function() {return (Math.floor(time / 3600) % 24);};
        this.getMinute = function() {return (Math.floor(time / 60) % 60);};
        this.getSecond = function() {return time % 60;};
        this.increment = function(val) {
            time = (time + val + 86400) % (86400);
            this.notifyObservers();
        }
    }

    /****************************
    / Object Controller: Control of the application
    / -> Observer
    *****************************/
    var Controller = function(v, m) {
        Observer.call(this);
        m.registerObserver(v);  // View observes Model
        v.registerObserver(this);  // Controller observes View
        setInterval(function() {model.increment(1)}, 1000);
        this.notify = function(msg) {
            switch(msg) {
                case 'ADD_1_HOUR': m.increment(3600); break;
                case 'DEL_1_HOUR': m.increment(-3600); break;
                case 'ADD_1_MINUTE': m.increment(60); break;
                case 'DEL_1_MINUTE': m.increment(-60); break;
            }
        }
    };

    var model = new Model();
    var view = new View();
    var ctrl = new Controller(view, model);
});

