package fr.imie.formation.poo.tpdiamond.vehicules;

import java.util.ArrayList;
import java.util.List;

import fr.imie.formation.poo.tpdiamond.VehiculeMarque;
import fr.imie.formation.poo.tpdiamond.behaviours.VehiculeMotoriseElectriqueComp;
import fr.imie.formation.poo.tpdiamond.behaviours.VoitureComp;
import fr.imie.formation.poo.tpdiamond.ifs.IVehiculeMotoriseElectrique;
import fr.imie.formation.poo.tpdiamond.ifs.IVoiture;
import fr.imie.formation.poo.tpdiamond.people.Driver;
import fr.imie.formation.poo.tpdiamond.people.Person;

/** Class representing an Electric Motor Vehicule.
 * @author Florent RICHARD
 */
public class VoitureElectrique
        implements IVoiture,
                   IVehiculeMotoriseElectrique {
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
    /** Behaviour for the Voiture.
     */
    private VoitureComp voitComp;
    /** Behaviour for the Electric Vehicule.
     */
    private VehiculeMotoriseElectriqueComp vehElecComp;

    /** Constructor.
     */
    public VoitureElectrique() {
        voitComp = new VoitureComp(this);
        vehElecComp = new VehiculeMotoriseElectriqueComp(this);
        driver = null;
        listPassengers = new ArrayList<Person>();
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
