
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
            observers.forEach(function(obs) { obs.notify(message);});
        };
    }
    var subjectObject = new Subject();

    var MessageSender = function() {
        Subject.call(this);
        this.sendMessage = function(message) {
            this.notifyObservers(message);
        };
    };

    var TextView = function(identifier) {
        var text = []
        var id = identifier;
        Observer.call(this);
        this.notify = function(message) {
            console.log("message notifié: " + message); 
            text.push(message);
            $('div#view' + id + ' .text').val(text.join('\n'));
        };
        this.getId = function() {return id;};
        this.register = function() {
            $('div#view' + id + ' button#btnUnreg').removeAttr("disabled");
            $('div#view' + id + ' button#btnReg').attr("disabled", "disabled");
            msgSender.registerObserver(this);  
        };
        this.unregister = function() {
            $('div#view' + id + ' button#btnReg').removeAttr("disabled");
            $('div#view' + id + ' button#btnUnreg').attr("disabled", "disabled");
            msgSender.unregisterObserver(this);  
        };
    };

    var msgSender = new MessageSender();
    $('button#send-msg').on("click", function() {
        msgSender.sendMessage($('input#msg').val());
        $('input#msg').val('');
    });
    var view1 = new TextView(1);
    var view2 = new TextView(2);
    var view3 = new TextView(3);
    var view4 = new TextView(4);
    var viewList = [view1, view2, view3, view4];
    for (var i in viewList) {
        $('div#view' + viewList[i].getId() + ' button#btnReg').on("click", (function(copieView){
                    return function() {
                        copieView.register()}
                    })(viewList[i]));
        $('div#view' + viewList[i].getId() + ' button#btnUnreg').on("click", (function(copieView){
                    return function() {
                        copieView.unregister()}
                    })(viewList[i]));
    }
});

