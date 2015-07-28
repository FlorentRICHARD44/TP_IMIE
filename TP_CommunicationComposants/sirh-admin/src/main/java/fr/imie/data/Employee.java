package fr.imie.data;

import java.util.List;


public class Employee {
    private Integer id = null;
    private String nom = null;
    private String prenom = null;
    private String matricule = null;
    private List<Project> projects = null;

    public Employee() {
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

    /**
     * @return the projects
     */
    public final List<Project> getProjects() {
        return projects;
    }

    /**
     * @param projects the projects to set
     */
    public final void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
