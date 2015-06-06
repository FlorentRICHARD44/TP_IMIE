package fr.imie.formation.jdbc;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

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
    /** Constructor.
     */
    public IHMConsole() {
        scan = new Scanner(System.in);
        dateformat = new SimpleDateFormat("dd/MM/yyyy");
    }

    /** Display a choice of next menu to apply.
     * Gets the selection of user.
     * @return Menu to apply.
     */
    public final AppliMenu getMenu() {
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
     * @param userList List of users.
     */
    public final void displayUsers(final List<Usager> userList) {
        System.out.format("    Id     |           Prénom          |             Nom           | Date naissance |                     E-mail                    |   Nb Connexions\n");
        System.out.format("-----------------------------------------------------------------------------------------------------------------------------------------------------\n");
        for (Usager u: userList) {
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
    }

    /** Ask the user to add a new user.
     * @return new User.
     */
    public final Usager addNewUser() {
        Usager user = new Usager();
        System.out.print("Entrer le prénom: ");
        user.setFirstName(scan.nextLine());
        System.out.print("Entrer le nom: ");
        user.setName(scan.nextLine());
        System.out.print("Entrer la date (format jj/mm/aaaa): ");
        String strDate = scan.nextLine();
        if (strDate.length() > 0) {
            try {
                user.setDateBirth(new Date(dateformat.parse(strDate)
                                        .getTime()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        System.out.print("Entrer l'adresse mail: ");
        String strEmail = scan.nextLine();
        if (strEmail.length() > 0) {
            user.setEmail(strEmail);
        }
        return user;
    }

    /** Ask the user to delete one user.
     * @param userList Actual user list.
     * @return user to delete.
     */
    public final Usager deleteUser(final List<Usager> userList) {
        Usager userToDelete = null;
        displayUsers(userList);
        System.out.print("Entrer l'id de l'usager à supprimer: ");
        do {
            Integer idToDel = new Integer(scan.nextLine());
            for (Usager u: userList) {
                if (idToDel.equals(u.getId())) {
                    userToDelete = u;
                    break;
                }
            }
        } while (userToDelete == null);
        return userToDelete;
    }

    /** Ask the user to update an Usager.
     * @param userList List of all Usagers.
     * @return user to update.
     */
    public final Usager updateUser(final List<Usager> userList) {
        Usager userToUpdate = null;
        displayUsers(userList);
        System.out.print("Entrer l'Id de l'usager à modifier: ");
        do {
            Integer idToUp = new Integer(scan.nextLine());
            for (Usager u: userList) {
                if (idToUp.equals(u.getId())) {
                    userToUpdate = u;
                    break;
                }
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
                userToUpdate.setDateBirth(new Date(dateformat.parse(strScan)
                                        .getTime()));
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
        return userToUpdate;
    }

    @Override
    public final void close() throws Exception {
        scan.close();
    }
}
