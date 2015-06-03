package fr.imie.formation.poo.tpbases;

/** Class reprensenting the price of one photocopie in a tranche of prices.
 * @author imie

 */
public class PhotocopPrice {
    /** Price for one photocopie.
     */
    private Float price = 0.0f;
    /** Number of photocopies in the tranche.
     */
    private Integer number = 0;

    /** Constructor.
     * @param p price for one photocopie.
     * @param n number of photocopies in this tranche.
     */
    public PhotocopPrice(final Float p, final Integer n) {
        setPrice(p);
        setNumber(n);
    }

    /** Accessor to the price.
     * @return the price
     */
    public final Float getPrice() {
        return price;
    }

    /** Mutator to the price.
     * @param p the price to set
     */
    public final void setPrice(final Float p) {
        this.price = p;
    }

    /** Accessor to the number.
     * @return the number
     */
    public final Integer getNumber() {
        return number;
    }

    /** Mutator for the number.
     * @param n the number to set
     */
    public final void setNumber(final Integer n) {
        this.number = n;
    }
}
