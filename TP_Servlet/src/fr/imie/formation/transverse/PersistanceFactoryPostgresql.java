/**
 * 
 */
package fr.imie.formation.transverse;

import fr.imie.formation.jdbc.dao.DaoSite;
import fr.imie.formation.jdbc.dao.DaoUsager;
import fr.imie.formation.jdbc.dao.IDao;
import fr.imie.formation.jdbc.dto.DtoSite;
import fr.imie.formation.jdbc.dto.DtoUsager;

/**
 * @author imie
 *
 */
public class PersistanceFactoryPostgresql extends AbstractPersistanceFactory {

    /**
     * 
     */
    public PersistanceFactoryPostgresql() {
        super();
    }

    /* (non-Javadoc)
     * @see fr.imie.formation.transverse.AbstractPersistanceFactory#getUsagerDao()
     */
    @Override
    public IDao<DtoUsager> getUsagerDao() {
        return new DaoUsager();
    }

    /* (non-Javadoc)
     * @see fr.imie.formation.transverse.AbstractPersistanceFactory#getSiteDao()
     */
    @Override
    public IDao<DtoSite> getSiteDao() {
        return new DaoSite();
    }

}
