package fr.imie.formation.poo.tpbases;

import java.util.Scanner;

/** Class to execute Exercice 2.
 * @author imie
 *
 */
public final class Exercice02 {

    /** Constructor.
     * Not used.
     */
    private Exercice02() {
    }

    /** Main method of the exercice.
     * @param args Arguments of application.
     */
    public static void main(final String[] args) {
        Integer value = 0;
        Scanner scan = new Scanner(System.in);
        String end = "";
        do {
            System.out.print("Entrer un entier: ");
            value = scan.nextInt();
            if (value % 2 == 0) {
                System.out.println("Valeur paire");
            } else {
                System.out.println("Valeur impaire");
            }
            System.out.print("Voulez-vous continuer (\"oui\"/\"non\")");
            scan.nextLine();
            end = scan.nextLine();
        } while (!end.equals("non"));
        scan.close();
    }

}
