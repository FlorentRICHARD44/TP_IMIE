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
    /** Current step of calcul.
     */
    private Integer step;
    /** Result of calcul.
     */
    private Integer result;
    /** Start time of calcul.
     */
    private long t0;

    /** Constructor.
     * @param aff Class used for the Affichage.
     */
    public Calcul(final IAffichage aff) {
        affichage = aff;
        step = 1;
        result = 1;
    }

    /** Constructor.
     * @param val value used in the calcul.
     * @param aff Class used for the Affichage.
     */
    public Calcul(final Integer val, final IAffichage aff) {
        this.value = val;
        affichage = aff;
        step = 1;
        result = 1;
    }

    /** Calculates the factorielle of the value.
     */
    public final void doFactorielle() {
        t0 = System.nanoTime();
        while (!factStep()) {
            try {
                Thread.sleep(1L);
            } catch (InterruptedException e) {
                System.out.println("ie");
            }
        }
    }

    /** Executes one step of calcul for the factorielle.
     * @return false while the calcul is not finished, true else.
     */
    private synchronized boolean factStep() {
        boolean retour = false;
        if (step <= value) {
            result = step * result;
            step++;
            affichage.printMiddleValue(result);
            if (step > value) {
                affichage.printFinalValue(result);
                affichage.printTempsCalcul(System.nanoTime() - t0);
                retour = true;
            }
        }
        return retour;
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
