/**
 * 
 */

function calc_categorie(age, label) {
	cat = ""
	if (age >= 6) {
		if (age >= 6 & age <= 7) {
			cat = "Poussin"
		} else if (age >= 8 & age <= 9) {
			cat = "Pupille"
		} else if (age >= 10 & age <= 11) {
			cat = "Minime"
		} else {
			cat = "Cadet"
		}
		document.getElementById(label).innerHTML = "La catégorie est " + cat
		document.getElementById(label).removeAttribute("class")
	} else {
		document.getElementById(label).innerHTML = "La personne est trop jeune pour jouer"
			document.getElementById(label).setAttribute("class", "error")
	}
}