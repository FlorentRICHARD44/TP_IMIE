/**
 * 
 */
package fr.imie.formation.poo.tpbases;

/**
 * @author Florent RICHARD
 *
 */
public class Exercice14 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] values = {0, 1, 10, -6};
		System.out.println("L'écart max est de " + String.valueOf(maxTable(values) - minTable(values)));

	}
	
	public static Integer maxTable(final Integer[] values) {
		Integer result = values[0];
		for (Integer i: values) {
			if (i > result) {
				result = i;
			}
		}
		return result;
	}
	
	public static Integer minTable(final Integer[] values) {
		Integer result = values[0];
		for (Integer i: values) {
			if (i < result) {
				result = i;
			}
		}
		return result;
	}

}
