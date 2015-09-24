
// Import
var express = require("express");
var listsCtrl = require("../control/lists.js");

var router = express.Router();

router.get('/', listsCtrl.findAllLists); // Find All list
//router.get('/:id/', listsCtrl.findList); // Find a list
router.post('/', listsCtrl.createList); // Create list
router.get('/:id/tasks/', listsCtrl.findAllTasks); // Find All tasks
router.get('/:id/tasks/:idTask', listsCtrl.findTaskById); // Find a task by id
router.post('/:id/tasks/', listsCtrl.createTask); // Create task
router.delete('/:id/tasks/:idTask', listsCtrl.deleteTask); // Delete task
router.put('/:id/tasks/:idTask', listsCtrl.updateTask); // Update task

module.exports = router;

