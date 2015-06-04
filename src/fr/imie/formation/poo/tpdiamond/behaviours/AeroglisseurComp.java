package fr.imie.formation.poo.tpdiamond.behaviours;

import fr.imie.formation.poo.tpdiamond.ifs.IAeroglisseur;

/** Describes the behaviour of an Aeroglisseur.
 * @author Florent RICHARD
 *
 */
public class AeroglisseurComp extends VehiculeGlissantComp {
    /** Vehicule used.
     */
    private IAeroglisseur aeroglisseur;

    /** Constructor.
     * @param aero Vehicule used for the behaviour.
     */
    public AeroglisseurComp(final IAeroglisseur aero) {
        super(aero);
        this.aeroglisseur = aero;
    }

    /** Gonfle le coussin.
     * @param aero Aeroglisseur for which the coussin will be gonfled.
     */
    public final void gonflerCoussin(final IAeroglisseur aero) {
        System.out.format("Push air into the coussin for the aeroglisseur %s\n",
                           aeroglisseur.getName());
    }
}
