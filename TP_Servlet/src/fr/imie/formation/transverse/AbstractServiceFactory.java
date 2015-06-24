/**
 * 
 */
package fr.imie.formation.transverse;

import fr.imie.formation.jdbc.services.IService;

/**
 * @author imie
 *
 */
public abstract class AbstractServiceFactory {

    /**
     * 
     */
    public AbstractServiceFactory() {
        // TODO Auto-generated constructor stub
    }
    
    public abstract IService getServiceData();

}
