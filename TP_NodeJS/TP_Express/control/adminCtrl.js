var ModelUser = require("../model/user.js");

function AdminController() {
};

AdminController.prototype.home = function(req, res, next) {
    var modelUser = new ModelUser();
    var users = modelUser.findAllUsers();
    //res.send("Accueil admin");
    res.render('admin/home', {users: users, msg: "welcome", title: "admin"});
};

AdminController.prototype.login = function(req, res, next) {
    res.send("Login admin");
};

AdminController.prototype.image = function(req, res, next) {
    res.send("<!doctype html><html><head></head><body><img src=\"/img/imie.png\" alt=\"logo\"></body></html>");
};

module.exports = new AdminController();

