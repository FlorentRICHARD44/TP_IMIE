package fr.imie.formation.poo.tpdiamond.behaviours;

import fr.imie.formation.poo.tpdiamond.ifs.IVoiture;

/** Describe the behaviour of a Voiture.
 * @author Florent RICHARD
 */
public class VoitureComp extends VehiculeRoulantComp {
    /** Vehicule used.
     */
    private IVoiture vehicule;

    /** Constructor.
     * @param veh Vehicule used for the behaviour.
     */
    public VoitureComp(
            final IVoiture veh) {
        super(veh);
        this.vehicule = veh;
    }
}
