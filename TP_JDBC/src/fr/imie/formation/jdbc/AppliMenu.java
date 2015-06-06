package fr.imie.formation.jdbc;

/**
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
    /** Menu: Add a new user.
     */
    INSERT (2, "Ajouter un usager"),
    /** Menu: delete one user.
     */
    DELETE (3, "Supprimer un usager"),
    /** Menu: Update one user.
     */
    UPDATE (4, "Modifier un usager");

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

    /**
     * @return the code
     */
    public final Integer getCode() {
        return code;
    }

    /**
     * @param cod the code to set
     */
    public final void setCode(final Integer cod) {
        this.code = cod;
    }

    /**
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * @param mName the name to set
     */
    public final void setName(final String mName) {
        this.name = mName;
    }
}
