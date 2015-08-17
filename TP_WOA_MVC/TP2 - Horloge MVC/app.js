function zeroPad(number,base){
    var res = "" + number;
    while (res.length < base) {
        res = "0"+ res;    
    }
    return res;
}


$(function() {
    var Observer = function() {
        this.notify = function() {
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
        this.notifyObservers = function() {
            observers.forEach(function(obs) { obs.notify();});
        };
    }

    var View = function() {
        Observer.call(this);
        this.notify = function() {
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
    }

    // TODO Créer la structure d'un contrôleur
    var Controller = function(v, m) {
        m.registerObserver(v);
    };

    // TODO instancier les différents objets
    var model = new Model();
    var view = new View();
    var ctrl = new Controller(view, model);
    setInterval(function() {model.increment()}, 1000);
});

