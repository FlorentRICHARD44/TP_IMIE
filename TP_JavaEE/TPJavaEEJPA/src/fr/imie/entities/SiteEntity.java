package fr.imie.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: SiteEntity
 *
 */
@Entity
@Table(name="site")
@NamedQuery(name="SiteEntity.findAll", query="SELECT s FROM SiteEntity s")
public class SiteEntity implements Serializable {
	/**
     */
    private static final long serialVersionUID = 2620669870584944116L;
    @Id
	@Column(name="si_id")
	private Integer id;
	@Column(name="si_nom")
	private String nom;

	public SiteEntity() {
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
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return this.nom;
    }
   
}
