package fr.imie.formation.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import fr.imie.formation.jdbc.dto.DtoUsager;

/** Class used to access to the database.
 * @author Florent RICHARD
 *
 */
public class DaoUsager implements IDao<DtoUsager> {
    /** Connection to Database.
     */
    private Connection connection;
    /** Date formater for SQL.
     */
    private SimpleDateFormat dateformat;

    /** Constructor.
     */
    public DaoUsager() {
        dateformat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            connection = ConnectionProvider.getInstance().getConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @SuppressWarnings("javadoc")
    @Override
    public final List<DtoUsager> selectAll() {
        List<DtoUsager> listUsagers = new ArrayList<DtoUsager>();
        try (PreparedStatement pst = connection.prepareStatement(
                    "SELECT * FROM usager")) {
            try (ResultSet res = pst.executeQuery()) {
                while (res.next()) {
                    DtoUsager usager = convertResultToDTO(res);
                    listUsagers.add(usager);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listUsagers;
    }

    @SuppressWarnings("javadoc")
    @Override
    public final DtoUsager insert(final DtoUsager usager) {
        DtoUsager newUsager = null;
        try (PreparedStatement pst = connection.prepareStatement("INSERT INTO usager (nom, prenom, datenaissance, email) VALUES (?, ?, ?, ?) returning *;")) {
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
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                newUsager = convertResultToDTO(res);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return newUsager;
    }

    /** Convert a Result into Dto.
     * @param res Result to convert.
     * @return DtoUsager Usager from result.
     * @throws SQLException Case of error during SQL statement.
     */
    private DtoUsager convertResultToDTO(final ResultSet res)
            throws SQLException {
        DtoUsager usager = null;
        usager = new DtoUsager();
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
        return usager;
    }

    @SuppressWarnings("javadoc")
    @Override
    public final void delete(final DtoUsager user) {
        try (PreparedStatement pst = connection.prepareStatement(
                                    "DELETE FROM usager WHERE id = ?")) {
            pst.setInt(1, user.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @SuppressWarnings("javadoc")
    @Override
    public final void update(final DtoUsager user) {
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

    @SuppressWarnings("javadoc")
    @Override
    public final List<DtoUsager> selectFiltered(final DtoUsager elementFilter) throws Exception {
        String query = "";
        /* Construct the query */
        if (elementFilter.getName() != null) {
            query = query.concat(String.format("nom = '%s'",
                                               elementFilter.getName()));
        }
        if (elementFilter.getFirstName() != null) {
            if (query.length() > 0) {
                query = query.concat(" AND ");
            }
            query = query.concat(String.format("prenom = '%s'",
                    elementFilter.getFirstName()));
        }
        if (elementFilter.getDateBirth() != null) {
            if (query.length() > 0) {
                query = query.concat(" AND ");
            }
            query = query.concat(String.format("datenaissance = '%s'",
                    (dateformat.format(elementFilter.getDateBirth().getTime()))));
        }
        if (elementFilter.getEmail() != null) {
            if (query.length() > 0) {
                query = query.concat(" AND ");
            }
            query = query.concat(String.format("email = '%s'",
                    elementFilter.getEmail()));
        }
        if (elementFilter.getNbConnection() != null) {
            if (query.length() > 0) {
                query = query.concat(" AND ");
            }
            query = query.concat(String.format("nb_connexion = %d",
                    elementFilter.getNbConnection()));
        }
        if (query.length() == 0) {
            throw new Exception("Impossible de faire un filtre: aucun paramètre n'est défini");
        }
        List<DtoUsager> listUsagers = new ArrayList<DtoUsager>();
        try (PreparedStatement pst = connection.prepareStatement(
                    "SELECT * FROM usager WHERE " + query)) {
            try (ResultSet res = pst.executeQuery()) {
                while (res.next()) {
                    DtoUsager usager = convertResultToDTO(res);
                    listUsagers.add(usager);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listUsagers;
    }

    /**
     * @see java.lang.AutoCloseable#close()
     */
    @Override
    public final void close() {
    }
}
