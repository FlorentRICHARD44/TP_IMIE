package fr.imie.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.imie.entities.EmployeeEntity;

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

    public EmployeeEntity findEmployeeById(Integer id) {
        return em.find(EmployeeEntity.class, id);
    }
    
    public List<EmployeeEntity> findAllEmployees() {
        @SuppressWarnings("unchecked")
        List<EmployeeEntity> userList = em.createNamedQuery("EmployeeEntity.findAll").getResultList();
        return userList;
    }
    
    public EmployeeEntity save(EmployeeEntity employee) {
        EmployeeEntity newemployee = null;
        if (employee.getId() == null) {
            em.persist(employee);
            newemployee = employee;
        } else {
            newemployee = em.merge(employee);
        }
        return newemployee;
    }
    
    public void remove(EmployeeEntity employee) {
        em.remove(em.merge(employee));
    }
}
