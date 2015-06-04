package fr.imie.formation.poo.tpdiamond.behaviours;

import fr.imie.formation.poo.tpdiamond.ifs.IVehiculeMotorise;


/** Describes behaviour for a Vehicule Motorise.
 * @author Florent RICHARD
 *
 */
public class VehiculeMotoriseComp extends VehiculeComp {

    /** Starts the motor for a Motorised Vehicule.
     * @param vehMot Motorised Vehicule to start.
     */
    public final void demarrer(final IVehiculeMotorise vehMot) {
        System.out.println("Turn key: Engine start!");
    }

}
