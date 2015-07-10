package fr.imie.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    
    @SuppressWarnings("unchecked")
    public List<UsagerEntity> findUserByFullname(String name, String firstName) {
        Query query = em.createNamedQuery("UsagerEntity.findByFullname");
        query.setParameter("name", "%" + name + "%");
        query.setParameter("firstname", "%" + firstName + "%");
        return (List<UsagerEntity>) query.getResultList();
    }

    public UsagerEntity save(UsagerEntity user) {
        UsagerEntity newusager = null;
        if (user.getId() == null) {
            em.persist(user);
            newusager = user;
        } else {
            newusager = em.merge(user);
        }
        return newusager;
    }

    public void remove(UsagerEntity user) {
        em.remove(em.merge(user));
    }
}
