/**
 * 
 */

function calc_price_photocop(nbPhotocop, label) {
	total = 0
	total += Math.min(10, nbPhotocop) * 0.10
	nbPhotocop -= Math.min(10, nbPhotocop)
	total += Math.min(20, nbPhotocop) * 0.08
	nbPhotocop -= Math.min(20, nbPhotocop)
	total += nbPhotocop * 0.05
	nbPhotocop -= nbPhotocop
	document.getElementById(label).innerHTML = ''+ total
}

