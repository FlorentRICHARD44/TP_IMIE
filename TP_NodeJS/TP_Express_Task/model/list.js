function List() {
    // id: Integer
    // name: String
    // tasks: array
};

List.prototype.getId = function() {return this.id;};
List.prototype.setId = function(id) {this.id = id;};
List.prototype.getName = function() {return this.name;};
List.prototype.setName = function(name) {this.name = name;};
List.prototype.getTasks = function() {return this.tasks;};
List.prototype.setTasks = function(tasks){this.tasks = tasks;};
List.prototype.addTask = function(task) {this.tasks.push(task);};
List.prototype.removeTask = function(task) {
    var posToDel = -1;
    for (var i = 0; i < this.tasks.length; i++) {
        if (this.tasks[i].getId() == task.getId()) {
            posToDel = i;
            break;
        }
    }
    this.tasks.splice(posToDel, 1);
};

module.exports = List;

