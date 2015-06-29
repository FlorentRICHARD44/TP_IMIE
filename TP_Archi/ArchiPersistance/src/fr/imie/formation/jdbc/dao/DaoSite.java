package fr.imie.formation.jdbc.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.imie.formation.jdbc.NullFilterException;
import fr.imie.formation.jdbc.dto.DtoSite;

/** DAO to the Site in PostGreSQL.
 * @author Florent RICHARD
 */
@RealSite
public class DaoSite implements IDao<DtoSite> {
    /** Connection to Database.
     */
    private Connection connection;

    /** Constructor.
     */
    public DaoSite() {
        try {
            connection = ConnectionProvider.getInstance().getConnection();
        } catch (SQLException | DAOConfigurationException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /** Convert a Result into Dto.
     * @param res Result to convert.
     * @return DtoSite Site from result.
     * @throws SQLException Case of error during SQL statement.
     */
    private DtoSite convertResultToDTO(final ResultSet res)
            throws SQLException {
        DtoSite site = new DtoSite();
        site.setId(res.getInt("si_id"));
        site.setName(res.getString("si_nom"));
        return site;
    }

    @SuppressWarnings("javadoc")
    @Override
    public final List<DtoSite> selectAll() {
        List<DtoSite> listSites = new ArrayList<DtoSite>();
        try (PreparedStatement pst = connection.prepareStatement(
                    "SELECT * FROM site")) {
            try (ResultSet res = pst.executeQuery()) {
                while (res.next()) {
                    DtoSite site = convertResultToDTO(res);
                    listSites.add(site);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listSites;
    }

    @SuppressWarnings("javadoc")
    @Override
    public final DtoSite getById(final Integer id) {
        DtoSite site = null;
        try (PreparedStatement pst = connection.prepareStatement(
                    "SELECT * FROM site WHERE si_id = ?")) {
            pst.setInt(1, id);
            try (ResultSet res = pst.executeQuery()) {
                if (res.next()) {
                    site = convertResultToDTO(res);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return site;
    }

    @SuppressWarnings("javadoc")
    @Override
    public final DtoSite insert(final DtoSite site) {
        DtoSite newSite = null;
        try (PreparedStatement pst = connection.prepareStatement(
                    "INSERT INTO site (si_nom) VALUES (?) returning *;")) {
            pst.setString(1, site.getName());
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                newSite = convertResultToDTO(res);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return newSite;
    }

    @SuppressWarnings("javadoc")
    @Override
    public final void delete(final DtoSite site) {
        try (PreparedStatement pst = connection.prepareStatement(
                "DELETE FROM site WHERE si_id = ?")) {
            pst.setInt(1, site.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("javadoc")
    @Override
    public final void delete(final DtoSite site, final Connection con) {
        try (PreparedStatement pst = con.prepareStatement(
                "DELETE FROM site WHERE si_id = ?")) {
            pst.setInt(1, site.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("javadoc")
    @Override
    public final void update(final DtoSite site) {
        try (PreparedStatement pst = connection.prepareStatement(
                "UPDATE site SET si_nom = ? WHERE si_id = ?")) {
            pst.setString(1, site.getName());
            pst.setInt(2, site.getId());

            pst.executeUpdate();

            pst.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("javadoc")
    @Override
    public final List<DtoSite> selectFiltered(final DtoSite elementFilter)
            throws NullFilterException {
        String query = "";
        /* Construct the query */
        if (elementFilter.getName() != null) {
            query = query.concat(String.format("si_nom LIKE ?"));
        }
        if (query.length() == 0) {
            throw new NullFilterException(
                "Impossible de faire un filtre: aucun paramètre n'est défini");
        }
        List<DtoSite> listSites = new ArrayList<DtoSite>();
        try (PreparedStatement pst = connection.prepareStatement(
                    "SELECT * FROM site WHERE " + query)) {
            Integer nbParam = 1;
            if (elementFilter.getName() != null) {
                pst.setString(nbParam++, "%" + elementFilter.getName() + "%");
            }
            try (ResultSet res = pst.executeQuery()) {
                while (res.next()) {
                    DtoSite site = convertResultToDTO(res);
                    listSites.add(site);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listSites;
    }

    @SuppressWarnings("javadoc")
    @Override
    public final void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

}
