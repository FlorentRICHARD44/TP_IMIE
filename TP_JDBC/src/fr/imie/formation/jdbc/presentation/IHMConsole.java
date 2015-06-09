package fr.imie.formation.jdbc.presentation;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import fr.imie.formation.jdbc.dao.DaoUsager;
import fr.imie.formation.jdbc.data.Site;
import fr.imie.formation.jdbc.data.Usager;
import fr.imie.formation.jdbc.services.ServiceData;

/** Inteface Human Machine by the console.
 * @author Florent RICHARD
 */
public class IHMConsole implements AutoCloseable {
    /** Scanner used to get informations.
     */
    private Scanner scan;
    /** Formatter for date.
     */
    private SimpleDateFormat dateformat;
    /** Access to data.
     */
    private ServiceData servData;
    /** Constructor.
     */
    public IHMConsole() {
        scan = new Scanner(System.in);
        dateformat = new SimpleDateFormat("dd/MM/yyyy");
        servData = new ServiceData();
    }

    /** Display a choice of next menu to apply.
     * Gets the selection of user.
     * @return Menu to apply.
     */
    private AppliMenu getMenu() {
        AppliMenu retour = null;
        do {
            System.out.println("Choissir une option:");
            for (AppliMenu opt: AppliMenu.values()) {
                System.out.format(" - %2s -> %s\n",
                        opt.getCode(), opt.getName());
            }
            Integer code = Integer.valueOf(scan.nextLine());
            retour = AppliMenu.getMenu(code);
        } while (retour == null);
        return retour;
    }

    /** Display a list of users.
     * @param usersToDisplay List of users to display
     * @return List of Usager.
     */
    private List<Usager> displayUsers(final List<Usager> usersToDisplay) {
        System.out.format("  Ligne    |           Prénom          |             Nom           | Date naissance |                     E-mail                    |   Site inscription   |   Nb Connexions\n");
        System.out.format("------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        Integer numLigne = 1;
        for (Usager u: usersToDisplay) {
            String userEmail;
            String userDateBirth;
            String site;
            if (u.getEmail() == null) {
                userEmail = "-";
            } else {
                userEmail = u.getEmail();
            }
            if (u.getDateBirth() == null) {
                userDateBirth = "--/--/----";
            } else {
                userDateBirth = dateformat.format(u.getDateBirth().getTime());
            }
            if (u.getInscrSite() == null) {
                site = "?";
            } else {
                site = u.getInscrSite().getName();
            }
            System.out.format("%10s | %-25s | %-25s | %-14s | %-45s | %-20s | %15d\n",
                    numLigne++, u.getFirstName(), u.getName(),
                    userDateBirth, userEmail, site, u.getNbConnection());
        }
        return usersToDisplay;
    }

    /** Ask the user to add a new user.
     */
    private void createUser() {
        Usager user = new Usager();
        System.out.print("Entrer le prénom: ");
        user.setFirstName(scan.nextLine());
        System.out.print("Entrer le nom: ");
        user.setName(scan.nextLine());
        System.out.print("Entrer la date (format jj/mm/aaaa): ");
        String strDate = scan.nextLine();
        if (strDate.length() > 0) {
            try {
                user.setDateBirth(
                       new Date(dateformat.parse(strDate).getTime()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        System.out.print("Entrer l'adresse mail: ");
        String strEmail = scan.nextLine();
        if (strEmail.length() > 0) {
            user.setEmail(strEmail);
        }
        Site site = null;
        List<Site> siteList = servData.selectAllSites();
        displaySites(siteList);
        System.out.print("Entrer la ligne du site d'inscription: ");
        String strSite = "";
        strSite = scan.nextLine();
        if (strSite.length() > 0) {
            Integer idToDel = Integer.valueOf(strSite);
            site = siteList.get(idToDel - 1);
        }
        user.setInscrSite(site);
        user = servData.insert(user);
        System.out.format("Usager inséré avec l'id %d\n", user.getId());
    }

    /** Ask the user to delete one user.
     */
    private void deleteUser() {
        Usager userToDelete = null;
        List<Usager> userList = servData.selectAllUsagers();
        displayUsers(userList);
        System.out.print("Entrer la ligne de l'usager à supprimer: ");
        do {
            Integer idToDel = new Integer(scan.nextLine());
            userToDelete = userList.get(idToDel - 1);
        } while (userToDelete == null);
        servData.delete(userToDelete);
    }

    /** Ask the user to update an Usager.
     */
    private void updateUser() {
        Usager userToUpdate = null;
        List<Usager> userList = servData.selectAllUsagers();
        displayUsers(userList);
        do {
            System.out.print("Entrer la ligne de l'usager à modifier: ");
            Integer idToUp = new Integer(scan.nextLine());
            try {
                userToUpdate = userList.get(idToUp - 1);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Cette ligne n'existe pas.");
            }
        } while (userToUpdate == null);
        String strScan = "";
        System.out.format("Entrer le prénom (%s): ",
                          userToUpdate.getFirstName());
        strScan = scan.nextLine();
        if (strScan.length() > 0) {
            userToUpdate.setFirstName(strScan);
        }
        System.out.format("Entrer le nom (%s): ", userToUpdate.getName());
        strScan = scan.nextLine();
        if (strScan.length() > 0) {
            userToUpdate.setName(strScan);
        }
        String strDate = "--/--/----";
        if (userToUpdate.getDateBirth() != null) {
            strDate = dateformat.format(userToUpdate.getDateBirth().getTime());
        }
        System.out.format("Entrer la date (format jj/mm/aaaa) (%s): ", strDate);
        strScan = scan.nextLine();
        if (strScan.length() > 0) {
            try {
                userToUpdate.setDateBirth(
                        new Date(dateformat.parse(strScan).getTime()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        String strMail = "-";
        if (userToUpdate.getEmail() != null) {
            strMail = userToUpdate.getEmail();
        }
        System.out.format("Entrer l'adresse mail (%s): ", strMail);
        strScan = scan.nextLine();
        if (strScan.length() > 0) {
            userToUpdate.setEmail(strScan);
        }
        System.out.format("Entrer le nombre de connexions (%s): ",
                userToUpdate.getNbConnection());
        strScan = scan.nextLine();
        if (strScan.length() > 0) {
            userToUpdate.setNbConnection(new Integer(strScan));
        }
        Site site = null;
        List<Site> siteList = servData.selectAllSites();
        displaySites(siteList);
        String strSite;
        if (userToUpdate.getInscrSite() == null) {
            strSite = "?";
        } else {
            strSite = userToUpdate.getInscrSite().getName();
        }
        System.out.format("Entrer la ligne du site d'inscription (%s): ",
                          strSite);
        strSite = "";
        strSite = scan.nextLine();
        if (strSite.length() > 0) {
            Integer idToDel = Integer.valueOf(strSite);
            site = siteList.get(idToDel - 1);
        }
        userToUpdate.setInscrSite(site);
        servData.update(userToUpdate);
    }

    /** Ask the user for the parameters to filter and display list of results.
     */
    private void displayFiltered() {
        Usager userFilter = new Usager();
        System.out.println("Renseigner les paramètres à utiliser pour le filtre (Laisser vide pour ne pas utiliser un paramètre");
        String strScan = "";
        System.out.format("Filtrer par le prénom: ");
        strScan = scan.nextLine();
        if (strScan.length() > 0) {
            userFilter.setFirstName(strScan);
        } else {
            userFilter.setFirstName(null);
        }
        System.out.format("Filtrer par le nom: ");
        strScan = scan.nextLine();
        if (strScan.length() > 0) {
            userFilter.setName(strScan);
        } else {
            userFilter.setName(null);
        }
        System.out.format("Filter par la date (format jj/mm/aaaa): ");
        strScan = scan.nextLine();
        if (strScan.length() > 0) {
            try {
                userFilter.setDateBirth(
                        new Date(dateformat.parse(strScan).getTime()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            userFilter.setDateBirth(null);
        }
        System.out.format("Filtrer par l'adresse mail: ");
        strScan = scan.nextLine();
        if (strScan.length() > 0) {
            userFilter.setEmail(strScan);
        } else {
            userFilter.setEmail(null);
        }
        System.out.format("Filtrer le nombre de connexions: ");
        strScan = scan.nextLine();
        if (strScan.length() > 0) {
            userFilter.setNbConnection(new Integer(strScan));
        } else {
            userFilter.setNbConnection(null);
        }
        Site site = null;
        List<Site> siteList = servData.selectAllSites();
        displaySites(siteList);
        System.out.print("Filtrer le site d'inscription (entrer la ligne): ");
        String strSite = "";
        strSite = scan.nextLine();
        if (strSite.length() > 0) {
            Integer idToDel = Integer.valueOf(strSite);
            site = siteList.get(idToDel - 1);
        }
        userFilter.setInscrSite(site);
        try {
            List<Usager> usagers = servData.selectFiltered(userFilter);
            if (usagers.size() == 0) {
                System.out.println("-> Aucun résultat");
            } else {
                displayUsers(usagers);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /** Display all the sites.
     * @param sites Sites to be displayed
     * @return List of all sites.
     */
    private List<Site> displaySites(final List<Site> sites) {
        System.out.format("  Ligne    |             Nom           \n");
        System.out.format("---------------------------------------\n");
        Integer numLigne = 1;
        for (Site s: sites) {
            System.out.format("%10s | %-25s \n",
                    numLigne++, s.getName());
        }
        return sites;
    }

    /** Create a new Site.
     */
    private void createSite() {
        Site site = new Site();
        System.out.print("Entrer le nom: ");
        site.setName(scan.nextLine());
        site = servData.insert(site);
        System.out.format("Site inséré avec l'id %d\n", site.getId());
    }

    /** Delete a Site.
     */
    private void deleteSite() {
        Site siteToDelete = null;
        List<Site> siteList = servData.selectAllSites();
        displaySites(siteList);
        System.out.print("Entrer la ligne du site à supprimer: ");
        do {
            Integer idToDel = new Integer(scan.nextLine());
            siteToDelete = siteList.get(idToDel - 1);
        } while (siteToDelete == null);
        try {
            servData.delete(siteToDelete);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /** Ask the user to update a Site.
     */
    private void updateSite() {
        Site siteToUpdate = null;
        List<Site> siteList = servData.selectAllSites();
        displaySites(siteList);
        do {
            System.out.print("Entrer la ligne du site à modifier: ");
            Integer idToUp = new Integer(scan.nextLine());
            try {
                siteToUpdate = siteList.get(idToUp - 1);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Cette ligne n'existe pas.");
            }
        } while (siteToUpdate == null);
        String strScan = "";
        System.out.format("Entrer le nom (%s): ", siteToUpdate.getName());
        strScan = scan.nextLine();
        if (strScan.length() > 0) {
            siteToUpdate.setName(strScan);
        }
        servData.update(siteToUpdate);
    }

    /** Affect a site to an usager.
     */
    private void affectSiteUsager() {
        Usager userToUpdate = null;
        List<Usager> userList = servData.selectAllUsagers();
        displayUsers(userList);
        do {
            System.out.print("Entrer la ligne de l'usager à modifier: ");
            Integer idToUp = new Integer(scan.nextLine());
            try {
                userToUpdate = userList.get(idToUp - 1);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Cette ligne n'existe pas.");
            }
        } while (userToUpdate == null);
        Site site = null;
        List<Site> siteList = servData.selectAllSites();
        displaySites(siteList);
        System.out.print("Entrer la ligne du site à supprimer: ");
        do {
            Integer idToDel = new Integer(scan.nextLine());
            site = siteList.get(idToDel - 1);
        } while (site == null);
        userToUpdate.setInscrSite(site);
        servData.update(userToUpdate);
    }

    /** Execute the Console and actions until user ask the end.
     */
    public final void run() {
        AppliMenu menuOption;
        do {
            menuOption = getMenu();
            switch (menuOption) {
                case QUIT: System.out.println("Sortie");
                break;
                case USER_DISPLAY: displayUsers(servData.selectAllUsagers());
                break;
                case USER_DISPLAY_FILTERS: displayFiltered();
                break;
                case USER_INSERT: createUser();
                break;
                case USER_UPDATE: updateUser();
                break;
                case USER_DELETE: deleteUser();
                break;
                case USER_PRESENTATION_ALL: servData.selectAllUsagers().stream().forEach(
                                                    x -> System.out.println(x.pres()));
                break;
                case SITE_DISPLAY: displaySites(servData.selectAllSites());
                    break;
                case SITE_INSERT: createSite();
                    break;
                case SITE_DELETE: deleteSite();
                    break;
                case SITE_UPDATE: updateSite();
                break;
                case AFFECT_SITE_USAGER: affectSiteUsager();
                break;
                default:System.out.println("Ce menu n'est pas implemente");
                break;
            }
        } while (menuOption != AppliMenu.QUIT);
    }

    @SuppressWarnings("javadoc")
    @Override
    public final void close() throws Exception {
        if (scan != null) {
            scan.close();
        }
        if (servData != null) {
            servData.close();
        }
    }
}
