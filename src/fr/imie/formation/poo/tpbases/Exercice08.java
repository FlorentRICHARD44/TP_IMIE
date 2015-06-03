/**
 * 
 */
package fr.imie.formation.poo.tpbases;

/**
 * @author Florent RICHARD
 *
 */
public class Exercice08 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Boucle For");
		for(int i = 0; i < 100 + 1; i++) {
			System.out.format("%d, ", i);
		}
		System.out.println("\nBoucle while");
		int j = 0;
		while (j < 100 + 1) {
			System.out.format("%d, ", j);
			j++;
		}
		System.out.println("\nBoucle do-while");
		int k = -1;
		do {
			k++;
			System.out.format("%d, ", k);
		} while(k < 100);

	}

}
