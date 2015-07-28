package jaxrs.ihm.domain;

public class Employe {
	private Integer id;
	private String nom;
	private String prenom;
	private String matricule;

	public Employe() {
	}

	public Employe(String nom, String prenom, String matricule) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.matricule = matricule;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	@Override
	public String toString() {
		return String.format(
				"Employe [id=%s, nom=%s, prenom=%s, matricule=%s]", id, nom,
				prenom, matricule);
	}

}
