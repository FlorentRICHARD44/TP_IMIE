package fr.imie.formation.poo.tpdiamond;


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

    }

}
