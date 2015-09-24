function Task() {
    // id: Integer
    // name: String
    // checked: Boolean
};

Task.prototype.getId = function() {return this.id;};
Task.prototype.setId = function(id) {this.id = id;};
Task.prototype.getName = function() {return this.name;};
Task.prototype.setName = function(name) {this.name = name;};
Task.prototype.isChecked = function() {return this.checked;};
Task.prototype.setChecked = function(checked){this.checked = checked;};

module.exports = Task;
