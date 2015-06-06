package fr.imie.formation.poo.tpdiamond;

import java.text.ParseException;
import java.text.SimpleDateFormat;

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
        vElec.setName("Twizzy");
        vElec.setMark(VehiculeMarque.RENAULT);
        vElec.demarrer();
        vElec.avancer();
        vElec.mettreCasse();
        System.out.println("-------------------");
        VoitureThermique vTherm = new VoitureThermique();
        vTherm.setName("Xsara");
        vTherm.setMark(VehiculeMarque.CITROEN);
        vTherm.demarrer();
        vTherm.avancer();
        vTherm.mettreCasse();
        System.out.println("-------------------");
        AeroglisseurThermique aTherm = new AeroglisseurThermique();
        aTherm.setName("Aero t");
        aTherm.setMark(VehiculeMarque.RENAULT);
        aTherm.demarrer();
        aTherm.gonflerCoussin();
        aTherm.avancer();
        aTherm.mettreCasse();
        System.out.println("-------------------");
        AeroglisseurElectrique aElec = new AeroglisseurElectrique();
        aElec.setName("fusee aero");
        aElec.setMark(VehiculeMarque.FERRARI);
        aElec.demarrer();
        aElec.gonflerCoussin();
        aElec.avancer();
        aElec.mettreCasse();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Person florent = new Person();
        try {
            florent.setDateBirth(dateFormat.parse("07/06/1987"));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(florent.getAge());
    }
}
