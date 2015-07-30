package fr.imie.bankocash.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.imie.bankocash.entities.CompteEntity;

/**
 * Session Bean implementation class BankService
 */
@Stateless
public class BankService {

    /** Entity Manager for JPA.
     */
    @PersistenceContext EntityManager em;

    /**
     * Default constructor. 
     */
    public BankService() {
        super();
    }

    public CompteEntity findCompteById(Integer id) {
        return em.find(CompteEntity.class, id);
    }
    
    public List<CompteEntity> findAllComptes() {
        List<CompteEntity> compteList = em.createNamedQuery("CompteEntity.findAll", CompteEntity.class).getResultList();
        return compteList;
    }
    
    public List<CompteEntity> findCompteByEmployee(Integer id) {
        try {
            Query query = em.createNamedQuery("CompteEntity.findByEmployee", CompteEntity.class);
            query.setParameter("id", id);
            return query.getResultList();
        } catch(IndexOutOfBoundsException e) {
            return null;
        }
    }
    
    public CompteEntity crediteCompte(CompteEntity compte, Float value) {
        compte = em.getReference(CompteEntity.class, compte.getId());
        compte.setSolde(compte.getSolde() + value);
        return compte;
    }
    
    public CompteEntity debiteCompte(CompteEntity compte, Float value) {
        compte = em.getReference(CompteEntity.class, compte.getId());
        compte.setSolde(compte.getSolde() - value);
        return compte;
    }
    
    public CompteEntity save(CompteEntity compte) {
        CompteEntity newcompte = null;
        if (compte.getId() == null) {
            em.persist(compte);
            newcompte = compte;
            newcompte.setNom(newcompte.getNomTitulaire() + "_" + newcompte.getPrenomTitulaire() + "_" + newcompte.getId());
        } else {
            newcompte = em.merge(compte);
        }
        return newcompte;
    }
    
    public void remove(CompteEntity compte) {
        em.remove(em.merge(compte));
    }
}
