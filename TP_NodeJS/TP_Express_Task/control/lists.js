var listDAO = require('../model/listDAO');
var Task = require('../model/task');
var List = require('../model/list');

function ListsCtrl() {

};
ListsCtrl.prototype.findAllLists = function(req, res, next) {
    res.json(listDAO.findAllLists());
};
ListsCtrl.prototype.createList = function(req, res, next) {
    var list = new List();
    list.setName(req.body.name);
    listDAO.createList(list);
    res.json(list);
};
ListsCtrl.prototype.createTask = function(req, res, next) {
    var task = new Task();
    task.setName(req.body.name);
    var checked = undefined;
    if (req.body.checked == 'true') {
        checked = true;
    } else {
        checked = false;
    }
    task.setChecked(checked);
    task = listDAO.createTask(task);
    res.json(task);
};
ListsCtrl.prototype.updateTask = function(req, res, next) {
    var id = parseInt(req.params.idTask);
    var task = listDAO.findTaskById(id);
    if (task == undefined) {
        res.status(404).send("Task not found");
    } else {
        console.log(req.body.name);
        task = new Task();
        task.setId(id);
        task.setName(req.body.name);
        var checked = undefined;
        if (req.body.checked == 'true') {
            checked = true;
        } else {
            checked = false;
        }
        task.setChecked(checked);
        task = listDAO.updateTask(task);
        res.json(task);
    }
};
ListsCtrl.prototype.deleteTask = function(req, res, next) {
    listDAO.deleteTask(req.params.idTask);
    res.end();
};
ListsCtrl.prototype.findAllTasks = function(req, res, next) {
    res.json(listDAO.findAllTasks());
};
ListsCtrl.prototype.findTaskById = function(req, res, next) {
    var task = listDAO.findTaskById(parseInt(req.params.idTask));
    if (task == undefined) {
        res.status(404).send("Task not found");
    } else {
        res.json(task);
    }
};

module.exports = new ListsCtrl();

