package fr.imie.formation.poo.tpgenerics;

/** Describes the Interface Pile.
 * @author Florent RICHARD
 * @param <A> Type used in the pile.
 */
public interface Pile<A> {
    /** Check if the Pile is empty.
     * @return true if pile is empty, else false;
     */
    boolean estVide();
    /** Add an element to the Top of the Pile.
     * @param a Element to add.
     */
    void empile(A a);
    /** Delete the element in the Top of the pile.
     * @return The element deleted.
     */
    A depile();
    /** Returns the number of elements in the Pile.
     * @return Number of elements in the Pile.
     */
    Integer nbElements();
    /** Returns the element in the top of the Pile.
     * This element is not deleted from the pile.
     * @return Element in the top of the pile.
     */
    A sommet();
}
