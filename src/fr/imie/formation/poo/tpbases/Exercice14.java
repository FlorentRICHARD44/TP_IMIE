package fr.imie.formation.poo.tpbases;

/** Class to execute exercice 14.
 * @author Florent RICHARD
 */
public final class Exercice14 {

    /** Constructor.
     * Not used.
     */
    private Exercice14() {
    }

    /** Main function.
     * @param args Arguments of the application.
     */
    public static void main(final String[] args) {
        Integer[] values = {0, 1, 10, -6};
        System.out.format("L'écart max est de %d\n",
                          String.valueOf(maxTable(values) - minTable(values)));

    }

    /** Returns the maximum value found in the table.
     * @param values Table of value.
     * @return Maximum found in table.
     */
    public static Integer maxTable(final Integer[] values) {
        Integer result = values[0];
        for (Integer i: values) {
            if (i > result) {
                result = i;
            }
        }
        return result;
    }

    /** Returns the minimum value found in the table.
     * @param values Table of value.
     * @return Minimum found in table.
     */
    public static Integer minTable(final Integer[] values) {
        Integer result = values[0];
        for (Integer i: values) {
            if (i < result) {
                result = i;
            }
        }
        return result;
    }
}
