package fr.imie.formation.jdbc.presentation;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import fr.imie.formation.jdbc.dao.IDao;
import fr.imie.formation.jdbc.dto.DtoUsager;

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
    private IDao<DtoUsager> daoUsager;
    /** Constructor.
     * @param usagerDao DAO for Usager
     */
    public IHMConsole(final IDao<DtoUsager> usagerDao) {
        scan = new Scanner(System.in);
        dateformat = new SimpleDateFormat("dd/MM/yyyy");
        daoUsager = usagerDao;
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
                System.out.format(" - %d -> %s\n",
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
    private List<DtoUsager> displayUsers(List<DtoUsager> usersToDisplay) {
        System.out.format("    Id     |           Prénom          |             Nom           | Date naissance |                     E-mail                    |   Nb Connexions\n");
        System.out.format("-----------------------------------------------------------------------------------------------------------------------------------------------------\n");
        for (DtoUsager u: usersToDisplay) {
            String userEmail;
            String userDateBirth;
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
            System.out.format("%10s | %-25s | %-25s | %-14s | %-45s | %15d\n",
                    u.getId(), u.getFirstName(), u.getName(),
                    userDateBirth, userEmail, u.getNbConnection());
        }
        return usersToDisplay;
    }

    /** Ask the user to add a new user.
     */
    private void addNewUser() {
        DtoUsager user = new DtoUsager();
        System.out.print("Entrer le pr�nom: ");
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
        user = daoUsager.insert(user);
        System.out.format("Usager inséré avec l'id %d\n", user.getId());
    }

    /** Ask the user to delete one user.
     */
    private void deleteUser() {
        DtoUsager userToDelete = null;
        List<DtoUsager> userList = daoUsager.selectAll();
        displayUsers(userList);
        System.out.print("Entrer l'id de l'usager à supprimer: ");
        do {
            Integer idToDel = new Integer(scan.nextLine());
            for (DtoUsager u: userList) {
                if (idToDel.equals(u.getId())) {
                    userToDelete = u;
                    break;
                }
            }
        } while (userToDelete == null);
        daoUsager.delete(userToDelete);
    }

    /** Ask the user to update an Usager.
     */
    private void updateUser() {
        DtoUsager userToUpdate = null;
        List<DtoUsager> userList = daoUsager.selectAll();
        displayUsers(userList);
        System.out.print("Entrer l'Id de l'usager à modifier: ");
        do {
            Integer idToUp = new Integer(scan.nextLine());
            for (DtoUsager u: userList) {
                if (idToUp.equals(u.getId())) {
                    userToUpdate = u;
                    break;
                }
            }
        } while (userToUpdate == null);
        String strScan = "";
        System.out.format("Entrer le pr�nom (%s): ",
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
        daoUsager.update(userToUpdate);
    }

    /** Ask the user for the parameters to filter and display list of results.
     */
    private void displayFiltered() {
        DtoUsager userFilter = new DtoUsager();
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
        try {
            List<DtoUsager> usagers = daoUsager.selectFiltered(userFilter);
            if (usagers.size() == 0) {
                System.out.println("-> Aucun résultat");
            } else {
                displayUsers(usagers);
            }
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
                case DISPLAY: displayUsers(daoUsager.selectAll());
                break;
                case DISPLAY_FILTERS: displayFiltered();
                break;
                case INSERT: addNewUser();
                break;
                case UPDATE: updateUser();
                break;
                case DELETE: deleteUser();
                break;
                default:break;
            }
        } while (menuOption != AppliMenu.QUIT);
    }

    /**
     * @see java.lang.AutoCloseable#close()
     */
    @Override
    public final void close() {
        if (scan != null) {
            scan.close();
        }
    }
}
