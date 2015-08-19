package fr.imie.woa_mvc.ecommerce.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

    public ProductEntity addProduct(ProductEntity productToAdd) {
        em.persist(productToAdd);
        return productToAdd;
    }
    public ProductEntity updateProduct(ProductEntity productToUpdate) {
        return em.merge(productToUpdate);
    }
    public void removeProduct(ProductEntity productToDelete) {
        em.remove(em.merge(productToDelete));
    }
}
