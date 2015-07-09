package fr.imie.formation.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.sql.DataSource;

import fr.imie.formation.jdbc.NullFilterException;
import fr.imie.formation.jdbc.dto.DtoSite;
import fr.imie.formation.jdbc.dto.DtoUsager;

/**
 * Session Bean implementation class UsagerEjbDAO
 */
@Stateless
public class UsagerEjbDAO implements IDao<DtoUsager> {

    @Resource(lookup = "java:/jdbc/archi")
    private DataSource dataSource;
    /**
     * Default constructor.
     */
    public UsagerEjbDAO() {
        super();
    }
    @Override
    public void close() throws Exception {
        // TODO Auto-generated method stub

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
        DtoSite dtoSite = new DtoSite();
        dtoSite.setId(res.getInt("si_id"));
        if (res.wasNull()) {
            dtoSite = null;
        }
        usager.setInscrSite(dtoSite);
        usager.setPassword(res.getString("password"));
        return usager;
    }
    @Override
    public List<DtoUsager> selectAll() {
        List<DtoUsager> listUsagers = new ArrayList<DtoUsager>();
        try (PreparedStatement pst = dataSource.getConnection().prepareStatement(
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
    @Override
    public DtoUsager getById(Integer id) {
        DtoUsager usager = null;
        try (PreparedStatement pst = dataSource.getConnection().prepareStatement(
                    "SELECT * FROM usager WHERE id = ?")) {
            pst.setInt(1, id);
            try (ResultSet res = pst.executeQuery()) {
                if (res.next()) {
                    usager = convertResultToDTO(res);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usager;
    }
    @Override
    public DtoUsager insert(final DtoUsager usager) {
        DtoUsager newUsager = null;
        try (PreparedStatement pst = dataSource.getConnection().prepareStatement(
                "INSERT INTO usager (nom, prenom, datenaissance, email, si_id) VALUES (?, ?, ?, ?, ?) returning *;")) {
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
            if (usager.getInscrSite() == null) {
                pst.setNull(5, java.sql.Types.INTEGER);
            } else {
                pst.setInt(5, usager.getInscrSite().getId());
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
    @Override
    public final void delete(final DtoUsager user) {
        try (PreparedStatement pst = dataSource.getConnection().prepareStatement(
                                    "DELETE FROM usager WHERE id = ?")) {
            pst.setInt(1, user.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void update(DtoUsager user) {
        try (PreparedStatement pst = dataSource.getConnection().prepareStatement(
                "UPDATE usager SET nom = ?, prenom = ?, datenaissance = ?, email = ?, nb_connexion = ?, si_id = ?, password = ? WHERE id = ?")) {
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
            if (user.getInscrSite() == null) {
                pst.setNull(6, java.sql.Types.INTEGER);
            } else {
                pst.setInt(6, user.getInscrSite().getId());
            }
            if (user.getPassword() == null) {
                pst.setNull(7, java.sql.Types.VARCHAR);
            } else {
                pst.setString(7, user.getPassword());
            }
            pst.setInt(8, user.getId());

            pst.executeUpdate();

            pst.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<DtoUsager> selectFiltered(DtoUsager elementFilter)
            throws NullFilterException {
        String query = "";
        /* Construct the query */
        if (elementFilter.getName() != null) {
            query = query.concat(String.format("nom LIKE ?"));
        }
        if (elementFilter.getFirstName() != null) {
            if (query.length() > 0) {
                query = query.concat(" AND ");
            }
            query = query.concat(String.format("prenom LIKE ?"));
        }
        if (elementFilter.getDateBirth() != null) {
            if (query.length() > 0) {
                query = query.concat(" AND ");
            }
            query = query.concat(String.format("datenaissance = ?"));
        }
        if (elementFilter.getEmail() != null) {
            if (query.length() > 0) {
                query = query.concat(" AND ");
            }
            query = query.concat(String.format("email LIKE ?"));
        }
        if (elementFilter.getNbConnection() != null) {
            if (query.length() > 0) {
                query = query.concat(" AND ");
            }
            query = query.concat(String.format("nb_connexion = ?"));
        }
        if (elementFilter.getInscrSite() != null) {
            if (query.length() > 0) {
                query = query.concat(" AND ");
            }
            query = query.concat(String.format("si_id = ?"));
        }
        if (query.length() == 0) {
            throw new NullFilterException("Impossible de faire un filtre: aucun paramètre n'est défini");
        }
        List<DtoUsager> listUsagers = new ArrayList<DtoUsager>();
        try (PreparedStatement pst = dataSource.getConnection().prepareStatement(
                    "SELECT * FROM usager WHERE " + query)) {
            Integer nbParam = 1;
            if (elementFilter.getName() != null) {
                pst.setString(nbParam++, "%" + elementFilter.getName() + "%");
            }
            if (elementFilter.getFirstName() != null) {
                pst.setString(nbParam++,
                              "%" + elementFilter.getFirstName() + "%");
            }
            if (elementFilter.getDateBirth() != null) {
                pst.setDate(nbParam++,
                            new Date(elementFilter.getDateBirth().getTime()));
            }
            if (elementFilter.getEmail() != null) {
                pst.setString(nbParam++, "%" + elementFilter.getEmail() + "%");
            }
            if (elementFilter.getNbConnection() != null) {
                pst.setInt(nbParam++, elementFilter.getNbConnection());
            }
            if (elementFilter.getInscrSite() != null) {
                pst.setInt(nbParam++, elementFilter.getInscrSite().getId());
            }
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
    public final void delete(final DtoUsager user, final Connection con) {
        try (PreparedStatement pst = con.prepareStatement(
                                    "DELETE FROM usager WHERE id = ?")) {
            pst.setInt(1, user.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
