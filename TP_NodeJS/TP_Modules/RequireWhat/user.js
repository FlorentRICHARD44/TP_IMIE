
module.exports = {
    User: function(n) {
        var name = n;
        this.setName = function(n) {name = n;};
        this.getName = function() {return name;};
    }
};

