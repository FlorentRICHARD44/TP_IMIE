package fr.imie.formation.poo.tpbases;

/** Class to execute Exercice 13.
 * @author Florent RICHARD
 */
public final class Exercice13 {

    /** Constructor.
     * Not used.
     */
    private Exercice13() {
    }

    /** Main function.
     * @param args Arguments of the application.
     */
    public static void main(final String[] args) {
        Integer nb = 2;
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
