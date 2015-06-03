/**
 * 
 */
package fr.imie.formation.poo.tpbases;

import java.util.Scanner;

/**
 * @author imie
 *
 */
public class Exercice06 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer valeur = 0;
		Scanner scan = new Scanner(System.in);
		String end = "";
		do {
			System.out.print("Entrer le nombre: ");
			valeur = scan.nextInt();
			System.out.format("La factorielle de %d est %d\n", valeur, factorielle(valeur));
			
			System.out.println("Voulez-vous continuer (\"oui\"/\"non\")");
			scan.nextLine();
			end = scan.nextLine();
		} while (!end.equals("non"));
		scan.close();
	}
	
	/** Fonction retournant la factorielle d'un nombre.
	 * 
	 * @param value Nombre pour lequel retourner la factorielle.
	 * @return Factorielle du nombre passé en paramètre
	 */
	public static Integer factorielle(final Integer value) {
		Integer resultat = 1;
		if (value > 1) {
			resultat = value * factorielle(value - 1);
		}
		return resultat;
	}

}
