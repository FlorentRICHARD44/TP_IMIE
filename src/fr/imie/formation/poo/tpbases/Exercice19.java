/**
 * 
 */
package fr.imie.formation.poo.tpbases;

/**
 * @author Florent RICHARD
 *
 */
public class Exercice19 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer number = 1234;
		String strRight = String.valueOf(number);
		String strReverse = "";
		for (int i = strRight.length(); i >= 1; i--) {
			strReverse = strReverse.concat(strRight.substring(i-1, i));
		}
		Integer revNumber = Integer.decode(strReverse);
		System.out.println(revNumber);
		
	}

}
