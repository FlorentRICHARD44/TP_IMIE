package fr.imie.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import fr.imie.entities.HobbyEntity;
import fr.imie.entities.SiteEntity;
import fr.imie.entities.UsagerEntity;

/** Service used to access the data.
 * @author Florent RICHARD
 *
 */
@Stateless
public class Services {

    /** Entity Manager for JPA.
     */
    @PersistenceContext EntityManager em;
    /** Constructor.
     */
    public Services() {
        super();
    }

    /** Retrieves an Usage from its Identifier.
     * @param id ID of the Usager to find
     * @return Usager corresponding to the id, null if not found.
     */
    public UsagerEntity findUsagerById(Integer id){
        return em.find(UsagerEntity.class, id);
    }

    /** Retrieves the list of all the Usagers.
     * @return List of all the usagers.
     */
    public List<UsagerEntity> findAllUsagers() {
        @SuppressWarnings("unchecked")
        List<UsagerEntity> userList = em.createNamedQuery("UsagerEntity.findAll").getResultList();
        return userList;
    }
    
    /** Return a List of Usager which name and firstname corresponds to pattern defined.
     * @param name pattern of the name of usager to find
     * @param firstName pattern of the first name of usager to find
     * @return List of Usager corresponding to pattern.
     */
    @SuppressWarnings("unchecked")
    public List<UsagerEntity> findUserByFullname(String name, String firstName) {
        Query query = em.createNamedQuery("UsagerEntity.findByFullname");
        query.setParameter("name", "%" + name + "%");
        query.setParameter("firstname", "%" + firstName + "%");
        return (List<UsagerEntity>) query.getResultList();
    }
    
    /** Return a List of Usager which is attached to a site.
     * @param site Site to retrieve usagers.
     * @return List of Usager
     */
    @SuppressWarnings("unchecked")
    public List<UsagerEntity> findUsagersBySite(SiteEntity site) {
        List<UsagerEntity> usagerlist = null;
        Query query = null;
        if (site == null) {
            query = em.createNamedQuery("UsagerEntity.findBySiteNull");
            usagerlist = (List<UsagerEntity>) query.getResultList();
        } else {
            usagerlist = em.find(SiteEntity.class, site.getId()).getUsagerList();
        }
        return usagerlist;
    }
    /** Save an Usager in persistance (creation or update).
     * @param user Usager to save
     * @return Usager as saved in persistance.
     */
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

    /** Delete an Usager from persistance.
     * @param user Usager to delete
     */
    public void remove(UsagerEntity user) {
        em.remove(em.merge(user));
    }

    /** Retrieves the list of all the sites.
     * @return List of all the sites.
     */
    public List<SiteEntity> findAllSites() {
        @SuppressWarnings("unchecked")
        List<SiteEntity> siteList = em.createNamedQuery("SiteEntity.findAll").getResultList();
        return siteList;
    }

    /** Retrieves a Site from its Identifier.
     * @param id Id of the site to find.
     * @return Site corresponding to the id, null if not found.
     */
    public SiteEntity findSiteById(Integer id) {
        return em.find(SiteEntity.class, id);
    }

    /** Retrieves the list of all the sites which name corresponds to the pattern.
     * @param name Pattern of the site name.
     * @return List of sites.
     */
    @SuppressWarnings("unchecked")
    public List<SiteEntity> findSiteByName(String name) {
        Query query = em.createNamedQuery("SiteEntity.findByName");
        query.setParameter("name", "%" + name + "%");
        return (List<SiteEntity>) query.getResultList();
    }

    /** Saves a site in persistance.
     * @param site Site to save
     * @return Site as saved in persistance.
     */
    public SiteEntity save(SiteEntity site) {
        SiteEntity newsite = null;
        if (site.getId() == null) {
            em.persist(site);
            newsite = site;
        } else {
            newsite = em.merge(site);
        }
        return newsite;
    }

    /** Delete a Site from the persistance.
     * The site can't be deleted if an other entity is linked to it.
     * @param site Site to delete
     * @return done true if the remove is done, else false.
     */
    public Boolean remove(SiteEntity site) {
        Boolean done = false;
        if (findUsagersBySite(site).size() == 0) {
            em.remove(em.merge(site));
            done = true;
        }
        return done;
    }

    /** Check the password for an usager.
     * The Usager is identified with its firstname and lastname
     * @param filter Usager to check
     * @param password proposed password to be check with the persistance one.
     * @return Usager if the password is correct, null else.
     */
    public UsagerEntity checkUsagerPassword(UsagerEntity filter,
            String password) {
        UsagerEntity user = null;
        Query query = em.createNamedQuery("UsagerEntity.findByFullname");
        query.setParameter("name", "%" + filter.getNom() + "%");
        query.setParameter("firstname", "%" + filter.getPrenom() + "%");
        user = (UsagerEntity) query.getSingleResult();
        if (!user.getPassword().equals(password)) {
            user = null;
        }
        return user;
    }

    public List<HobbyEntity> findAllHobbies() {
        @SuppressWarnings("unchecked")
        List<HobbyEntity> hobbyList = em.createNamedQuery("HobbyEntity.findAll").getResultList();
        return hobbyList;
    }

    public List<HobbyEntity> findHobbyByName(String name) {
        Query query = em.createNamedQuery("HobbyEntity.findByName");
        query.setParameter("name", "%" + name + "%");
        return (List<HobbyEntity>) query.getResultList();
    }

    public HobbyEntity findHobbyById(Integer id) {
        return em.find(HobbyEntity.class, id);
    }

    public HobbyEntity save(HobbyEntity hobby) {
        HobbyEntity newhobby = null;
        if (hobby.getId() == null) {
            em.persist(hobby);
            newhobby = hobby;
        } else {
            newhobby = em.merge(hobby);
        }
        return newhobby;
    }

    public void remove(HobbyEntity hobby) {
        em.remove(em.merge(hobby));
    }
}
