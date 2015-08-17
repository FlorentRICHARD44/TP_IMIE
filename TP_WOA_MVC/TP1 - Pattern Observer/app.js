
$(function() {
    var Observer = function() {
        this.notify = function(message) {
            throw new Exception("Cet objet observer ne peut rien faire");        
        };
    }
    var observerObject = new Observer();

    var Subject = function() {
        var observers = [];
        this.registerObserver = function(obs) {
            observers.push(obs);
        };
        this.unregisterObserver = function(obs) {
            observers.splice(observers.indexOf(obs), 1);
        };
        this.notifyObservers = function(message) {
            for (var ind in observers) {
                console.log(ind + " " + observers[i]);
                observers[ind].notify(message);
            }  
        };
    }
    var subjectObject = new Subject();

    var MessageSender = function() {
        this.sendMessage = function(message) {
            this.notifyObservers(message);
        };
    };
    MessageSender.prototype = subjectObject;

    var TextView = function(identifier) {
        var id = identifier;
        this.notify = function(message) {
            console.log("message notifié: " + message);
            $('div#view' + id + ' .text').val($('div#view' + id + ' .text').val() + "\n" + message);
        };
        this.getId = function() {return id;};
    };
    TextView.prototype = observerObject;

    var msgSender = new MessageSender();
    $('button#send-msg').on("click", function() {
        msgSender.sendMessage($('input#msg').val());
    });
    var view1 = new TextView(1);
    var view2 = new TextView(2);
    var view3 = new TextView(3);
    var view4 = new TextView(4);
    var viewList = [view1, view2, view3, view4];
    var tableIndex = [1, 2, 3, 4];
    for (var i in viewList) {
console.log(viewList[i].getId());
        $('div#view' + viewList[i].getId() + ' button#btnReg').on("click", (function(copieView) {
                return function() {
                        $('div#view' + copieView.getId() + ' button#btnUnreg').removeAttr("disabled");
                        $('div#view' + copieView.getId() + ' button#btnReg').attr("disabled", "disabled");
                        msgSender.registerObserver(copieView);
                    }
                })(viewList[i])
        );
        $('div#view' + viewList[i].getId() + ' button#btnUnreg').on("click", (function(copieView) {
                return function() {
                        $('div#view' + copieView.getId() + ' button#btnReg').removeAttr("disabled");
                        $('div#view' + copieView.getId() + ' button#btnUnreg').attr("disabled", "disabled");
                        msgSender.unregisterObserver(copieView);
                    }
                })(viewList[i])
        );
    }
});

