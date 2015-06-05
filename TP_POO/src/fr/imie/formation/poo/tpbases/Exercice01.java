package fr.imie.formation.poo.tpbases;


/** Class used to execute exercice 1.
 * @author Florent RICHARD
 *
 */
public final class Exercice01 {

    /** Constructor.
     * Not used.
     */
    private Exercice01() {
    }

    /** Main Function.
     * @param args Arguments
     */
    public static void main(final String[] args) {
        Integer age = 2;
        for (CategoryAge cat: CategoryAge.values()) {
            if (age <= cat.getMax() & age >= cat.getMin()) {
                System.out.format("Vous êtes de la catégorie %s",
                                  cat.getName());
                break;
            }
        }

    }

}
