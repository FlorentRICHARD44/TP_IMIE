package fr.imie.formation.poo.tpdiamond.vehicules;

import fr.imie.formation.poo.tpdiamond.behaviours.AeroglisseurComp;
import fr.imie.formation.poo.tpdiamond.behaviours.VehiculeMotoriseElectriqueComp;
import fr.imie.formation.poo.tpdiamond.ifs.IAeroglisseur;
import fr.imie.formation.poo.tpdiamond.ifs.IVehiculeMotoriseElectrique;

/** Class representing an Aeroglisseur with electric motor.
 * @author Florent RICHARD
 */
public class AeroglisseurElectrique
        implements IAeroglisseur,
                   IVehiculeMotoriseElectrique {
    /** Behaviour for Aeroglisseur.
    */
    private AeroglisseurComp aeroComp;
    /** Behaviour for Electric Motorisation Vehicule.
    */
    private VehiculeMotoriseElectriqueComp vehElecComp;

    /** Constructor.
    */
    public AeroglisseurElectrique() {
        aeroComp = new AeroglisseurComp();
        vehElecComp = new VehiculeMotoriseElectriqueComp();
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
        vehElecComp.mettreCasse(this);
    }

    /**
     * @see fr.imie.formation.poo.tpdiamond.ifs.IVehiculeMotorise#demarrer()
     */
    @Override
    public final void demarrer() {
        vehElecComp.demarrer(this);
    }

    /**
     * @see fr.imie.formation.poo.tpdiamond.ifs.IAeroglisseur#gonflerCoussin()
     */
    @Override
    public final void gonflerCoussin() {
        aeroComp.gonflerCoussin(this);
    }
}
