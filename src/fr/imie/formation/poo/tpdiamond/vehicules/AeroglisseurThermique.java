package fr.imie.formation.poo.tpdiamond.vehicules;

import fr.imie.formation.poo.tpdiamond.behaviours.AeroglisseurComp;
import fr.imie.formation.poo.tpdiamond.behaviours.VehiculeMotoriseThermiqueComp;
import fr.imie.formation.poo.tpdiamond.ifs.IAeroglisseur;
import fr.imie.formation.poo.tpdiamond.ifs.IVehiculeMotoriseThermique;

/** Class representing an Aeroglisseur with Thermic motor.
 * @author Florent RICHARD
 */
public class AeroglisseurThermique
    implements IAeroglisseur,
               IVehiculeMotoriseThermique {
    /** Behaviour for Aeroglisseur.
     */
    private AeroglisseurComp aeroComp;
    /** Behaviour for Thermique Motorisation Vehicule.
     */
    private VehiculeMotoriseThermiqueComp vehThermComp;

    /** Constructor.
     */
    public AeroglisseurThermique() {
        aeroComp = new AeroglisseurComp();
        vehThermComp = new VehiculeMotoriseThermiqueComp();
    }

    /**
     * @see fr.imie.formation.poo.tpdiamond.ifs.IVehiculeGlissant#avancer()
     */
    @Override
    public final void avancer() {
        aeroComp.avancer(this);
    }

    /**
     * @see fr.imie.formation.poo.tpdiamond.ifs.IVehicule#mettreCasse()
     */
    @Override
    public final void mettreCasse() {
        aeroComp.mettreCasse(this);
    }

    /**
     * @see fr.imie.formation.poo.tpdiamond.ifs.IVehiculeMotorise#demarrer()
     */
    @Override
    public final void demarrer() {
        vehThermComp.demarrer(this);

    }

    /**
     * @see fr.imie.formation.poo.tpdiamond.ifs.IAeroglisseur#gonflerCoussin()
     */
    @Override
    public final void gonflerCoussin() {
        aeroComp.gonflerCoussin(this);
    }
}
