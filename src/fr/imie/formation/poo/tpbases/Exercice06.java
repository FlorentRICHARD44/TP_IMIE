package fr.imie.formation.poo.tpbases;

import java.util.Scanner;

/** Class to execute Exercice 6.
 * @author imie
 */
public final class Exercice06 {

    /** Constructor.
     * Not used.
     */
    private Exercice06() {
    }


    /** Main Function.
     * @param args Arguments of the Application.
     */
    public static void main(final String[] args) {
        Integer valeur = 0;
        Scanner scan = new Scanner(System.in);
        String end = "";
        do {
            System.out.print("Entrer le nombre: ");
            valeur = scan.nextInt();
            System.out.format("La factorielle de %d est %d\n",
                              valeur, factorielle(valeur));

            System.out.println("Voulez-vous continuer (\"oui\"/\"non\")");
            scan.nextLine();
            end = scan.nextLine();
        } while (!end.equals("non"));
        scan.close();
    }

    /** Fonction retournant la factorielle d'un nombre.
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
