/**
 * 
 */
package fr.imie.formation.poo.tpbases;

/**
 * @author Florent RICHARD
 *
 */
public class Exercice13 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer nb = 3;
		char chr = 'v';
		for (int i = 1; i <= nb; i++) {
			String line = "";
			for (int j = 1; j <= i; j++) {
				line = line.concat(String.valueOf(chr));
			}
			System.out.println(line);
		}

	}

}
