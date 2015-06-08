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
    DISPLAY (1, "Afficher tous les usagers"),
    /** Menu: Display users filtered by searched parameters.
     */
    DISPLAY_FILTERS (11, "Afficher les usagers filtrés par paramètre(s)"),
    /** Menu: Add a new user.
     */
    INSERT (2, "Ajouter un usager"),
    /** Menu: delete one user.
     */
    DELETE (3, "Supprimer un usager"),
    /** Menu: Update one user.
     */
    UPDATE (4, "Modifier un usager"),
    /** Menu: Presentation of Usager.
     */
    PRESENTATION_ALL (5, "Présentation de tous les usagers.");

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
