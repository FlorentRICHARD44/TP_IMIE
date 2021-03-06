/* TP - Ecrire le module correspondant au fonctionnement de la partie App.
 */

 // app.js - PART 1
 // var mod = require('./module');
 // console.log(mod); // prints 'Hello World'

 // app.js - PART 2
 //var mod = require('./module');
 //mod(); // prints 'Hello World'


// app.js - PART 3
//var mod = require('./module');
//mod.test(); // prints 'Hello World'
//console.log(mod.name) //prints 'toto'

// app.js - PART 4
//var mod = require('./module');
//mod('Hello World', function(msg){
//  console.log('msg is ' + msg);
//}); // prints 'msg is HELLO WORLD'


// app.js - PART 5
var User = require('./user').User;
var user = new User();
user.setName('toto');
console.log(user.getName()); // prints 'toto'

// app.js - PART 6
//var userFactory = require('./userFactory');
//var user = userFactory('toto');
//console.log(user.getName()); // prints 'toto'

