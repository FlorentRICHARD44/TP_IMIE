package fr.imie.formation.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.sql.DataSource;

import fr.imie.formation.jdbc.NullFilterException;
import fr.imie.formation.jdbc.dto.DtoSite;
@Stateless
public class SiteEjbDAO implements IDao<DtoSite>{


    @Resource(lookup = "java:/jdbc/archi")
    private DataSource dataSource;
    public SiteEjbDAO() {
        super();
    }

    @Override
    public void close() throws Exception {
        // TODO Auto-generated method stub
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

    @Override
    public List<DtoSite> selectAll() {
        List<DtoSite> listSites = new ArrayList<DtoSite>();
        try (PreparedStatement pst = dataSource.getConnection().prepareStatement(
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

    @Override
    public DtoSite getById(Integer id) {
        DtoSite site = null;
        try (PreparedStatement pst = dataSource.getConnection().prepareStatement(
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

    @Override
    public DtoSite insert(DtoSite site) {
        DtoSite newSite = null;
        try (PreparedStatement pst = dataSource.getConnection().prepareStatement(
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

    @Override
    public void delete(DtoSite site) {
        try (PreparedStatement pst = dataSource.getConnection().prepareStatement(
                "DELETE FROM site WHERE si_id = ?")) {
            pst.setInt(1, site.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(DtoSite site) {
        try (PreparedStatement pst = dataSource.getConnection().prepareStatement(
                "UPDATE site SET si_nom = ? WHERE si_id = ?")) {
            pst.setString(1, site.getName());
            pst.setInt(2, site.getId());

            pst.executeUpdate();

            pst.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<DtoSite> selectFiltered(DtoSite elementFilter)
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
        try (PreparedStatement pst = dataSource.getConnection().prepareStatement(
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
    public final void delete(final DtoSite site, final Connection con) {
        try (PreparedStatement pst = con.prepareStatement(
                "DELETE FROM site WHERE si_id = ?")) {
            pst.setInt(1, site.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
