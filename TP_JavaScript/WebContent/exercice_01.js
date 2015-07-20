/**
 * 
 */
age = prompt("Donner l'âge de la personne");
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
	alert("La catégorie est " + cat)
} else {
	alert("La personne est trop jeune pour jouer")
}
