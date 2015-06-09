package fr.imie.formation.jdbc.presentation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

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
                System.out.format(" - %2s -> %s\n", opt.getCode(), opt.getName());
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
                    numLigne++, u.getFirstName(), u.getName(), userDateBirth, userEmail, site, u.getNbConnection());
        }
        return usersToDisplay;
    }

    /** Ask the user to add a new user.
     */
    private void createUser() {
        Usager user = new Usager();
        user.setFirstName(getString("Entrer le prénom: ", null, false));
        user.setName(getString("Entrer le nom: ", null, false));
        user.setDateBirth(getDate("Entrer la date (format jj/mm/aaaa): ", null, true));
        user.setEmail(getString("Entrer l'adrese mail: ", null, true));
        Site site = null;
        List<Site> siteList = servData.selectAllSites();
        displaySites(siteList);
        Integer line = getInteger("Entrer la ligne du site d'inscription: ", null, false);
        if (line != null) {
            site = siteList.get(line - 1);
        }
        user.setInscrSite(site);
        user = servData.insert(user);
    }

    /** Ask the user to update an Usager.
     */
    private void updateUser() {
        Usager userToUpdate = selectUsagerLine("Entrer la ligne de l'usager à modifier: ", servData.selectAllUsagers());
        userToUpdate.setFirstName(getString(String.format("Entrer le prénom (%s): ", userToUpdate.getFirstName()),
                                            userToUpdate.getFirstName(), false));
        userToUpdate.setName(getString(String.format("Entrer le nom (%s): ", userToUpdate.getName()),
                                       userToUpdate.getName(), false));
        String strDate = "--/--/----";
        if (userToUpdate.getDateBirth() != null) {
            strDate = dateformat.format(userToUpdate.getDateBirth().getTime());
        }
        userToUpdate.setDateBirth(getDate(String.format("Entrer la date (jj/mm/aaaa) (%s): ", strDate), null, true));
        String strMail = "-";
        if (userToUpdate.getEmail() != null) {
            strMail = userToUpdate.getEmail();
        }
        userToUpdate.setEmail(getString(String.format("Entrer l'adresse mail (%s): ", strMail), null, true));
        userToUpdate.setNbConnection(getInteger(String.format("Entrer le nombre de connexions (%s): ",
                                                              userToUpdate.getNbConnection()),
                                                null, true));
        Site site = null;
        List<Site> siteList = servData.selectAllSites();
        displaySites(siteList);
        String strSite;
        if (userToUpdate.getInscrSite() == null) {
            strSite = "?";
        } else {
            strSite = userToUpdate.getInscrSite().getName();
        }
        do {
            Integer line = getInteger(String.format("Entrer la ligne du site d'inscription (%s): ", strSite),
                                      null, false);
            try {
                site = siteList.get(line - 1);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Cette ligne n'existe pas.");
            }
        } while (site == null);
        userToUpdate.setInscrSite(site);
        servData.update(userToUpdate);
    }

    /** Ask the user for the parameters to filter and display list of results.
     */
    private void displayFiltered() {
        Usager userFilter = new Usager();
        System.out.println("Renseigner les paramètres à utiliser pour le filtre (** pour ne pas utiliser un paramètre");
        userFilter.setFirstName(getString("Filtrer par le prénom: ", null, true));
        userFilter.setName(getString("Filtrer par le nom: ", null, true));
        userFilter.setDateBirth(getDate("Filter par la date (format jj/mm/aaaa): ", null, true));
        userFilter.setEmail(getString("Filtrer par l'adresse mail: ", null, true));
        userFilter.setNbConnection(getInteger("Filtrer le nombre de connexions: ", null, true));
        Site site = null;
        List<Site> siteList = servData.selectAllSites();
        displaySites(siteList);
        do {
            Integer line = getInteger("Filtrer le site d'inscription (entrer la ligne): ", null, true);
            try {
                site = siteList.get(line - 1);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Cette ligne n'existe pas.");
            }
        } while (site == null);
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
            System.out.format("%10s | %-25s \n", numLigne++, s.getName());
        }
        return sites;
    }

    /** Create a new Site.
     */
    private void createSite() {
        Site site = new Site();
        site.setName(getString("Entrer le nom: ", null, false));
        site = servData.insert(site);
        System.out.format("Site inséré avec l'id %d\n", site.getId());
    }

    /** Delete a Site.
     */
    private void deleteSite() {
        try {
            servData.delete(selectSiteLine("Entrer la ligne du site à supprimer: ", servData.selectAllSites()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /** Ask the user to update a Site.
     */
    private void updateSite() {
        Site siteToUpdate = selectSiteLine("Entrer la ligne du site à modifier: ", servData.selectAllSites());
        siteToUpdate.setName(getString(String.format("Entrer le nom (%s): ", siteToUpdate.getName()), null, false));
        servData.update(siteToUpdate);
    }

    /** Affect a site to an usager.
     */
    private void affectSiteUsager() {
        Usager userToUpdate = selectUsagerLine("Entrer la ligne de l'usager à modifier: ", servData.selectAllUsagers());
        userToUpdate.setInscrSite(selectSiteLine("Entrer la ligne du site à sélectionner: ",
                                                 servData.selectAllSites()));
        servData.update(userToUpdate);
    }

    /** Affect a site and all usagers affected to this site.
     */
    private void deleteSiteUsager() {
        try {
            servData.deleteSiteAndRelatedUsers(selectSiteLine("Entrer la ligne du site à sélectionner: ",
                                                              servData.selectAllSites()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
                case USER_DELETE: servData.delete(selectUsagerLine("Entrer la ligne de l'usager à supprimer: ",
                                                             servData.selectAllUsagers()));
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
                case DELETE_SITE_AND_USAGER: deleteSiteUsager();
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

    /** Prints a message in the console and return the value set by the user.
     * If the line returned is empty, a default value is returned
     * If the line is "**", null is returned.
     * @param message Message to print
     * @param defaultValue Default value of the String
     * @param nullAccepted If set to true, the value null can be returned.
     * @return Value returned.
     */
    private String getString(final String message,
                             final String defaultValue,
                             final boolean nullAccepted) {
        String retVal = null;
        do {
            System.out.format("%s: ", message);
            String str = scan.nextLine();
            if (!str.equals("**")) {
                if (str.length() > 0) {
                    retVal = str;
                } else {
                    retVal = defaultValue;
                }
            }
        } while (!(nullAccepted || (retVal != null)));
        return retVal;
    }

    /** Prints a message in the console and return the value set by the user.
     * If the line returned is empty, a default value is returned
     * If the line is "**", null is returned.
     * @param message Message to print
     * @param defaultValue Default value of the Integer
     * @param nullAccepted If set to true, the value null can be returned.
     * @return Value returned.
     */
    private Integer getInteger(final String message,
                             final Integer defaultValue,
                             final boolean nullAccepted) {
        Integer retVal = null;
        do {
            System.out.format("%s: ", message);
            String str = scan.nextLine();
            if (!str.equals("**")) {
                if (str.length() > 0) {
                    retVal = Integer.valueOf(str);
                } else {
                    retVal = defaultValue;
                }
            }
        } while (!(nullAccepted || (retVal != null)));
        return retVal;
    }

    /** Prints a message in the console and return the value set by the user.
     * If the line returned is empty, a default value is returned
     * If the line is "**", null is returned.
     * @param message Message to print
     * @param defaultValue Default value of the Date
     * @param nullAccepted If set to true, the value null can be returned.
     * @return Value returned.
     */
    private Date getDate(final String message,
                         final Date defaultValue,
                         final boolean nullAccepted) {
        Date retVal = null;
        do {
            System.out.format("%s: ", message);
            String str = scan.nextLine();
            if (!str.equals("**")) {
                if (str.length() > 0) {
                    try {
                        retVal = new Date(dateformat.parse(str).getTime());
                    } catch (ParseException e) {
                        System.out.println("Format de date incorrect.");
                    }
                } else {
                    retVal = defaultValue;
                }
            }
        } while (!(nullAccepted || (retVal != null)));
        return retVal;
    }

    /** Ask the user to select an usager.
     * @param message Message to display
     * @param userList List of users.
     * @return Usager selected
     */
    private Usager selectUsagerLine(final String message, final List<Usager> userList) {
        Usager user = null;
        displayUsers(userList);
        do {
            Integer line = getInteger(message, null, false);
            try {
                user = userList.get(line - 1);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Cette ligne n'existe pas");
            }
        } while (user == null);
        return user;
    }

    /** Ask the user to select a site.
     * @param message Message to display
     * @param siteList List of sites.
     * @return site selected
     */
    private Site selectSiteLine(final String message, final List<Site> siteList) {
        Site site = null;
        displaySites(siteList);
        do {
            Integer line = getInteger(message, null, false);
            try {
                site = siteList.get(line - 1);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Cette ligne n'existe pas");
            }
        } while (site == null);
        return site;
    }
}
