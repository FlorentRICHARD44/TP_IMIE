
// Import
var express = require("express");
var adminCtrl = require("../control/adminCtrl.js");

var router = express.Router();

router.get('/', adminCtrl.home);
router.get('/login', adminCtrl.login);
router.get('/auth', adminCtrl.login);
router.get('/image', adminCtrl.image);

module.exports = router;

