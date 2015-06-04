package fr.imie.formation.poo.tpthread;

/** class which performs calculs.
 * @author Florent RICHARD
 */
public class Calcul {
    /** Value used for the calculs.
     */
    private Integer value;
    /** Class used for affichage.
     */
    private IAffichage affichage;

    /** Constructor.
     * @param aff Class used for the Affichage.
     */
    public Calcul(final IAffichage aff) {
        affichage = aff;
    }

    /** Constructor.
     * @param val value used in the calcul.
     * @param aff Class used for the Affichage.
     */
    public Calcul(final Integer val, final IAffichage aff) {
        this.value = val;
        affichage = aff;
    }

    /** Calculates the factorielle of the value.
     */
    public final void doFactorielle() {
        long t0 = System.nanoTime();
        Integer res = factorielle(this.value);
        affichage.printFinalValue(res);
        affichage.printTempsCalcul(System.nanoTime() - t0);
    }

    /** Fonction retournant la factorielle d'un nombre.
     * @param val Nombre pour lequel retourner la factorielle.
     * @return Factorielle du nombre passé en paramètre
     */
    private Integer factorielle(final Integer val) {
        Integer resultat = 1;
        if (val > 0) {
            resultat = val * factorielle(val - 1);
            affichage.printMiddleValue(resultat);
        }
        return resultat;
    }

    /** Getter for the value.
     * @return the value
     */
    public final Integer getValue() {
        return value;
    }

    /** Setter for the value.
     * @param val the value to set
     */
    public final void setValue(final Integer val) {
        this.value = val;
    }
}
