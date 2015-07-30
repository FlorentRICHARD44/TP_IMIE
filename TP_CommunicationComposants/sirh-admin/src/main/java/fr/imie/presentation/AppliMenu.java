package fr.imie.presentation;

/** List the Options for the Menu.
 * @author Florent RICHARD
 *
 */
public enum AppliMenu {
    /** Menu: Quit the program.
     */
    QUIT (0, "Quitter"),
    /** Menu: Display all employees.
     */
    EMPLOYEE_DISPLAY (1, "Afficher tous les employés"),
    EMPLOYEE_ADD(2, "Ajouter un employé"),
    EMPLOYEE_MODIFY(3, "Modifier un employé"),
    EMPLOYEE_DELETE (4, "Supprimer un employé"),
    COMPTE_ADD(12, "Ajouter un compte"),
    COMPTE_CREDITE(13, "Créditer un compte"),
    COMPTE_DEBITE(14, "Débiter un compte"),
    EXECUTE_VIREMENT(15, "Faire un virement");

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