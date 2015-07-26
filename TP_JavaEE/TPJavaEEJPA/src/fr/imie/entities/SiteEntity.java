package fr.imie.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: SiteEntity
 *
 */
@Entity
@Table(name="site")
@NamedQueries({
    @NamedQuery(name="SiteEntity.findAll", query="SELECT s FROM SiteEntity s ORDER BY s.nom"),
    @NamedQuery(name="SiteEntity.findByName", query="SELECT s FROM SiteEntity s WHERE lower(s.nom) like lower(:name) ORDER BY s.nom")
})
public class SiteEntity implements Serializable {
	/**
     */
    private static final long serialVersionUID = 2620669870584944116L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id = null;
	@Column(name="nom")
	private String nom = null;
	@OneToMany(mappedBy="site", fetch=FetchType.EAGER)
	private List<UsagerEntity> usagerList;

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

    @Override
    public String toString() {
        String result;
        if (this.nom == null) {
            result = "Site: -";
        } else {
            result = this.nom;
        }
        return result;
    }

    /**
     * @return the usagerList
     */
    public final List<UsagerEntity> getUsagerList() {
        return usagerList;
    }

    /**
     * @param usagerList the usagerList to set
     */
    public final void setUsagerList(List<UsagerEntity> usagerList) {
        this.usagerList = usagerList;
    }
   
}
