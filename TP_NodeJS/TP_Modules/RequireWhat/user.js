function User(n) {
};
User.prototype.setName = function(n) {this._name = n;};
User.prototype.getName = function() {return this._name;};

module.exports = {
    User: User
};

