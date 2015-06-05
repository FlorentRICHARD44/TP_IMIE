package fr.imie.formation.poo.tpbases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/** Class to execute Exercice 4.
 * @author imie
 *
 */
public final class Exercice04 {

    /** Constructor.
     * Not used.
     */
    private Exercice04() {
    }

    /** Main function.
     * @param args Arguments for application.
     */
    public static void main(final String[] args) {
        Integer nbPhotocopies = 0;
        Float facture;
        Integer nbToCount;
        Scanner scan = new Scanner(System.in);
        String end = "";
        List<PhotocopPrice> prices = new ArrayList<PhotocopPrice>();
        prices.add(new PhotocopPrice(0.10f, 10));
        prices.add(new PhotocopPrice(0.08f, 20));
        prices.add(new PhotocopPrice(0.05f, 0));

        do {
            facture = 0.0f;
            System.out.print("Entrer le nombre: ");
            nbPhotocopies = scan.nextInt();
            for (PhotocopPrice p: prices) {
                if (p.getNumber() != 0) {
                    nbToCount = Math.min(p.getNumber(), nbPhotocopies);
                } else {
                    nbToCount = nbPhotocopies;
                }
                facture += nbToCount * p.getPrice();
                nbPhotocopies -= nbToCount;
            }
            System.out.format("Le prix total est de : %.2f euros\n", facture);

            System.out.println("Voulez-vous continuer (\"oui\"/\"non\")");
            scan.nextLine();
            end = scan.nextLine();
        } while (!end.equals("non"));
        scan.close();
    }
}
