package fr.imie.formation.poo.tpthread;

/** Describe the interface for an affichage.
 * @author Florent RICHARD
 */
public interface IAffichage {
    /** Affiche le resultat intermediaire d'un calcul.
     * @param value Resultat intermediaire.
     */
    void printMiddleValue(final Integer value);

    /** Affiche le resultat du calcul.
     * @param value Resultat du calcul.
     */
    void printFinalValue(final Integer value);

    /** Affiche le temps d'un calcul.
     * @param temps Temps du calcul.
     */
    void printTempsCalcul(final long temps);
}
