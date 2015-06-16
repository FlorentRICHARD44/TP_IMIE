package fr.imie.formation.jdbc.data;

/** Represents a Site (Applicative).
 * @author Florent RICHARD
 */
public class Site {
    /** Id of the Site.
     */
    private Integer id;
    /** Name of the Site.
     */
    private String name;

    /** Constructor.
     */
    public Site() {
    }

    /** Accessor to the name.
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /** Mutator for the name.
     * @param sName the name to set
     */
    public final void setName(final String sName) {
        this.name = sName;
    }

    /** Accessor to the id.
     * @return the id
     */
    public final Integer getId() {
        return id;
    }

    /** Mutator for the id.
     * @param sId the id to set
     */
    public final void setId(final Integer sId) {
        this.id = sId;
    }
}
