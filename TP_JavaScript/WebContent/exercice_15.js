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
	while (startList.hasChildNodes()) {
		startList.removeChild(startList.firstChild);
	}
	for (var i in valListe) {
		var valueElement = document.createElement("li")
		valueElement.setAttribute("class", "value")
		var elements = document.createElement("ul")
		// Create del button
		var btndel = document.createElement("button")
		btndel.setAttribute("data-index", i)
		btndel.setAttribute("class", "btn del")
		btndel.addEventListener("click", function(e) {
				valListe.splice(parseInt(e.target.getAttribute("data-index")), 1);
				displayStartList();
				if (valListe.length <= 1) {
					document.getElementById("btn_sort").setAttribute("hidden", "true")
				}
				return false}, 
				false)
		elements.appendChild(btndel)
		// Create Move Left button
		if (i > 0) {
			var btnleft = document.createElement("button")
			btnleft.setAttribute("data-index", i)
			btnleft.setAttribute("class", "btn moveleft")
			btnleft.addEventListener("click", function(e) {
				var index = parseInt(e.target.getAttribute("data-index"));
				var tmp = valListe[index - 1];
				valListe[index - 1] = valListe[index];
				valListe[index] = tmp;
				displayStartList();
				return false}, false)
			elements.appendChild(btnleft)
		}
		// Add value
		elements.appendChild(document.createTextNode(valListe[i].getValue()))
		// Create Move Right button
		if (i < (valListe.length - 1)) {
			var btnright = document.createElement("button")
			btnright.setAttribute("data-index", i)
			btnright.setAttribute("class", "btn moveright")
			btnright.addEventListener("click", function(e) {
				var index = parseInt(e.target.getAttribute("data-index"));
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
				if (valListe.length > 1) {
					document.getElementById("btn_sort").removeAttribute("hidden")
				}
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
			var resdiv = document.getElementById("sortresult")
			while (resdiv.hasChildNodes()) {
				resdiv.removeChild(resdiv.firstChild)
			}
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
	var tmptab = []
	for (i in tableau) {
		tmptab.push(tableau[i])
	}
	fct_affichage(tmptab)
	move = true
	while (move) {
		move = false
		for (var j=0; j < (tmptab.length - 1); j++) {
			if (tmptab[j].getValue() > tmptab[j+1].getValue()) {
				tmp = tmptab[j]
				tmptab[j] = tmptab[j+1]
				tmptab[j + 1] = tmp
				tmptab[j + 1].setStatus("movedleft")
				tmptab[j].setStatus("movedright")
				move = true

			}
		}
		fct_affichage(tmptab);
		for (var j=0; j < tmptab.length; j++) {
			tmptab[j].setStatus("")
		}
	}
}
