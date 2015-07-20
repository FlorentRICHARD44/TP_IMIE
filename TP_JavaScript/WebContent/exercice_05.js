table = [1, 3,2,4,6,5, 9,8,7]
move = true
while (move) {
	move = false
	for (i=0; i< table.length - 1; i++) {
		if (table[i] > table[i+1]) {
			tmp = table[i]
			table[i] = table[i+1]
			table[i + 1] = tmp
			move = true
		}
	}
}
alert(table)