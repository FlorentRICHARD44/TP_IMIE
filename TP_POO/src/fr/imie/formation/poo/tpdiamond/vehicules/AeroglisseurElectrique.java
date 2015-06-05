package fr.imie.formation.poo.tpdiamond.vehicules;

import fr.imie.formation.poo.tpdiamond.VehiculeMarque;
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
    /** Name of the vehicule.
     */
    private String name;
    /** Mark of the vehicule.
     */
    private VehiculeMarque mark;
    /** Behaviour for Aeroglisseur.
    */
    private AeroglisseurComp aeroComp;
    /** Behaviour for Electric Motorisation Vehicule.
    */
    private VehiculeMotoriseElectriqueComp vehElecComp;

    /** Constructor.
    */
    public AeroglisseurElectrique() {
        aeroComp = new AeroglisseurComp(this);
        vehElecComp = new VehiculeMotoriseElectriqueComp(this);
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
