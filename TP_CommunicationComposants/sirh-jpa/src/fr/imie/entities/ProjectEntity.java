package fr.imie.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ProjectEntity
 *
 */
@Entity
@Table(name="projets")
@NamedQuery(name="ProjectEntity.findAll", query="SELECT p FROM ProjectEntity p ORDER BY p.nom")
public class ProjectEntity implements Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = 7970967743005295588L;
    @Id
	private Integer id;
	private String nom;
	@Column(name="date_debut", nullable=true)
	private Date date_debut;
    @Column(name="date_fin", nullable=true)
	private Date date_fin;

	public ProjectEntity() {
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
	public Date getDate_debut() {
		return this.date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}   
	public Date getDate_fin() {
		return this.date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
   
}
