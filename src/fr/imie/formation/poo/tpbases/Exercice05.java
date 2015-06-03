/**
 * 
 */
package fr.imie.formation.poo.tpbases;

/**
 * @author Florent RICHARD
 *
 */
public class Exercice05 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer number = 3;
		System.out.format("La somme des entiers jusqu'à %d est de %s", number, intSum(number));

	}
	
	public static Integer intSum(final Integer value) {
		Integer result = 0;
		if (value > 0) {
			result = value + intSum(value - 1);
		}
		return result;
	}

}
