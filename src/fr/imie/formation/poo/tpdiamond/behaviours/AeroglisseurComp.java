package fr.imie.formation.poo.tpdiamond.behaviours;

import fr.imie.formation.poo.tpdiamond.ifs.IAeroglisseur;

/** Describes the behaviour of an Aeroglisseur.
 * @author Florent RICHARD
 *
 */
public class AeroglisseurComp extends VehiculeGlissantComp {
    /** Gonfle le coussin.
     * @param aero Aeroglisseur for which the coussin will be gonfled.
     */
    public final void gonflerCoussin(final IAeroglisseur aero) {
        System.out.println("Push air into the coussin");
    }
}
