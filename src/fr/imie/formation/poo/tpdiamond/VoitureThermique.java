package fr.imie.formation.poo.tpdiamond;

import fr.imie.formation.poo.tpdiamond.behaviours.VehiculeMotoriseThermiqueComp;
import fr.imie.formation.poo.tpdiamond.behaviours.VoitureComp;
import fr.imie.formation.poo.tpdiamond.ifs.IVehiculeMotoriseThermique;
import fr.imie.formation.poo.tpdiamond.ifs.IVoiture;

/** Class representing a Voiture with a thermic motor.
 * @author Florent RICHARD
 */
public class VoitureThermique implements IVoiture, IVehiculeMotoriseThermique {
    /** Behaviour for a Thermic Motor Vehicule.
     */
    private VehiculeMotoriseThermiqueComp vehThermComp;
    /** Behaviour for a Voiture.
     */
    private VoitureComp voitComp;
    /** Constructor.
     */
    public VoitureThermique() {
        vehThermComp = new VehiculeMotoriseThermiqueComp();
        voitComp = new VoitureComp();
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
        voitComp.mettreCasse(this);

    }

    /**
     * @see fr.imie.formation.poo.tpdiamond.ifs.IVehiculeMotorise#demarrer()
     */
    @Override
    public final void demarrer() {
        vehThermComp.demarrer(this);

    }
}
