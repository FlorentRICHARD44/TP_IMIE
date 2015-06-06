package fr.imie.formation.poo.tpdiamond.vehicules;

import java.util.ArrayList;
import java.util.List;

import fr.imie.formation.poo.tpdiamond.VehiculeMarque;
import fr.imie.formation.poo.tpdiamond.behaviours.AeroglisseurComp;
import fr.imie.formation.poo.tpdiamond.behaviours.VehiculeMotoriseThermiqueComp;
import fr.imie.formation.poo.tpdiamond.ifs.IAeroglisseur;
import fr.imie.formation.poo.tpdiamond.ifs.IVehiculeMotoriseThermique;
import fr.imie.formation.poo.tpdiamond.people.Driver;
import fr.imie.formation.poo.tpdiamond.people.Person;

/** Class representing an Aeroglisseur with Thermic motor.
 * @author Florent RICHARD
 */
public class AeroglisseurThermique
    implements IAeroglisseur,
               IVehiculeMotoriseThermique {
    /** Name of the vehicule.
     */
    private String name;
    /** Mark of the vehicule.
     */
    private VehiculeMarque mark;
    /** Driver of vehicule.
     */
    private Driver driver;
    /** List of passengers of the vehicule.
     */
    private List<Person> listPassengers;
    /** Behaviour for Aeroglisseur.
     */
    private AeroglisseurComp aeroComp;
    /** Behaviour for Thermique Motorisation Vehicule.
     */
    private VehiculeMotoriseThermiqueComp vehThermComp;

    /** Constructor.
     */
    public AeroglisseurThermique() {
        aeroComp = new AeroglisseurComp(this);
        vehThermComp = new VehiculeMotoriseThermiqueComp(this);
        driver = null;
        listPassengers = new ArrayList<Person>();
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

    @Override
    public final Driver getDriver() {
        return this.driver;
    }

    @Override
    public final void setDriver(final Driver vDriver) {
        this.driver = vDriver;
    }

    @Override
    public final List<Person> getPassengers() {
        return this.listPassengers;
    }

    @Override
    public final void setPassengers(final List<Person> vListPassengers) {
        this.listPassengers = vListPassengers;
    }

    @Override
    public final void addPassenger(final Person passenger) {
        this.listPassengers.add(passenger);
    }

    @Override
    public final void removePassenger(final Person passenger) {
        this.listPassengers.remove(passenger);
    }
}
