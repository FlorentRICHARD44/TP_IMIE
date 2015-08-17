function zeroPad(number,base){
    var res = "" + number;
    while (res.length < base) {
        res = "0"+ res;    
    }
    return res;
}


$(function() {
    var Observer = function() {
        this.notify = function(msg) {
            throw new Exception("Cet objet observer ne peut rien faire");        
        };
    }
    var Subject = function() {
        var observers = [];
        this.registerObserver = function(obs) {
            observers.push(obs);
        };
        this.unregisterObserver = function(obs) {
            observers.splice(observers.indexOf(obs), 1);
        };
        this.notifyObservers = function(msg) {
            observers.forEach(function(obs) { obs.notify(msg);});
        };
    }

    var View = function() {
        Observer.call(this);
        Subject.call(this);
        var thisview = this;
        $('button#addhour').on('click', function() {
            console.log("view +1h");
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

    var Model = function() {
        Subject.call(this);
        var hour = 0;
        var minute = 0;
        var second = 0;
        this.getHour = function() {return hour;};
        this.getMinute = function() {return minute;};
        this.getSecond = function() {return second;};
        this.increment = function() {
            if (second < 59) {
                second++;
            } else {
                second = 0;
                if (minute < 59) {
                    minute++;
                } else {
                    minute = 0;
                    if (hour < 23) {
                        hour++;
                    } else {
                        hour = 0;
                    }
                }
            }
            this.notifyObservers();
        }
        this.addHour = function(nb) {
            if ((hour + nb) < 23) {
               hour += nb;
            } else {
                hour = (hour + nb) % 24;            
            }
            this.notifyObservers();
        };
        this.delHour = function(nb) {
            if ((hour - nb) > -1) {
               hour -= nb;
            } else {
                hour = (hour - nb + 24) % 24;            
            }
            this.notifyObservers();
        };
        this.addMinute = function(nb) {
            if ((minute + nb) < 59) {
               minute += nb;
            } else {
                minute = (minute + nb) % 60; 
                this.addHour(Math.floor(nb / 60));           
            }
            this.notifyObservers();
        };
        this.delMinute = function(nb) {
            if ((minute - nb) > -1) {
               minute -= nb;
            } else {
                minute = (minute - nb + 60) % 60; 
                this.delHour(Math.floor(nb / 60));                  
            }
            this.notifyObservers();
        };
    }

    // TODO Créer la structure d'un contrôleur
    var Controller = function(v, m) {
        Observer.call(this);
        m.registerObserver(v);
        this.notify = function(msg) {
            console.log("controller " + msg);
            switch(msg) {
                case 'ADD_1_HOUR': m.addHour(1); break;
                case 'DEL_1_HOUR': m.delHour(1); break;
                case 'ADD_1_MINUTE': m.addMinute(1); break;
                case 'DEL_1_MINUTE': m.delMinute(1); break;
            }
        }
    };

    // TODO instancier les différents objets
    var model = new Model();
    var view = new View();
    var ctrl = new Controller(view, model);
    view.registerObserver(ctrl);
    setInterval(function() {model.increment()}, 1000);
});

