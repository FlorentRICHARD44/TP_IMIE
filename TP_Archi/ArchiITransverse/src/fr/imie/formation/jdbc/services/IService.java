package fr.imie.formation.jdbc.services;

import java.util.List;

import fr.imie.formation.jdbc.dao.IDao;
import fr.imie.formation.jdbc.data.Site;
import fr.imie.formation.jdbc.data.Usager;
import fr.imie.formation.jdbc.dto.DtoSite;
import fr.imie.formation.jdbc.dto.DtoUsager;

/** Interface for services.
 * @author imie
 *
 */
public interface IService extends AutoCloseable {

    /** Return all the Usagers.
     * @return List of all usagers.
     */
    List<Usager> selectAllUsagers();

    /** Returns all the sites.
     * @return List of all sites.
     */
    List<Site> selectAllSites();

    /** Return the Usager specified by its id.
     * @param id Id of the usager to return
     * @return usager corresponding to id, null if not found.
     */
    Usager getById(Integer id);

    /** Add a new Usager.
     * @param data Usager to add.
     * @return Usager added.
     */
    Usager insert(Usager data);

    /** Add a new Site.
     * @param data Site to add
     * @return Site added.
     */
    Site insert(Site data);

    /** Delete a usager.
     * @param data usager to delete.
     */
    void delete(Usager data);

    /** Delete a Site.
     * @param data Site to delete.
     * @throws Exception when delete can't be done (if some usager are link to the site for example).
     */
    void delete(Site data) throws Exception;

    /** Update the data for a Usager.
     * @param data New Usager data.
     */
    void update(Usager data);

    /** Update the data for a Site.
     * @param data New Site data.
     */
    void update(Site data);

    /** Return all the usager corresponding to the specified filter.
     * @param elementFilter Pattern for usager, not used parameters are let to null.
     * @return List of corresponding usager.
     * @throws Exception Case of error during filtering.
     */
    List<Usager> selectFiltered(Usager elementFilter) throws Exception;

    /** Delete a site and all the usagers attached to the site.
     * @param site Site to delete.
     * @throws Exception Case of error during delete.
     */
    void deleteSiteAndRelatedUsers(Site site) throws Exception;

    /** Check the proposed password for the specified Usager.
     * @param usager usager to check
     * @param password proposed password.
     * @return Usager if password is correct, null else
     */
    Usager checkUsagerPassword(Usager usager, String password);

    /** Modify the password for an usager.
     * @param user usager to modify
     * @param newPassword New Password to apply to usager.
     */
    void modifyUsagerPassword(Usager user, String newPassword);

    void setDaos(IDao<DtoUsager> daoU, IDao<DtoSite> daoS);
}
