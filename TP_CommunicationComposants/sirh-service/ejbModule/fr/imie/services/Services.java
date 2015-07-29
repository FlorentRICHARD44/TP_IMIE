package fr.imie.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.imie.entities.EmployeeEntity;
import fr.imie.entities.ProjectEntity;

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
        List<EmployeeEntity> employeeList = em.createNamedQuery("EmployeeEntity.findAll", EmployeeEntity.class).getResultList();
        return employeeList;
    }
    
    public EmployeeEntity save(EmployeeEntity employee) {
        EmployeeEntity newemployee = null;
        if (employee.getId() == null) {
            em.persist(employee);
            newemployee = employee;
            newemployee.setMatricule("MAT" + newemployee.getId());
        } else {
            newemployee = em.merge(employee);
        }
        return newemployee;
    }
    
    public void remove(EmployeeEntity employee) {
        em.remove(em.merge(employee));
    }

    public ProjectEntity findProjectById(Integer id) {
        return em.find(ProjectEntity.class, id);
    }
    
    public List<ProjectEntity> findAllProjects() {
        List<ProjectEntity> projList = em.createNamedQuery("ProjectEntity.findAll", ProjectEntity.class).getResultList();
        return projList;
    }
    
    public ProjectEntity save(ProjectEntity project) {
        ProjectEntity newproject = null;
        if (project.getId() == null) {
            em.persist(project);
            newproject = project;
        } else {
            newproject = em.merge(project);
        }
        return newproject;
    }
    
    public void remove(ProjectEntity project) {
        em.remove(em.merge(project));
    }
}
