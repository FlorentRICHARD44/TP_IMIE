package fr.imie.formation.jdbc;

/** Launcher for the Application.
 * @author Florent RICHARD
 */
public final class AppliLauncher {
    /** Constructor.
     * Not used.
     */
    private AppliLauncher() {
    }
    /** Main Function of the application.
     * @param args Arguments of the application.
     */
    public static void main(final String[] args) {
        try (IHMConsole ihm = new IHMConsole();
                DatabaseAccess dbAccess = new DatabaseAccess()) {
            AppliMenu menuOption;
            do {
                menuOption = ihm.getMenu();
                switch (menuOption) {
                    case QUIT: System.out.println("Sortie");
                    break;
                    case DISPLAY: ihm.displayUsers(dbAccess.selectAll());
                    break;
                    case INSERT: dbAccess.insert(ihm.addNewUser());
                    break;
                    case UPDATE: dbAccess.update(
                                     ihm.updateUser(dbAccess.selectAll()));
                    break;
                    case DELETE: dbAccess.delete(
                                     ihm.deleteUser(dbAccess.selectAll()));
                    break;
                    default:break;
                }
            } while (menuOption != AppliMenu.QUIT);
        } catch (Exception e) {
            e.printStackTrace();
            // TODO Add better catch
        }
    }
}
