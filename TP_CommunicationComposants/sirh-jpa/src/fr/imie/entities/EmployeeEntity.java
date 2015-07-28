package fr.imie.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: EmployeeEntity
 *
 */
@Entity
@Table(name="employes")
@NamedQuery(name="EmployeeEntity.findAll", query="SELECT e FROM EmployeeEntity e ORDER BY e.nom, e.prenom")
public class EmployeeEntity implements Serializable {
    /**
     */
    private static final long serialVersionUID = -590229274115287976L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id = null;
    @Column(name="nom")
    private String nom = null;
    @Column(name="prenom")
    private String prenom = null;
    @Column(name="matricule")
    private String matricule = null;
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="employes_projets",
               joinColumns=@JoinColumn(name="employe_id", referencedColumnName="id"),
               inverseJoinColumns=@JoinColumn(name="projet_id", referencedColumnName="id"))
    private List<ProjectEntity> projects = null;

    public EmployeeEntity() {
        super();
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer si_id) {
        this.id = si_id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String si_nom) {
        this.nom = si_nom;
    }

    /**
     * @return the prenom
     */
    public final String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public final void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the matricule
     */
    public final String getMatricule() {
        return matricule;
    }

    /**
     * @param matricule the matricule to set
     */
    public final void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public List<ProjectEntity> getProjects() {
        return this.projects;
    }
    
    public void setProjects(List<ProjectEntity> projects) {
        this.projects = projects;
    }
}
