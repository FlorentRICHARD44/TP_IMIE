/**
 * 
 */

function Mother(name) {
	var thename = name
	this.presentation = function() {
		alert(thename);
	};
}


var o1 = new Mother("maman")
var Child = Object.create(Mother)
var o2 = Object.create(Child);
o1.presentation(); // maman
o2.presentation(); // maman
