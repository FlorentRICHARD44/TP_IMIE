package fr.imie.formation.jdbc.dto;

/** Represents a Site in table.
 * @author Florent RICHARD
 */
public class DtoSite {
    /** Id of the site.
     */
    private Integer id = null;
    /** Name of the Site.
     */
    private String name = null;

    /** Constructor.
     */
    public DtoSite() {
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
