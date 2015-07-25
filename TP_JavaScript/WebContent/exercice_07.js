table = [1, 3,2,4,6,5, 9,8,7]

function affiche(tableau) {
	alert("valeur intermediaire: " + tableau)
} 
function affichetoto(tableau) {
	alert("valeur intermediaire toto: " + tableau)
}
function tri(tableau, fct_affichage) {
	move = true
	while (move) {
		move = false
		for (i=0; i< tableau.length - 1; i++) {
			if (tableau[i] > tableau[i+1]) {
				tmp = tableau[i]
				tableau[i] = tableau[i+1]
				tableau[i + 1] = tmp
				move = true
			}
			fct_affichage(tableau);
		}
	}
	return tableau
}
alert(tri(table, affichetoto))
