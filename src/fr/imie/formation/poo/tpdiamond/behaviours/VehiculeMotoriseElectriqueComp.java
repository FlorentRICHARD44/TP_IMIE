package fr.imie.formation.poo.tpdiamond.behaviours;

import fr.imie.formation.poo.tpdiamond.ifs.IVehiculeMotoriseElectrique;

/** Describes the behaviour of a vehicule Motorised Electrical.
 * @author Florent RICHARD
 */
public class VehiculeMotoriseElectriqueComp extends VehiculeMotoriseComp {
    /** Vehicule used.
     */
    private IVehiculeMotoriseElectrique vehicule;

    /** Constructor.
     * @param veh Vehicule used for the behaviour.
     */
    public VehiculeMotoriseElectriqueComp(
            final IVehiculeMotoriseElectrique veh) {
        super(veh);
        this.vehicule = veh;
    }

    /** Put the vehicule into casse.
     * @param vehMotElec Vehicule to put into casse.
     */
    public final void mettreCasse(
            final IVehiculeMotoriseElectrique vehMotElec) {
        System.out.format("Recycle battery of vehicule %s\n",
                          vehicule.getName());
        super.mettreCasse(vehMotElec);
    }
}
