package fr.imie.formation.poo.tpbases;

/** Class to execute Exercice 11.
 * @author imie
 */
public final class Exercice11 {

    /** Constructor.
     * Not used.
     */
    private Exercice11() {
    }

    /** Main function.
     * @param args Arguments of the application.
     */
    public static void main(final String[] args) {
        Integer[] table = {1, 2, 5, 10, 11, 15, 19, 17, 16, 12};
        Integer sum = 0;
        for (Integer i: table) {
            sum += i;
        }
        System.out.format("La moyenne des notes est: %f",
                          (float) sum / (table.length));

    }

}
