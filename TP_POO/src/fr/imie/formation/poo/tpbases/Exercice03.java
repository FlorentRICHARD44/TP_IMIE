package fr.imie.formation.poo.tpbases;

/** Classe used for the exercice 3.
 * @author Florent RICHARD
 */
public final class Exercice03 {
    /** Min length of text.
     */
    private static final Integer MIN_TEXTE_SIZE = 4;
    /** Max length of text.
     */
    private static final Integer MAX_TEXTE_SIZE = 9;
    /** Constructor.
     * Not used.
     */
    private Exercice03() {
    }

    /** Main function.
     * @param args Arguments for the applcation
     */
    public static void main(final String[] args) {
        String text = "abcdefghi";
        if (text.length() >= MIN_TEXTE_SIZE & text.length() <= MAX_TEXTE_SIZE) {
            System.out.println("OK");
        } else {
            System.out.println("Le texte n'a pas une longueur correcte");
        }

    }

}
