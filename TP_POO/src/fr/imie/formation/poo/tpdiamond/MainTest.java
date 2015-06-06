package fr.imie.formation.poo.tpdiamond;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import fr.imie.formation.poo.tpdiamond.people.Driver;
import fr.imie.formation.poo.tpdiamond.people.Person;
import fr.imie.formation.poo.tpdiamond.vehicules.AeroglisseurElectrique;
import fr.imie.formation.poo.tpdiamond.vehicules.AeroglisseurThermique;
import fr.imie.formation.poo.tpdiamond.vehicules.VoitureElectrique;
import fr.imie.formation.poo.tpdiamond.vehicules.VoitureThermique;


/** Class for testing the TP.
 * @author Florent RICHARD
 */
public final class MainTest {

    /** Constructor.
     * Not used.
     */
    private MainTest() {
    }

    /** Main Function.
     * @param args Arguments of the application.
     */
    public static void main(final String[] args) {
        VoitureElectrique vElec = new VoitureElectrique();
        Driver toto = new Driver();
        toto.setFirstName("to");
        toto.setName("TO");
        vElec.setDriver(toto);
        Person p1 = new Person();
        p1.setFirstName("Alain");
        p1.setName("DELOIN");
        vElec.addPassenger(p1);
        vElec.setName("Twizzy");
        vElec.setMark(VehiculeMarque.RENAULT);
        vElec.demarrer();
        vElec.avancer();
        vElec.mettreCasse();
        System.out.println("-------------------");
        VoitureThermique vTherm = new VoitureThermique();
        vTherm.setName("Xsara");
        vTherm.setMark(VehiculeMarque.CITROEN);
        vTherm.setDriver(toto);
        vTherm.addPassenger(p1);
        vTherm.demarrer();
        vTherm.avancer();
        vTherm.mettreCasse();
        System.out.println("-------------------");
        AeroglisseurThermique aTherm = new AeroglisseurThermique();
        aTherm.setName("Aero t");
        aTherm.setMark(VehiculeMarque.RENAULT);
        aTherm.setDriver(toto);
        aTherm.addPassenger(p1);
        aTherm.demarrer();
        aTherm.gonflerCoussin();
        aTherm.avancer();
        aTherm.mettreCasse();
        System.out.println("-------------------");
        AeroglisseurElectrique aElec = new AeroglisseurElectrique();
        aElec.setName("fusee aero");
        aElec.setMark(VehiculeMarque.FERRARI);
        aElec.setDriver(toto);
        aElec.addPassenger(p1);
        aElec.demarrer();
        aElec.gonflerCoussin();
        aElec.avancer();
        aElec.mettreCasse();
    }
}
