package fr.imie.formation.poo.tpbases;

/** Enumeration Category by age.
 * @author Florent RICHARD
 */
public enum CategoryAge {
    /** Category not defined.
     */
    NONE ("Undefined", 0, 5),
    /** Category poussin.
     */
    POUSSIN ("Poussin", 6, 7),
    /** Category pupille.
     */
    PUPILLE ("Pupille", 8, 9),
    /** Category Minime.
     */
    MINIME ("Minime", 10, 11),
    /** Category Cadet.
     */
    CADET ("Cadet", 12, 9999);

    /** Name of the category.
     */
    private String name;
    /** Age min of the category (included).
     */
    private Integer min;
    /** Age max of the category (included).
     */
    private Integer max;

    /** Constructor.
     * @param cName Name of the category
     * @param cMin Age min (included)
     * @param cMax Age max (included)
     */
    private CategoryAge(final String cName,
                        final Integer cMin,
                        final Integer cMax) {
        setName(cName);
        setMin(cMin);
        setMax(cMax);
    }

    /** Accessor for the Name.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /** Mutator for the Name.
     * @param cName the name to set
     */
    public void setName(final String cName) {
        this.name = cName;
    }

    /** Accessor for the age min.
     * @return the min
     */
    public Integer getMin() {
        return min;
    }

    /** Mutator for the age min.
     * @param cMin the min to set
     */
    public void setMin(final Integer cMin) {
        this.min = cMin;
    }

    /** Accessor for the age max.
     * @return the max
     */
    public Integer getMax() {
        return max;
    }

    /** Mutator for the age max.
     * @param cMax the max to set
     */
    public void setMax(final Integer cMax) {
        this.max = cMax;
    }


}
