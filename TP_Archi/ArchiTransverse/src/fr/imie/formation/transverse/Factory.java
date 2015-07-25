/**
 * 
 */
package fr.imie.formation.transverse;



import fr.imie.formation.jdbc.dao.DaoSite;
import fr.imie.formation.jdbc.dao.DaoUsager;
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
        daoUsager = new DaoUsager();
        daoSite = new DaoSite();
        serviceData = new ServiceData();
    }

    /* (non-Javadoc)
     * @see fr.imie.formation.transverse.IFactory#getUsagerDao()
     */
    @Override
    public IDao<DtoUsager> getUsagerDao() {
        return new DaoUsager();
    }

    /* (non-Javadoc)
     * @see fr.imie.formation.transverse.IFactory#getSiteDao()
     */
    @Override
    public IDao<DtoSite> getSiteDao() {
        return new DaoSite();
    }

    /* (non-Javadoc)
     * @see fr.imie.formation.transverse.IFactory#getService()
     */
    @Override
    public IService getService() {
        //daoUsager = new UsagerEjbDAO();
        //daoSite = new DaoSite();
        IService serv = new ServiceData();
        //serv.setDaos(daoUsager, daoSite);
        return serv;
    }

}
