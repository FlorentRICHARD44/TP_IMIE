package fr.imie.formation.jdbc.presentation;

/** List the Options for the Menu.
 * @author Florent RICHARD
 *
 */
public enum AppliMenu {
    /** Menu: Quit the program.
     */
    QUIT (0, "Quitter"),
    /** Menu: Display all users.
     */
    USER_DISPLAY (11, "Afficher tous les usagers"),
    /** Menu: Display users filtered by searched parameters.
     */
    USER_DISPLAY_FILTERS (111, "Afficher les usagers filtrés par paramètre(s)"),
    /** Menu: Add a new user.
     */
    USER_INSERT (12, "Ajouter un usager"),
    /** Menu: delete one user.
     */
    USER_DELETE (13, "Supprimer un usager"),
    /** Menu: Update one user.
     */
    USER_UPDATE (14, "Modifier un usager"),
    /** Menu: Presentation of Usager.
     */
    USER_PRESENTATION_ALL (15, "Présentation de tous les usagers."),
    /** Menu: Display all sites.
     */
    SITE_DISPLAY (21, "Afficher tous les sites"),
    /** Menu: Display sites filtered by searched parameters.
     */
    SITE_DISPLAY_FILTERS (211, "Afficher les sites filtrés par paramètre(s)"),
    /** Menu: Add a new site.
     */
    SITE_INSERT (22, "Ajouter un site"),
    /** Menu: delete one user.
     */
    SITE_DELETE (23, "Supprimer un site"),
    /** Menu: Update one site.
     */
    SITE_UPDATE (24, "Modifier un site"),
    /** Menu: affect site to usager.
     */
    AFFECT_SITE_USAGER (31, "Affecter un site à un usager");

    /** Code for menu selection.
     */
    private Integer code;
    /** Menu name.
     */
    private String name;

    /** Constructor.
     * @param cod Code for selection.
     * @param mName Name of the menu.
     */
    private AppliMenu(final Integer cod, final String mName) {
        this.code = cod;
        this.name = mName;
    }

    /** Return the menu specified by its code.
     * @param cod Code of menu
     * @return Corresponding menu if exists, else null;
     */
    public static AppliMenu getMenu(final Integer cod) {
        AppliMenu exist = null;
        for (AppliMenu opt: AppliMenu.values()) {
            if (opt.getCode() == cod) {
                exist = opt;
                break;
            }
        }
        return exist;
    }

    /** Accessor to the code.
     * @return the code
     */
    public final Integer getCode() {
        return code;
    }

    /** Mutator for the code.
     * @param cod the code to set
     */
    public final void setCode(final Integer cod) {
        this.code = cod;
    }

    /** Accessor for the name.
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /** Mutator for the name.
     * @param mName the name to set
     */
    public final void setName(final String mName) {
        this.name = mName;
    }
}
