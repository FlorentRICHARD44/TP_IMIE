/**
 * 
 */

function speak(texte) {
	this.speech += "\n" + texte
}

function pause() {
	this.speech += "\npause"
}

function Object() {
	this.speech = "blabla";
	this.affiche = function() {alert(this.speech)};
}
var o1 = new Object();
var o2 = new Object();
var liste = [o1, o2];
for (var i in liste) {
	speak.call(liste[i], "ligne pour objet " + (parseInt(i) + 1))
	pause.apply(liste[i])
	speak.apply(liste[i], ["meme ligne"])
	pause.call(liste[i])
}
speak.call(o1, "je suis o1")
speak.call(o2, "je suis o2")

alert(o1.speech)
alert(o2.speech)