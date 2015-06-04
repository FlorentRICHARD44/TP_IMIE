package fr.imie.formation.poo.tpdiamond.behaviours;

import fr.imie.formation.poo.tpdiamond.ifs.IVehiculeMotorise;


/** Describes behaviour for a Vehicule Motorise.
 * @author Florent RICHARD
 *
 */
public class VehiculeMotoriseComp extends VehiculeComp {
    /** Vehicule used.
     */
    private IVehiculeMotorise vehicule;

    /** Constructor.
     * @param veh Vehicule used for the behaviour.
     */
    public VehiculeMotoriseComp(final IVehiculeMotorise veh) {
        super(veh);
        this.vehicule = veh;
    }

    /** Starts the motor for a Motorised Vehicule.
     * @param vehMot Motorised Vehicule to start.
     */
    public final void demarrer(final IVehiculeMotorise vehMot) {
        System.out.format("Turn key: Engine of %s start!\n",
                          vehicule.getName());
    }

}
