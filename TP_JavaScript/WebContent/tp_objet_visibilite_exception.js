/**
 * 
 */

function Objet() {
	var chaine = "blabla";
	var show = function() {
		alert(chaine);
	};
}
function Objet2() {
	var chaine = "blabla";
	this.show = function() {
		alert(chaine);
	};
}

// Main Loop
var objList = [new Objet(), new Objet2()];
for (var i in objList) {
	var obj = objList[i];
	alert("objet: " + i)
	alert("next is attribute")
	try {
		alert(obj.chaine);
	} catch (e) {
		alert("Exception: " + e)
	}
	alert("next is method")
	try {
		obj.show();
	} catch (e) {
		alert("Exception: " + e)
	}
}

