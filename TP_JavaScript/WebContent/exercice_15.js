/****************************
 * Constructor: for an Object.
 ****************************/
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

// Liste of values to be used for sorting
var valListe = []
/****************************
 * Function: display the list of values to be used for sorting.
 ****************************/
function displayStartList() {
	var startList = document.getElementById("startlist");
	// Removes all the child
	while (startList.firstChild) {
		startList.removeChild(startList.firstChild);
	}
	for (var i in valListe) {
		var valueElement = document.createElement("li")
		valueElement.setAttribute("class", "value")
		var elements = document.createElement("ul")
		// Create del button
		var btndel = document.createElement("button")
		btndel.setAttribute("id", i)
		btndel.setAttribute("class", "btn del")
		btndel.addEventListener("click", function(e) {
				valListe.splice(parseInt(e.target.getAttribute("id")), 1);
				displayStartList();
				return false}, 
				false)
		elements.appendChild(btndel)
		// Add value
		elements.appendChild(document.createTextNode(valListe[i].getValue()))
		// Create Move Left button
		if (i > 0) {
			var btnleft = document.createElement("button")
			btnleft.setAttribute("id", i)
			btnleft.setAttribute("class", "btn moveleft")
			btnleft.addEventListener("click", function(e) {
				var index = parseInt(e.target.getAttribute("id"));
				var tmp = valListe[index - 1];
				valListe[index - 1] = valListe[index];
				valListe[index] = tmp;
				displayStartList();
				return false}, false)
			elements.appendChild(btnleft)
		}
		// Create Move Right button
		if (i < (valListe.length - 1)) {
			var btnright = document.createElement("button")
			btnright.setAttribute("id", i)
			btnright.setAttribute("class", "btn moveright")
			btnright.addEventListener("click", function(e) {
				var index = parseInt(e.target.getAttribute("id"));
				var tmp = valListe[index + 1];
				valListe[index + 1] = valListe[index];
				valListe[index] = tmp;
				displayStartList();
				return false}, false)
			elements.appendChild(btnright)
		}
		valueElement.appendChild(elements)
		startList.appendChild(valueElement);
	}
}
/****************************
 * Event Listener: for button Add new value
 ****************************/
var btn_add = document.getElementById("btn_addval");
btn_add.addEventListener("click", 
		function(e){
			if (document.getElementById("newval").value != "") {
				valListe.push(new Object(parseInt(document.getElementById("newval").value)));
			}
			displayStartList();
			return false;
		}, false);
/****************************
 * Event Listener: for button sort
 ****************************/
var btn_sort = document.getElementById("btn_sort");
btn_sort.addEventListener("click",
		function(e) {
			console.log("sort")
			tri(valListe, affiche)
			return false
		}, false);

/****************************
 * Function: Display the result of the sort (or current position).
 ****************************/
function affiche(tableau) {
	var resdiv = document.getElementById("sortresult")
	var resline = document.createElement("div")
	for(i in tableau) {
		var resval = document.createElement("div")
		resval.setAttribute("class", "result " + tableau[i].getStatus())
		resval.appendChild(document.createTextNode(tableau[i].getValue()))
		resline.appendChild(resval)
	}
	resdiv.appendChild(resline)
} 
/****************************
 * Function: sorts the values of a table (ascendent order).
 ****************************/
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
