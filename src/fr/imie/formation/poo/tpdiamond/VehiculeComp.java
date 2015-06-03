package fr.imie.formation.poo.tpdiamond;

/** Class to implement the behaviour of a Vehicule.
 * @author Florent RICHARD
 */
public class VehiculeComp implements IVehicule {
    /** Name of the Vehicule.
     */
    private String nom;
    /** Marque of the Vehicule.
     */
    private VehiculeMarque marque;

    @Override
    public void mettreCasse() {
        // TODO Auto-generated method stub
    }

    /** Accessor to the name.
     * @return the nom
     */
    public final String getNom() {
        return nom;
    }

    /** Mutator for the name.
     * @param n the nom to set
     */
    public final void setNom(final String n) {
        this.nom = n;
    }

    /** Accessor to the marque.
     * @return the marque
     */
    public final VehiculeMarque getMarque() {
        return marque;
    }

    /** Mutator for the marque.
     * @param m the marque to set
     */
    public final void setMarque(final VehiculeMarque m) {
        this.marque = m;
    }
}
