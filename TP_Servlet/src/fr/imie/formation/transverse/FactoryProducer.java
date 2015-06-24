/**
 * 
 */
package fr.imie.formation.transverse;

/**
 * @author imie
 *
 */
public class FactoryProducer {
    private AbstractServiceFactory serviceFactory = null;
    private AbstractPersistanceFactory persistanceFactory = null;
    /**
     * 
     */
    public FactoryProducer() {
        super();
        serviceFactory = new ServiceFactory();
        persistanceFactory = new PersistanceFactoryPostgresql();
    }
    
    public AbstractServiceFactory getServiceFactory() {
        return serviceFactory;
    }
    
    public AbstractPersistanceFactory getPersistanceFactory() {
        return persistanceFactory;
    }
}
