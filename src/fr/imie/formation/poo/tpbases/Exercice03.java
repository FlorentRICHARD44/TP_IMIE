/**
 * 
 */
package fr.imie.formation.poo.tpbases;

/**
 * @author Florent RICHARD
 *
 */
public class Exercice03 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String text = "abcdefghi";
		if (text.length() > 3 & text.length() < 10) {
			System.out.println("OK");
		} else {
			System.out.println("Le texte n'a pas une longueur correcte");
		}

	}

}
