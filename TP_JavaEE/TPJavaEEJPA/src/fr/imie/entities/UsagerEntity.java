package fr.imie.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: UsagerEntity
 *
 */
@Entity
@Table(name="usager")
public class UsagerEntity implements Serializable {
	/**
     */
    private static final long serialVersionUID = -3238352129673799825L;
    @Id
	private Integer id;
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private Integer nb_connexion;
	private Integer si_id;
	private Date datenaissance;

	public UsagerEntity() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public Integer getNb_connexion() {
		return this.nb_connexion;
	}

	public void setNb_connexion(Integer nb_connexion) {
		this.nb_connexion = nb_connexion;
	}   
	public Integer getSi_id() {
		return this.si_id;
	}

	public void setSi_id(Integer si_id) {
		this.si_id = si_id;
	}
    /**
     * @return the datenaissance
     */
    public Date getDatenaissance() {
        return datenaissance;
    }
    /**
     * @param datenaissance the datenaissance to set
     */
    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }
   
}
