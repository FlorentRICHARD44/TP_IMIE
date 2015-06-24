/**
 * 
 */
package fr.imie.formation.transverse;

import fr.imie.formation.jdbc.services.IService;
import fr.imie.formation.jdbc.services.ServiceData;

/**
 * @author imie
 *
 */
public class ServiceFactory extends AbstractServiceFactory {

    /**
     * 
     */
    public ServiceFactory() {
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see fr.imie.formation.transverse.AbstractServiceFactory#getServiceData()
     */
    @Override
    public IService getServiceData() {
        return new ServiceData();
    }

}
