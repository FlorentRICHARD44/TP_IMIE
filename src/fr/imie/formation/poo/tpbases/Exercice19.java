package fr.imie.formation.poo.tpbases;

/** Class to execute the Exercice 19.
 * @author Florent RICHARD
 */
public final class Exercice19 {

    /** Constructor.
     * Not used.
     */
    private Exercice19() {
    }

    /** Main Function.
     * @param args Argument of the Application.
     */
    public static void main(final String[] args) {
        Integer number = 1234;
        String strRight = String.valueOf(number);
        String strReverse = "";
        for (int i = strRight.length(); i >= 1; i--) {
            strReverse = strReverse.concat(strRight.substring(i - 1, i));
        }
        Integer revNumber = Integer.decode(strReverse);
        System.out.println(revNumber);
    }
}
