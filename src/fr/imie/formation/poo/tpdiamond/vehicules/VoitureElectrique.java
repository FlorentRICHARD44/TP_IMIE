package fr.imie.formation.poo.tpdiamond.vehicules;

import fr.imie.formation.poo.tpdiamond.behaviours.VehiculeMotoriseElectriqueComp;
import fr.imie.formation.poo.tpdiamond.behaviours.VoitureComp;
import fr.imie.formation.poo.tpdiamond.ifs.IVehiculeMotoriseElectrique;
import fr.imie.formation.poo.tpdiamond.ifs.IVoiture;

/** Class representing an Electric Motor Vehicule.
 * @author Florent RICHARD
 */
public class VoitureElectrique
        implements IVoiture,
                   IVehiculeMotoriseElectrique {
    /** Behaviour for the Voiture.
     */
    private VoitureComp voitComp;
    /** Behaviour for the Electric Vehicule.
     */
    private VehiculeMotoriseElectriqueComp vehElecComp;

    /** Constructor.
     */
    public VoitureElectrique() {
        voitComp = new VoitureComp();
        vehElecComp = new VehiculeMotoriseElectriqueComp();
    }

    /**
     * @see fr.imie.formation.poo.tpdiamond.ifs.IVehiculeRoulant#avancer()
     */
    @Override
    public final void avancer() {
        voitComp.avancer(this);

    }

    /**
     * @see fr.imie.formation.poo.tpdiamond.ifs.IVehicule#mettreCasse()
     */
    @Override
    public final void mettreCasse() {
        vehElecComp.mettreCasse(this);
    }

    /**
     * @see fr.imie.formation.poo.tpdiamond.ifs.IVehiculeMotorise#demarrer()
     */
    @Override
    public final void demarrer() {
        vehElecComp.demarrer(this);
    }
}
