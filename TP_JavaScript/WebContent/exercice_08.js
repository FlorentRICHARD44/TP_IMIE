function Object (val){
	var value = val;
	var status = "";
	this.getValue = function() {
		return value;
	}
	this.getStatus = function() {
		return status;
	}
	this.setStatus = function(newval) {
		status = newval;
	}
}

table = [new Object(1),
         new Object(8),
         new Object(7),
         new Object(9),
         new Object(2),
         new Object(3),
         new Object(4),
         new Object(6),
         new Object(5)]

function affiche(tableau) {
	document.write("<div>")
	for(i in table) {
		document.write("    <div class=\"value " + table[i].getStatus() + "\">" + table[i].getValue() + "</div>")
	}
	document.write("</div>")
} 
function affichetoto(tableau) {
	alert("valeur intermediaire toto: " + tableau)
}
function tri(tableau, fct_affichage) {
	fct_affichage(tableau)
	move = true
	while (move) {
		move = false
		for (var j=0; j < (tableau.length - 1); j++) {
			if (tableau[j].getValue() > tableau[j+1].getValue()) {
				tmp = tableau[j]
				tableau[j] = tableau[j+1]
				tableau[j + 1] = tmp
				tableau[j + 1].setStatus("movedleft")
				tableau[j].setStatus("movedright")
				move = true

			}
		}
		fct_affichage(tableau);
		for (var j=0; j < tableau.length; j++) {
			tableau[j].setStatus("")
		}
	}
	return tableau
}
tri(table, affiche)
