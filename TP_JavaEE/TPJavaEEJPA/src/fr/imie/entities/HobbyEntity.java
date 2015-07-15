package fr.imie.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: HobbyEntity
 *
 */
@Entity
@Table(name="hobby")
@NamedQueries({
    @NamedQuery(name="HobbyEntity.findAll", query="SELECT h FROM HobbyEntity h ORDER BY h.nom"),
    @NamedQuery(name="HobbyEntity.findByName", query="SELECT h FROM HobbyEntity h WHERE lower(h.nom) like lower(:name) ORDER BY h.nom")
})
public class HobbyEntity implements Serializable {

	
	/** SerialVersion UID.
     */
    private static final long serialVersionUID = 3259649268792541843L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="nom")
	private String nom;

	public HobbyEntity() {
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
}
