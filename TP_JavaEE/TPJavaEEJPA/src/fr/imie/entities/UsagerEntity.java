package fr.imie.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/** The persistent class for the "usager" database table.
 */
@Entity
@Table(name="usager")
@NamedQueries({
    @NamedQuery(name="UsagerEntity.findAll", query="SELECT u FROM UsagerEntity u ORDER BY u.nom, u.prenom"),
    @NamedQuery(name="UsagerEntity.findByFullname", query="SELECT u FROM UsagerEntity u WHERE lower(u.nom) like lower(:name) AND lower(u.prenom) like lower(:firstname) ORDER BY u.nom, u.prenom"),
    @NamedQuery(name="UsagerEntity.findBySiteNull", query="SELECT u FROM UsagerEntity u WHERE u.site = null ORDER BY u.nom, u.prenom")
})
public class UsagerEntity implements Serializable {

    /** Serial Version UID.
     */
    private static final long serialVersionUID = -8964746877547011952L;

    /** Identifier for the usager.
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id = null;

    /** Date of birth of the usager.
     */
    @Temporal(TemporalType.DATE)
    @Column(name="datenaissance")
    private Date datenaissance;

    /** Email for the usager.
     */
    @Column(name="email")
    private String email;

    /** Number of connections done by the usager.
     */
    @Column(name="nb_connexion")
    private int nbConnexion;

    /** Last name of the usager.
     */
    @Column(name="nom")
    private String nom;

    /** Password used by the usager.
     */
    @Column(name="password")
    private String password;

    /** First name of the usager.
     */
    @Column(name="prenom")
    private String prenom;

    /** Site where the usager was inscripted.
     */
    @ManyToOne(optional=true) 
    @JoinColumn(name="si_id", nullable=true, updatable=true)
    private SiteEntity site;
    
    /** Hobbies of the usager
     */
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="usagerhobby",
               joinColumns=@JoinColumn(name="usager_id", referencedColumnName="id"),
               inverseJoinColumns=@JoinColumn(name="hobby_id", referencedColumnName="id"))
    private List<HobbyEntity> hobbies;
    /** Constructor.
     */
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

    /**
     * @return the site
     */
    public SiteEntity getSite() {
        return site;
    }

    /**
     * @param site the site to set
     */
    public void setSite(SiteEntity site) {
        this.site = site;
    }

    /**
     * @return the hobbies
     */
    public final List<HobbyEntity> getHobbies() {
        return hobbies;
    }

    /**
     * @param hobbies the hobbies to set
     */
    public final void setHobbies(List<HobbyEntity> hobbies) {
        this.hobbies = hobbies;
    }
}
