package fr.imie.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the "usager" database table.
 * 
 */
@Entity
@Table(name="usager")
@NamedQueries({
    @NamedQuery(name="UsagerEntity.findAll", query="SELECT u FROM UsagerEntity u ORDER BY u.nom, u.prenom"),
    @NamedQuery(name="UsagerEntity.findByFullname", query="SELECT u FROM UsagerEntity u WHERE lower(u.nom) like lower(:name) AND lower(u.prenom) like lower(:firstname) ORDER BY u.nom, u.prenom")
})
public class UsagerEntity implements Serializable {

    /**
     */
    private static final long serialVersionUID = -8964746877547011952L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id = null;

    @Temporal(TemporalType.DATE)
    @Column(name="datenaissance")
    private Date datenaissance;

    @Column(name="email")
    private String email;

    @Column(name="nb_connexion")
    private int nbConnexion;

    @Column(name="nom")
    private String nom;

    @Column(name="password")
    private String password;

    @Column(name="prenom")
    private String prenom;

    public UsagerEntity() {
        super();
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatenaissance() {
        return this.datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNbConnexion() {
        return this.nbConnexion;
    }

    public void setNbConnexion(int nbConnexion) {
        this.nbConnexion = nbConnexion;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
