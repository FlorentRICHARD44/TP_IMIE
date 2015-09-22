module.exports = function(name){ 
    var User = require('./user').User;
    var user = new User(name);
    return user;
}
