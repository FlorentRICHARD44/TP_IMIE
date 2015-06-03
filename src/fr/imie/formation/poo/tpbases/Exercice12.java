package fr.imie.formation.poo.tpbases;

import java.util.ArrayList;
import java.util.List;

/** Class to execute Exercice 12.
 * @author imie
 */
public final class Exercice12 {

    /** Constructor.
     * Not used.
     */
    private Exercice12() {
    }

    /** Main Function.
     * @param args Argument of the Application.
     */
    public static void main(final String[] args) {
        Integer[] initValue = {1, 2, 3, 4, 5};
        Integer[] resultat = new Integer[initValue.length];
        resultat[0] = initValue[initValue.length - 1];
        for (int i = 1; i < initValue.length; i++) {
            resultat[i] = initValue[i - 1];
        }
        for (Integer i: resultat) {
            System.out.println(i);
        }
        System.out.println("---------------");
        // TODO Auto-generated method stub
        List<Integer> tableau = new ArrayList<Integer>();
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 1; i < 6; i++) {
            tableau.add(i);
        }
        res.add(tableau.get(tableau.size() - 1));
        res.addAll(tableau.subList(0, tableau.size() - 1));
        System.out.println(res.toString());
    }
}
