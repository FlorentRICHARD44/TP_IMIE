package fr.imie.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.imie.entities.UsagerEntity;

/**
 * @author imie
 *
 */
@Stateless
public class Services {

    @PersistenceContext EntityManager em;
    /**
     * 
     */
    public Services() {
        super();
    }
    
    public UsagerEntity findById(Integer id){
        UsagerEntity user = em.find(UsagerEntity.class, id);
        return user;
    }
    
    public List<UsagerEntity> findAll() {
        @SuppressWarnings("unchecked")
        List<UsagerEntity> userList = em.createNamedQuery("UsagerEntity.findAll").getResultList();
        return userList;
    }
}
