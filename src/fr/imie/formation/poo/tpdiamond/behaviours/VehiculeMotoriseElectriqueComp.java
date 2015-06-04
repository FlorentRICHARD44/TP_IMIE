package fr.imie.formation.poo.tpdiamond.behaviours;

import fr.imie.formation.poo.tpdiamond.ifs.IVehiculeMotoriseElectrique;

/** Describes the behaviour of a vehicule Motorised Electrical.
 * @author Florent RICHARD
 */
public class VehiculeMotoriseElectriqueComp extends VehiculeMotoriseComp {

    /** Put the vehicule into casse.
     * @param vehMotElec Vehicule to put into casse.
     */
    public final void mettreCasse(
            final IVehiculeMotoriseElectrique vehMotElec) {
        System.out.println("Recycle battery");
        super.mettreCasse(vehMotElec);
    }
}
