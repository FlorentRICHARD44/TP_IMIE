package fr.imie.formation.poo.tpgenerics;

import java.util.LinkedList;

/** Describes a Pile of Elements.
 * @author Florent RICHARD
 * @param <A> Elements stored in the PileListe.
 */
public class PileListe<A> implements Pile<A> {
    /** List of elements.
     */
    private LinkedList<A> list;
    /** Constructor.
     */
    public PileListe() {
        list = new LinkedList<A>();
    }

    @Override
    public final boolean estVide() {
        return list.isEmpty();
    }

    @Override
    public final void empile(final A a) {
        list.addLast(a);
    }

    @Override
    public final A depile() {
        return list.removeLast();
    }

    @Override
    public final Integer nbElements() {
        return list.size();
    }

    @Override
    public final A sommet() {
        return list.peekLast();
    }
}
