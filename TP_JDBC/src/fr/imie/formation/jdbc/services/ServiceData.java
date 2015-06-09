package fr.imie.formation.jdbc.services;

import java.util.ArrayList;
import java.util.List;

import fr.imie.formation.jdbc.NullFilterException;
import fr.imie.formation.jdbc.dao.DaoSite;
import fr.imie.formation.jdbc.dao.DaoUsager;
import fr.imie.formation.jdbc.dao.IDao;
import fr.imie.formation.jdbc.data.Site;
import fr.imie.formation.jdbc.data.Usager;
import fr.imie.formation.jdbc.dto.DtoSite;
import fr.imie.formation.jdbc.dto.DtoUsager;

/** Service to access the data from DAO.
 * @author Florent RICHARD
 */
public class ServiceData implements AutoCloseable {
    /** Access to Database for Usager.
     */
    private IDao<DtoUsager> daoUsager;
    /** Access to Database for Site.
     */
    private IDao<DtoSite> daoSite;
    /** Constructor.
     */
    public ServiceData() {
        daoUsager = new DaoUsager();
        daoSite = new DaoSite();
    }

    /** Return the list of all Usagers.
     * @return List of all Usagers.
     */
    public final List<Usager> selectAllUsagers() {
        List<DtoUsager> dtoUsagers = daoUsager.selectAll();
        List<Usager> usagers = new ArrayList<Usager>();
        for (DtoUsager dtoU: dtoUsagers) {
            usagers.add(dtoToData(dtoU));
        }
        return usagers;
    }

    /** Return the list of all Sites.
     * @return List of all Sites.
     */
    public final List<Site> selectAllSites() {
        List<DtoSite> dtoSites = daoSite.selectAll();
        List<Site> sites = new ArrayList<Site>();
        for (DtoSite dtoS: dtoSites) {
            sites.add(dtoToData(dtoS));
        }
        return sites;
    }

    /** Return an Usager specified by its Id.
     * @param id Id of the usager to return.
     * @return Usager corresponding to the id, null if not existing.
     */
    public final Usager getById(final Integer id) {
        Usager usager = null;
        DtoUsager dtoUsager = daoUsager.getById(id);
        if (dtoUsager == null) {
            usager = dtoToData(dtoUsager);
        }
        return usager;
    }

    /** Add a new usager.
     * @param data usager to add.
     * @return usager added.
     */
    public final Usager insert(final Usager data) {
        return dtoToData(daoUsager.insert(dataToDto(data)));
    }

    /** Add a new Site.
     * @param data Site to add.
     * @return Site added.
     */
    public final Site insert(final Site data) {
        return dtoToData(daoSite.insert(dataToDto(data)));
    }

    /** Remove an usager.
     * @param data usager to remove.
     */
    public final void delete(final Usager data) {
        daoUsager.delete(dataToDto(data));
    }

    /** Remove a site.
     * @param data Site to remove.
     * @throws Exception case of error during delete.
     */
    public final void delete(final Site data) throws Exception {
        DtoUsager usager = new DtoUsager();
        usager.setName(null);
        usager.setFirstName(null);
        usager.setDateBirth(null);
        usager.setEmail(null);
        usager.setNbConnection(null);
        usager.setId(null);
        usager.setInscrSite(dataToDto(data));
        List<DtoUsager> listUsager = new ArrayList<DtoUsager>();
        try {
            listUsager = daoUsager.selectFiltered(usager);
        } catch (NullFilterException e) {
            // Exception never raised since DtoUsager set in filter
            // contains setInscrSite() not null.
        }
        if (listUsager.size() == 0) {
            daoSite.delete(dataToDto(data));
        } else {
            throw new Exception("Un site ne peut être supprimé si des usagers y sont rattachés");
        }
    }

    /** Modify an usager.
     * @param data Element to modify with new values to apply.
     */
    public final void update(final Usager data) {
        daoUsager.update(dataToDto(data));
    }

    /** Modify a site.
     * @param data Element to modify with new values to apply.
     */
    public final void update(final Site data) {
        daoSite.update(dataToDto(data));
    }

    /** Return a list of elements corresponding to the filter specified.
     * Attributes set to null in the filter are not used for filtering.
     * @param elementFilter Pattern of element.
     * @return List of elements corresponding to the filter.
     * @throws Exception Case of error during filtering.
     */
    public final List<Usager> selectFiltered(final Usager elementFilter)
            throws Exception {
        List<DtoUsager> dtoUsagers = daoUsager.selectFiltered(
                                        dataToDto(elementFilter));
        List<Usager> usagers = new ArrayList<Usager>();
        for (DtoUsager dtoU: dtoUsagers) {
            usagers.add(dtoToData(dtoU));
        }
        return usagers;
    }

    /** Convert from Usager to DtoUsager.
     * @param usager Usager in input
     * @return DtoUsager in output
     */
    private DtoUsager dataToDto(final Usager usager) {
        DtoUsager dtoUsager = new DtoUsager();
        dtoUsager.setId(usager.getId());
        dtoUsager.setName(usager.getName());
        dtoUsager.setFirstName(usager.getFirstName());
        dtoUsager.setDateBirth(usager.getDateBirth());
        dtoUsager.setEmail(usager.getEmail());
        dtoUsager.setNbConnection(usager.getNbConnection());
        if (usager.getInscrSite() == null) {
            dtoUsager.setInscrSite(null);
        } else {
            dtoUsager.setInscrSite(dataToDto(usager.getInscrSite()));
        }
        return dtoUsager;
    }

    /** Convert from DtoUsager to Usager.
     * @param dtoUsager DtoUsager in input
     * @return Usager in output
     */
    private Usager dtoToData(final DtoUsager dtoUsager) {
        Usager usager = new Usager();
        usager.setId(dtoUsager.getId());
        usager.setName(dtoUsager.getName());
        usager.setFirstName(dtoUsager.getFirstName());
        usager.setDateBirth(dtoUsager.getDateBirth());
        usager.setEmail(dtoUsager.getEmail());
        usager.setNbConnection(dtoUsager.getNbConnection());
        if (dtoUsager.getInscrSite() == null) {
            usager.setInscrSite(null);
        } else {
            Integer id = dtoUsager.getInscrSite().getId();
            DtoSite dtoSite = daoSite.getById(id);
            usager.setInscrSite(dtoToData(dtoSite));
        }
        return usager;
    }

    /** Convert from Site to DtoSite.
     * @param site Site in input
     * @return DtoSite in output
     */
    private DtoSite dataToDto(final Site site) {
        DtoSite dtoSite = new DtoSite();
        dtoSite.setId(site.getId());
        dtoSite.setName(site.getName());
        return dtoSite;
    }

    /** Convert from DtoUsager to Usager.
     * @param dtoSite DtoUsager in input
     * @return Usager in output
     */
    private Site dtoToData(final DtoSite dtoSite) {
        Site site = new Site();
        site.setId(dtoSite.getId());
        site.setName(dtoSite.getName());
        return site;
    }

    @SuppressWarnings("javadoc")
    @Override
    public final void close() throws Exception {
        daoUsager.close();
        daoSite.close();
    }
}
