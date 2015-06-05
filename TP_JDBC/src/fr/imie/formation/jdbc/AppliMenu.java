/**
 * 
 */
package fr.imie.formation.jdbc;

/**
 * @author Florent RICHARD
 *
 */
public enum AppliMenu {
    QUIT (0, "Quitter"),
    DISPLAY (1, "Afficher tous les usagers"),
    INSERT (2, "Ajouter un usager"),
    DELETE (3, "Supprimer un usager"),
    UPDATE (4, "Modifier un usager");
    
    private Integer code;
    private String name;
    
    private AppliMenu(final Integer cod, final String name) {
        this.code = cod;
        this.name = name;
    }

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
     * @param code the code to set
     */
    public final void setCode(Integer code) {
        this.code = code;
    }

    /**
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public final void setName(String name) {
        this.name = name;
    }
}
