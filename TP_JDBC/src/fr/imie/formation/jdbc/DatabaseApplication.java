/**
 * 
 */
package fr.imie.formation.jdbc;

import java.util.Scanner;

/**
 * @author Florent RICHARD
 *
 */
public class DatabaseApplication {
    private Scanner scan;
    private DatabaseAccess dbAccess;
    /**
     * 
     */
    public DatabaseApplication() {
        dbAccess = new DatabaseAccess();
        // TODO Auto-generated constructor stub
        
    }
    public final void execute() {

        scan = new Scanner(System.in);
        AppliMenu menuOption;
        do {
            menuOption = displayMenu();
            switch (menuOption) {
            case QUIT: System.out.println("Sortie");
                       break;
            case DISPLAY: displayListe();
                          break;
            case INSERT: insertData();
                         break;
            case UPDATE: updateData();
                         break;
            case DELETE: deleteData();
                         break;
            default:break;
            }
        } while (menuOption != AppliMenu.QUIT);

        scan.close();
    }
    
    private final AppliMenu displayMenu() {
        AppliMenu retour = null;
        do {
            System.out.println("Choissir une option:");
            for (AppliMenu opt: AppliMenu.values()) {
                System.out.format(" - %d -> %s\n", opt.getCode(), opt.getName());
            }
            Integer code = Integer.valueOf(scan.nextLine());
            retour = AppliMenu.getMenu(code);
        } while (retour == null);
        return retour;
    }
    
    private final void displayListe() {
        dbAccess.selectAll();
    }
    
    private final void insertData() {
        System.out.println("Insérer un usager");
        dbAccess.insert();
    }
    
    private final void updateData() {
        System.out.println("Updater");
        dbAccess.update();
        
    }
    
    private final void deleteData() {
        System.out.println("Supprimer");
        dbAccess.delete();
        
    }

}
