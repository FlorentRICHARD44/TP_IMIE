package fr.imie.formation.jdbc;

import fr.imie.formation.jdbc.presentation.IHMConsole;

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
        try (IHMConsole ihm = new IHMConsole()) {
            ihm.run();
        } catch (Exception e) {
            e.printStackTrace();
            // TODO Add better catch
        }
    }
}
