/**
 * 
 */
function factorielle(number, label) {
	 if (number > 1) {
		 number *= factorielle(number - 1);
	 } else if (number < 1)  {
		 number = 1
	 }
	 if (label) {
			document.getElementById(label).innerHTML = number
	 }
	 return number;
}