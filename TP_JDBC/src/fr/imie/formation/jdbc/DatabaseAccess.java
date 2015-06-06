package fr.imie.formation.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/** Class used to access to the database.
 * @author Florent RICHARD
 *
 */
public class DatabaseAccess implements AutoCloseable {
    /** Connection to Database.
     */
    private Connection connection;

    /** Constructor.
     */
    public DatabaseAccess() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/jdbc_TP_usager",
                    "postgres", "postgres");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /** Get the list of all users from database.
     * @return List of all users from database.
     */
    public final List<Usager> selectAll() {
        List<Usager> listUsagers = new ArrayList<Usager>();
        try (PreparedStatement pst = connection.prepareStatement(
                    "SELECT * FROM usager")) {
            try (ResultSet res = pst.executeQuery()) {
                while (res.next()) {
                    Usager usager = new Usager();
                    usager.setId(res.getInt("id"));
                    usager.setName(res.getString("nom"));
                    usager.setFirstName(res.getString("prenom"));
                    usager.setEmail(res.getString("email"));
                    if (res.wasNull()) {
                        usager.setEmail(null);
                    }
                    usager.setDateBirth(res.getDate("datenaissance"));
                    if (res.wasNull()) {
                        usager.setDateBirth(null);
                    }
                    usager.setNbConnection(res.getInt("nb_connexion"));
                    listUsagers.add(usager);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listUsagers;
    }

    /** Insert a new Usager in the Database.
     * @param usager New Usager to add in Database.
     */
    public final void insert(final Usager usager) {
        try (PreparedStatement pst = connection.prepareStatement("INSERT INTO usager (\"nom\", \"prenom\", \"datenaissance\", \"email\") VALUES (?, ?, ?, ?)")) {
            pst.setString(1, usager.getName());
            pst.setString(2, usager.getFirstName());
            if (usager.getDateBirth() == null) {
                pst.setNull(3, java.sql.Types.DATE);
            } else {
                pst.setDate(3, new Date(usager.getDateBirth().getTime()));
            }
            if (usager.getEmail() == null) {
                pst.setNull(4, java.sql.Types.VARCHAR);
            } else {
                pst.setString(4, usager.getEmail());
            }
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /** Delete one user from Table.
     * @param user user to delete.
     */
    public final void delete(final Usager user) {
        try (PreparedStatement pst = connection.prepareStatement(
                                    "DELETE FROM usager WHERE id = ?")) {
            pst.setInt(1, user.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /** Update an Usager in the Table.
     * @param user User to update.
     */
    public final void update(final Usager user) {
        try (PreparedStatement pst = connection.prepareStatement(
                "UPDATE usager SET nom = ?, prenom = ?, datenaissance = ?, email = ?, nb_connexion = ? WHERE id = ?")) {
            pst.setString(1, user.getName());
            pst.setString(2, user.getFirstName());
            if (user.getDateBirth() == null) {
                pst.setNull(3, java.sql.Types.DATE);
            } else {
                pst.setDate(3, new Date(user.getDateBirth().getTime()));
            }
            if (user.getEmail() == null) {
                pst.setNull(4, java.sql.Types.VARCHAR);
            } else {
                pst.setString(4, user.getEmail());
            }
            pst.setInt(5, user.getNbConnection());
            pst.setInt(6, user.getId());

            pst.executeUpdate();

            pst.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public final void close() throws Exception {
        connection.close();
    }
}
