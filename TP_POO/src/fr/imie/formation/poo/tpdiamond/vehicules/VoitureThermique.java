package fr.imie.formation.poo.tpdiamond.vehicules;

import fr.imie.formation.poo.tpdiamond.VehiculeMarque;
import fr.imie.formation.poo.tpdiamond.behaviours.VehiculeMotoriseThermiqueComp;
import fr.imie.formation.poo.tpdiamond.behaviours.VoitureComp;
import fr.imie.formation.poo.tpdiamond.ifs.IVehiculeMotoriseThermique;
import fr.imie.formation.poo.tpdiamond.ifs.IVoiture;

/** Class representing a Voiture with a thermic motor.
 * @author Florent RICHARD
 */
public class VoitureThermique implements IVoiture, IVehiculeMotoriseThermique {
    /** Name of the vehicule.
     */
    private String name;
    /** Mark of the vehicule.
     */
    private VehiculeMarque mark;
    /** Behaviour for a Thermic Motor Vehicule.
     */
    private VehiculeMotoriseThermiqueComp vehThermComp;
    /** Behaviour for a Voiture.
     */
    private VoitureComp voitComp;
    /** Constructor.
     */
    public VoitureThermique() {
        vehThermComp = new VehiculeMotoriseThermiqueComp(this);
        voitComp = new VoitureComp(this);
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

    /**
     * @see fr.imie.formation.poo.tpdiamond.ifs.IVehicule#getName()
     */
    @Override
    public final String getName() {
        return this.name;
    }

    /**
     * @see fr.imie.formation.poo.tpdiamond.ifs.IVehicule#setName(String)
     */
    @Override
    public final void setName(final String n) {
        this.name = n;
    }

    /**
     * @see fr.imie.formation.poo.tpdiamond.ifs.IVehicule#getMark()
     */
    @Override
    public final VehiculeMarque getMark() {
        return this.mark;
    }


    /**
     * @see fr.imie.formation.poo.tpdiamond.ifs.IVehicule#setMark(fr.imie.formation.poo.tpdiamond.VehiculeMarque)
     */
    @Override
    public final void setMark(final VehiculeMarque m) {
        this.mark = m;
    }
}
