package fr.imie.formation.poo.tpthread;

/** Runnable used to perform the calculs.
 * @author Florent RICHARD
 *
 */
public class CalcRunnable implements Runnable {
    /** Calcul used in the runnable.
     */
    private Calcul calcul;
    /** Constructor.
     * @param calc Calcul to perform.
     */
    public CalcRunnable(final Calcul calc) {
        super();
        this.calcul = calc;
    }

    /**
     * @see java.lang.Runnable#run()
     */
    @Override
    public final void run() {
        calcul.doFactorielle();
    }
}
