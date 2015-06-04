package fr.imie.formation.poo.tpdiamond;

import fr.imie.formation.poo.tpdiamond.ifs.IVoiture;
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
        // TODO Auto-generated constructor stub
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
    }
}
