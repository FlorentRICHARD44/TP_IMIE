package fr.imie.formation.poo.tpthread;

/** Runnable used to perform the calculs.
 * @author Florent RICHARD
 *
 */
public class CalcRunnable implements Runnable {
    /** Calcul used in the runnable.
     */
    private Calcul calcul;
    private Integer tempValue;
    /** Constructor.
     * @param calc Calcul to perform.
     */
    public CalcRunnable(final Calcul calc) {
        super();
        this.calcul = calc;
        tempValue = 0;
    }

    /**
     * @see java.lang.Runnable#run()
     */
    @Override
    public final void run() {
        calcul.doFactorielle();
    }

    /**
     * @return the tempValue
     */
    public final Integer getTempValue() {
        return tempValue;
    }

    /**
     * @param tempVal the tempValue to set
     */
    public final void setTempValue(Integer tempVal) {
        this.tempValue = tempVal;
    }
}
