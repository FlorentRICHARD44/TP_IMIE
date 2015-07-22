/**
 * 
 */

function Felix() {
	this.speak = function() {alert("blabla")}
};
var felix = new Felix();
felix.speak() // blabla
Felix.prototype.speak2 = function() {alert("je m'appelle felix")};
felix.speak() // blabla
felix.speak2(); // je m'appelle felix
var felix2 = new Felix();
felix2.speak2(); // je m'appelle felix
Felix.prototype = {};
var felix3 = new Felix();
felix.speak(); //blabla
felix.speak2(); // je m'appelle felix
felix2.speak(); // blabla
felix2.speak2(); // je m'appelle felix
felix3.speak(); // blabla
felix3.speak2(); // Exception
