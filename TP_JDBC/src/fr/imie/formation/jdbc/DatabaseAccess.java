/**
 * 
 */
package fr.imie.formation.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * @author Florent RICHARD
 *
 */
public class DatabaseAccess {

    public DatabaseAccess() {
        
    }

    public void selectAll() {
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        try (Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/jdbc_TP_usager",
                    "postgres", "postgres");
            PreparedStatement pst = connection.prepareStatement("SELECT * FROM usager")) {
            try (ResultSet res = pst.executeQuery()) {
                System.out.format("    Id     |           Prénom          |             Nom           | Date naissance |                     E-mail                    |   Nb Connexions\n");
                System.out.format("-----------------------------------------------------------------------------------------------------------------------------------------------------\n");
                while (res.next()) {
                    Integer id = res.getInt("id");
                    String name = res.getString("nom");
                    String firstName = res.getString("prenom");
                    String mail = res.getString("email");
                    if (res.wasNull()) {
                        mail = "-";
                    }
                    Date datebirth = res.getDate("datenaissance");
                    String dateStr = "";
                    if (res.wasNull()) {
                        dateStr = "--/--/----";
                    } else {
                        dateStr = dateformat.format(datebirth);
                    }
                    Integer nbcon = new Integer(res.getInt("nb_connexion"));
                    System.out.format("%10s | %-25s | %-25s | %-14s | %-45s | %15d\n",
                                        id, firstName, name, dateStr, mail, nbcon);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void insert() {
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        Scanner scan = new Scanner(System.in);
        try (Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/jdbc_TP_usager",
                    "postgres", "postgres")) {
            String nom;
            String prenom;
            Date dateBirth = null;
            String email;
            Integer nbConnexion;
            System.out.print("Entrer le prénom: ");
            nom = scan.nextLine();
            System.out.print("Entrer le nom: ");
            prenom = scan.nextLine();
            System.out.print("Entrer la date (format jj/mm/aaaa): ");
            try {
                dateBirth = new Date(dateformat.parse(scan.nextLine()).getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.print("Entrer l'adresse mail: ");
            email = scan.nextLine();
            PreparedStatement pst = connection.prepareStatement("INSERT INTO usager (\"nom\", \"prenom\", \"datenaissance\", \"email\") VALUES (?, ?, ?, ?)");
            pst.setString(1, nom);
            pst.setString(2, prenom);
            pst.setDate(3, dateBirth);
            pst.setString(4, email);
            
            pst.executeUpdate();
            
            pst.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        scan.close();
            
    }
    
    public void delete() {
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        Scanner scan = new Scanner(System.in);
        selectAll();
        System.out.print("Donner le numero d'id à supprimer: ");
        Integer deleteId = Integer.valueOf(scan.nextLine());
        try (Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/jdbc_TP_usager",
                    "postgres", "postgres")) {
           PreparedStatement pst = connection.prepareStatement("DELETE FROM usager WHERE id = ?");
            pst.setInt(1, deleteId);
            pst.executeUpdate();
            
            pst.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        scan.close();
            
    }
    

    
    public void update() {
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        Scanner scan = new Scanner(System.in);
        selectAll();
        System.out.print("Donner le numero d'id à modifier: ");
        Integer updateId = Integer.valueOf(scan.nextLine());
        try (Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/jdbc_TP_usager",
                    "postgres", "postgres")) {
            String nom;
            String prenom;
            Date dateBirth = null;
            String email;
            Integer nbConnexion;
            System.out.print("Entrer le prénom: ");
            nom = scan.nextLine();
            System.out.print("Entrer le nom: ");
            prenom = scan.nextLine();
            System.out.print("Entrer la date (format jj/mm/aaaa): ");
            try {
                dateBirth = new Date(dateformat.parse(scan.nextLine()).getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.print("Entrer l'adresse mail: ");
            email = scan.nextLine();
            System.out.print("Entrer le nombre de connexion: ");
            nbConnexion = Integer.valueOf(scan.nextLine());
            PreparedStatement pst = connection.prepareStatement("UPDATE usager SET nom = ?, prenom = ?, datenaissance = ?, email = ?, nb_connexion = ? WHERE id = ?");
            pst.setString(1, nom);
            pst.setString(2, prenom);
            pst.setDate(3, dateBirth);
            pst.setString(4, email);
            pst.setInt(5, nbConnexion);
            pst.setInt(6, updateId);
            
            pst.executeUpdate();
            
            pst.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        scan.close();
            
    }
}
