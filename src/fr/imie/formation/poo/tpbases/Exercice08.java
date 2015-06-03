package fr.imie.formation.poo.tpbases;

/** Class to execute Exercice 8.
 * @author Florent RICHARD
 */
public final class Exercice08 {

    /** Constructor.
     * Not used.
     */
    private Exercice08() {
    }


    /** Main function.
     * @param args Arguments of the application.
     */
    public static void main(final String[] args) {
        final Integer max = 100;
        System.out.println("Boucle For");
        for (int i = 0; i < max + 1; i++) {
            System.out.format("%d, ", i);
        }
        System.out.println("\nBoucle while");
        int j = 0;
        while (j < max + 1) {
            System.out.format("%d, ", j);
            j++;
        }
        System.out.println("\nBoucle do-while");
        int k = -1;
        do {
            k++;
            System.out.format("%d, ", k);
        } while (k < max);
    }
}
