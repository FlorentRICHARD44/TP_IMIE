var mod1 = require('./module');
var mod2 = require('./module');

console.log(mod1.msg);
mod1.msg = "coucou";
console.log(mod2.msg);
