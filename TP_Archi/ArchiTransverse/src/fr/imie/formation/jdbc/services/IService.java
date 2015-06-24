/**
 * 
 */
package fr.imie.formation.jdbc.services;

import java.util.List;

import fr.imie.formation.jdbc.data.Site;
import fr.imie.formation.jdbc.data.Usager;

/**
 * @author imie
 *
 */
public interface IService extends AutoCloseable {

    List<Usager> selectAllUsagers();

    List<Site> selectAllSites();

    Usager getById(Integer id);

    Usager insert(Usager data);

    Site insert(Site data);

    void delete(Usager data);

    void delete(Site data) throws Exception;

    void update(Usager data);

    void update(Site data);

    List<Usager> selectFiltered(Usager elementFilter) throws Exception;

    void deleteSiteAndRelatedUsers(Site site) throws Exception;

    Usager checkUsagerPassword(Usager usager, String password);

    void modifyUsagerPassword(Usager user, String newPassword);
}
