/**
 * 
 */
function factorielle(number) {
	 if (number > 1) {
		 number *= factorielle(number - 1);
	 } else if (number < 0)  {
		 number = 0
	 }
	 return number;
}
value = prompt("Entrer le nombre à calculer")
alert("Résultat: " + factorielle(value))