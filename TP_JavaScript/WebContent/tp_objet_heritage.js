/**
 * 
 */

function Mother(name) {
	var thename = name
	this.presentation = function() {
		return thename;
	};
}


var o1 = new Mother("maman")
function Child() {this.presentation2 = function(){return "2: " +this.presentation()}}
Child.prototype = o1;
var o2 = new Child();
alert(o2.presentation()); // maman
alert(o2.presentation2()); // maman

function Mother2(name) {
	var thename = name
	this.presentation = function() {
		return thename;
	};
}


var o21 = new Mother2("maman")
function Child2(name) {
	Mother2.call(this, name)
	this.presentation2 = function(){return "2: " +this.presentation()}}
Child2.prototype = o21;
var o22 = new Child2("fille");
alert(o22.presentation()); // maman
alert(o22.presentation2()); // maman
