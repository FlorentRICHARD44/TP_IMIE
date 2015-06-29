/**
 * 
 */
package fr.imie.formation.transverse;



import javax.enterprise.inject.Produces;

import fr.imie.formation.jdbc.dao.DaoSite;
import fr.imie.formation.jdbc.dao.DaoUsager;
import fr.imie.formation.jdbc.dao.DummyDaoSite;
import fr.imie.formation.jdbc.dao.DummyDaoUsager;
import fr.imie.formation.jdbc.dao.IDao;
import fr.imie.formation.jdbc.dto.DtoSite;
import fr.imie.formation.jdbc.dto.DtoUsager;
import fr.imie.formation.jdbc.services.IService;
import fr.imie.formation.jdbc.services.ServiceData;

/**
 * @author imie
 *
 */
public class Factory implements IFactory {
    private IService serviceData = null;
    private IDao<DtoUsager> daoUsager = null;
    private IDao<DtoSite> daoSite = null;
    /**
     * 
     */
    public Factory() {
        super();
        daoUsager = new DummyDaoUsager();
        daoSite = new DummyDaoSite();
        serviceData = new ServiceData();
    }

    /* (non-Javadoc)
     * @see fr.imie.formation.transverse.IFactory#getUsagerDao()
     */
    @Override
    @Produces
    public IDao<DtoUsager> getUsagerDao() {
        return new DummyDaoUsager();
    }

    /* (non-Javadoc)
     * @see fr.imie.formation.transverse.IFactory#getSiteDao()
     */
    @Override
    @Produces
    public IDao<DtoSite> getSiteDao() {
        return new DummyDaoSite();
    }

    /* (non-Javadoc)
     * @see fr.imie.formation.transverse.IFactory#getService()
     */
    @Override
    public IService getService() {
        daoUsager = new DummyDaoUsager();
        daoSite = new DummyDaoSite();
        return new ServiceData();
    }

}
