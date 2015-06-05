package fr.imie.formation.poo.tpbases;

/** Class for exercice 5.
 * @author Florent RICHARD
 *
 */
public final class Exercice05 {

    /** Constructor.
     * Not used.
     */
    private Exercice05() {
    }

    /** Main Function.
     * @param args Arguments for execution.
     */
    public static void main(final String[] args) {
        Integer number = 2;
        System.out.format("La somme des entiers jusqu'à %d est de %s",
                           number, intSum(number));

    }

    /** Calculates the sum of integer from 1 to value.
     * @param value Max value to use.
     * @return Sum.
     */
    public static Integer intSum(final Integer value) {
        Integer result = 0;
        if (value > 0) {
            result = value + intSum(value - 1);
        }
        return result;
    }
}
