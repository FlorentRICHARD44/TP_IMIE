var Task = require("./task");

function ListDAO() {
    var t1 = new Task();
    t1.setId(1);
    t1.setName("tache 1");
    t1.setChecked(true);
    var t2 = new Task();
    t2.setId(2);
    t2.setName("tache 2");
    t2.setChecked(false);
    this.tasks = [t1, t2];
    this.lists = [];
}
ListDAO.prototype.findAllLists = function() {
    return this.lists;
};

ListDAO.prototype.createList = function(list) {
    var maxId = 0;
    for (var i = 0; i < this.lists.length; i++) {
        if (this.lists[i].getId() > maxId) {
            maxId = this.lists[i].getId();
        }
    }
    list.setId(maxId + 1);
    this.lists.push(list);
    return list;
};

ListDAO.prototype.findAllTasks = function() {
    return this.tasks;
};
ListDAO.prototype.findTaskById = function(id) {
    var task = undefined;
    this.tasks.forEach(function(tk) {
        if (tk.getId() == id) {
            task = tk;
        }
    });
    return task;
};
ListDAO.prototype.createTask = function(task) {
    var maxId = 0;
    for (var i = 0; i < this.tasks.length; i++) {
        if (this.tasks[i].getId() > maxId) {
            maxId = this.tasks[i].getId();
        }
    }
    task.setId(maxId + 1);
    this.tasks.push(task);
    return task;
};
ListDAO.prototype.updateTask = function(task) {
    for (var i = 0; i < this.tasks.length; i++) {
        if (this.tasks[i].getId() == task.getId()) {
            this.tasks[i] = task;
            break;
        }
    }
    return task;
};
ListDAO.prototype.deleteTask = function(id) {
    var posToDel = -1;
    for (var i = 0; i < this.tasks.length; i++) {
        if (this.tasks[i].getId() == id) {
            posToDel = i;
            break;
        }
    }
    this.tasks.splice(posToDel, 1);
};

module.exports = new ListDAO();

