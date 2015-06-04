package fr.imie.formation.poo.tpdiamond.behaviours;

import fr.imie.formation.poo.tpdiamond.ifs.IVehicule;


/** Class to implement the behaviour of a Vehicule.
 * @author Florent RICHARD
 */
public class VehiculeComp {
    /** Vehicule used.
     */
    private IVehicule vehicule;

    /** Constructor.
     * @param veh Vehicule used for the behaviour.
     */
    public VehiculeComp(final IVehicule veh) {
        super();
        this.vehicule = veh;
    }
    /** Put the Vehicule into the casse.
     * @param veh vehicule to put in the casse.
     */
    public final void mettreCasse(final IVehicule veh) {
        System.out.format("I put the vehicule %s in the casse in the case of marque %s\n",
                          vehicule.getName(), vehicule.getMark().getName());
    }
}
