package fr.imie.formation.poo.tpbases;

/** Class to execute the Exercice 15.
 * @author Florent RICHARD
 */
public final class Exercice15 {

    /** Constructor.
     * Not used.
     */
    private Exercice15() {
    }

    /** Main Function.
     * @param args Argument of the Application.
     */
    public static void main(final String[] args) {
        Integer val = 1;
        for (int i = 0; i < 11; i++) {
            System.out.format("%d x %d = %d\n", val, i, i * val);
        }
    }
}
