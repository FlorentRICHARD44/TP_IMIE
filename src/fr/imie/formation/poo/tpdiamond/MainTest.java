package fr.imie.formation.poo.tpdiamond;

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
        vElec.demarrer();
        vElec.avancer();
        vElec.mettreCasse();
        VoitureThermique vTherm = new VoitureThermique();
        vTherm.demarrer();
        vTherm.avancer();
        vTherm.mettreCasse();
        AeroglisseurThermique aTherm = new AeroglisseurThermique();
        aTherm.demarrer();
        aTherm.gonflerCoussin();
        aTherm.avancer();
        aTherm.mettreCasse();
        AeroglisseurElectrique aElec = new AeroglisseurElectrique();
        aElec.demarrer();
        aElec.gonflerCoussin();
        aElec.avancer();
        aElec.mettreCasse();
    }
}
