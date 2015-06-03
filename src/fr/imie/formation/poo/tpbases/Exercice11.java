/**
 * 
 */
package fr.imie.formation.poo.tpbases;

/**
 * @author imie
 *
 */
public class Exercice11 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] table = {1, 2, 5, 10, 11, 15, 19, 17, 16, 12};
		Integer sum = 0;
		for (Integer i: table) {
			sum += i;
		}
		System.out.format("La moyenne des notes est: %f", (float)sum / (table.length));

	}

}
