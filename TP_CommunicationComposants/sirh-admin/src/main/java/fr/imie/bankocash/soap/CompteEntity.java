
package fr.imie.bankocash.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour compteEntity complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="compteEntity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idTitulaire" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nomTitulaire" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prenomTitulaire" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="solde" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "compteEntity", propOrder = {
    "id",
    "idTitulaire",
    "nom",
    "nomTitulaire",
    "prenomTitulaire",
    "solde"
})
public class CompteEntity {

    protected Integer id;
    protected Integer idTitulaire;
    protected String nom;
    protected String nomTitulaire;
    protected String prenomTitulaire;
    protected double solde;

    /**
     * Obtient la valeur de la propriété id.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propriété idTitulaire.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdTitulaire() {
        return idTitulaire;
    }

    /**
     * Définit la valeur de la propriété idTitulaire.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdTitulaire(Integer value) {
        this.idTitulaire = value;
    }

    /**
     * Obtient la valeur de la propriété nom.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit la valeur de la propriété nom.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNom(String value) {
        this.nom = value;
    }

    /**
     * Obtient la valeur de la propriété nomTitulaire.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomTitulaire() {
        return nomTitulaire;
    }

    /**
     * Définit la valeur de la propriété nomTitulaire.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomTitulaire(String value) {
        this.nomTitulaire = value;
    }

    /**
     * Obtient la valeur de la propriété prenomTitulaire.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrenomTitulaire() {
        return prenomTitulaire;
    }

    /**
     * Définit la valeur de la propriété prenomTitulaire.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrenomTitulaire(String value) {
        this.prenomTitulaire = value;
    }

    /**
     * Obtient la valeur de la propriété solde.
     * 
     */
    public double getSolde() {
        return solde;
    }

    /**
     * Définit la valeur de la propriété solde.
     * 
     */
    public void setSolde(double value) {
        this.solde = value;
    }

}
