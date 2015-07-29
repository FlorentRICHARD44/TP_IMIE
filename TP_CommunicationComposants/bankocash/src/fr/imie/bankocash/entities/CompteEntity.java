package fr.imie.bankocash.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "compte" database table.
 * 
 */
@Entity
@Table(name="compte")
@NamedQuery(name="CompteEntity.findAll", query="SELECT c FROM CompteEntity c")
public class CompteEntity implements Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = -5973082577399041680L;

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id = null;

	@Column(name="id_titulaire")
	private String idTitulaire;

	@Column(name="nom")
	private String nom;

	@Column(name="nom_titulaire")
	private String nomTitulaire;

	@Column(name="prenom_titulaire")
	private String prenomTitulaire;

	@Column(name="solde")
	private double solde;

	public CompteEntity() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdTitulaire() {
		return this.idTitulaire;
	}

	public void setIdTitulaire(String idTitulaire) {
		this.idTitulaire = idTitulaire;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNomTitulaire() {
		return this.nomTitulaire;
	}

	public void setNomTitulaire(String nomTitulaire) {
		this.nomTitulaire = nomTitulaire;
	}

	public String getPrenomTitulaire() {
		return this.prenomTitulaire;
	}

	public void setPrenomTitulaire(String prenomTitulaire) {
		this.prenomTitulaire = prenomTitulaire;
	}

	public double getSolde() {
		return this.solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

}