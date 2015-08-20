package fr.imie.woa_mvc.ecommerce.service;

import java.rmi.RemoteException;
import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.imie.woa_mvc.ecommerce.persistance.ProductEntity;


/**
 * Session Bean implementation class ServiceProducts
 */
@Stateless
public class ServiceProducts {
    @PersistenceContext private EntityManager em;
    /**
     * Default constructor. 
     */
    public ServiceProducts() {
        super();
    }
    public List<ProductEntity> findAllProducts() {
        return em.createNamedQuery("ProductEntity.findAll", ProductEntity.class).getResultList();
    }

    public ProductEntity addProduct(ProductEntity productToAdd) throws RemoteException {
        try {
            Query query = em.createNamedQuery("ProductEntity.findByLabel");
            query.setParameter("label", productToAdd.getLabel());
            if (query.getResultList().size() == 0) {
                if (productToAdd.getPrice() > 0) {
                    em.persist(productToAdd);
                } else {
                    throw new IllegalArgumentException("price");
                }
            } else {
                throw new IllegalArgumentException("label");
            }
            return productToAdd;
        } catch (Exception e) {
            throw (RemoteException) new RemoteException(e.getClass().getName(), e);
        }
    }
    public ProductEntity updateProduct(ProductEntity productToUpdate) {
        return em.merge(productToUpdate);
    }
    public void removeProduct(ProductEntity productToDelete) {
        em.remove(em.merge(productToDelete));
    }
}
