package fr.imie.formation.poo.tpthread;

/** Class which perform the display for the application.
 * @author Florent RICHARD
 *
 */
public class AffichageConsole implements IAffichage {
    /**
     * @see fr.imie.formation.poo.tpthread.IAffichage#printMiddleValue(java.lang.Integer)
     */
    @Override
    public final void printMiddleValue(final Integer value) {
        String thName = Thread.currentThread().getName();
        System.out.format("Thread %s, Valeur intermediaire: %d\n",
                          thName, value);
    }

    /**
     * @see fr.imie.formation.poo.tpthread.IAffichage#printFinalValue(java.lang.Integer)
     */
    @Override
    public final void printFinalValue(final Integer value) {
        String thName = Thread.currentThread().getName();
        System.out.format("Thread %s, Valeur finale: %d\n", thName, value);
    }

    /**
     * @see fr.imie.formation.poo.tpthread.IAffichage#printTempsCalcul(long)
     */
    @Override
    public final void printTempsCalcul(final long temps) {
        String thName = Thread.currentThread().getName();
        System.out.format("Thread %s, Temps d'exécution: %dns\n",
                          thName, temps);
    }
}
