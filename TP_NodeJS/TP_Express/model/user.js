function User()  {

};

User.prototype.findAllUsers = function() {
    var users = [];
    users.push({id: 1, firstName : "Florent", lastName : "RICHARD", age: 28, desc: "Etudiant"});
    users.push({id: 2, firstName : "Gabriel", lastName : "BLOCK", age: 33, desc: "Formateur"});
    return users;
};

module.exports = User;

