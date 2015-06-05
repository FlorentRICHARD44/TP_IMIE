package fr.imie.formation.poo.tpdiamond;

/** Enumeration of Marques for Vehicule.
 * @author Florent RICHARD
 */
public enum VehiculeMarque {
    /** Marque Citroen.
     */
    CITROEN ("Citroen"),
    /** Marque: Renault.
     */
    RENAULT ("Renault"),
    /** Marque Ferrari.
     */
    FERRARI ("Ferrari");

    /** Name of the marque.
     */
    private String name;

    /** Constructor.
     * @param n Name of the marque.
     */
    private VehiculeMarque(final String n) {
        setName(n);
    }

    /** Accessor to the name.
     * @return Name of the Marque.
     */
    public String getName() {
        return this.name;
    }

    /** Mutator for the name.
     * @param n Name of the Marque.
     */
    public void setName(final String n) {
        this.name = n;
    }
}
