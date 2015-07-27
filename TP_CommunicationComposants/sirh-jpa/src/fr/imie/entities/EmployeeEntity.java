package fr.imie.entities;

import java.io.Serializable;

import javax.persistence.*;

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
}
