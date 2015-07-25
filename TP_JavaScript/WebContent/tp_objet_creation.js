/**
 * 
 */

function Objet3(newchaine) {
	var chaine = newchaine;
	this.show = function() {
		alert(chaine);
	}
}

var o1 = new Object();
o1.chaine = "Objet new";
o1.show = function() {alert(this.chaine)};

var o2 = {chaine:"Object anonymous",
		  show: function() {alert(this.chaine);}};

var o3 = new Objet3("Object avec constructeur")
// Main loop Creation
o1.show();
o2.show();
o3.show();
