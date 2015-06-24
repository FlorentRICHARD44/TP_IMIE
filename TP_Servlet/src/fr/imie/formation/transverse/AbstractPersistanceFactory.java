/**
 * 
 */
package fr.imie.formation.transverse;

import fr.imie.formation.jdbc.dao.IDao;
import fr.imie.formation.jdbc.dto.DtoSite;
import fr.imie.formation.jdbc.dto.DtoUsager;

/**
 * @author imie
 *
 */
public abstract class AbstractPersistanceFactory {

    /**
     * 
     */
    public AbstractPersistanceFactory() {
        super();
    }
    
    public abstract IDao<DtoUsager> getUsagerDao();
    public abstract IDao<DtoSite> getSiteDao();

}
