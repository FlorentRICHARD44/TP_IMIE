table = [1, 2, 3, 4, 5, 78]
somme = 0
for(i in table) {
	somme += table[i]
}
alert("la moyenne est de " + somme / table.length)