/**
 * 
 */


function ObjectA(objB) {
	if (objB.attribute == undefined) {
		this.attribute;
	} else {
		this.attribute = objB.attribute;
	}
	if (objB.method == undefined) {
		this.method = function(){ alert("not implemented")};
	} else {
		this.method = objB.method;
	}
}

// Main Loop
var b1 = {attribute: "un attribut"};
var b2 = {method: function() {alert("la methode")}};
var b3 = {attribute: "un attribut", method: function() {alert("la methode");}};
var o1 = new ObjectA(b1);
var o2 = new ObjectA(b2);
var o3 = new ObjectA(b3);

alert("objet 1");
o1.method();
alert("objet 2");
o2.method();
alert("objet 3");
o3.method();

