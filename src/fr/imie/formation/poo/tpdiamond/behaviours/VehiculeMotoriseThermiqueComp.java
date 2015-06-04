package fr.imie.formation.poo.tpdiamond.behaviours;

import fr.imie.formation.poo.tpdiamond.ifs.IVehiculeMotoriseThermique;


/** Describes the behaviour of a Vehicule Motorised Thermique.
 * @author Florent RICHARD
 *
 */
public class VehiculeMotoriseThermiqueComp extends VehiculeMotoriseComp {
    /** Vehicule used.
     */
    private IVehiculeMotoriseThermique vehicule;

    /** Constructor.
     * @param veh Vehicule used for the behaviour.
     */
    public VehiculeMotoriseThermiqueComp(
            final IVehiculeMotoriseThermique veh) {
        super(veh);
        this.vehicule = veh;
    }


}
