
package fr.imie.bankocash.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.imie.bankocash.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CreateCompte_QNAME = new QName("http://soap.bankocash.imie.fr/", "createCompte");
    private final static QName _CreateCompteResponse_QNAME = new QName("http://soap.bankocash.imie.fr/", "createCompteResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.imie.bankocash.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateCompteResponse }
     * 
     */
    public CreateCompteResponse createCreateCompteResponse() {
        return new CreateCompteResponse();
    }

    /**
     * Create an instance of {@link CreateCompte }
     * 
     */
    public CreateCompte createCreateCompte() {
        return new CreateCompte();
    }

    /**
     * Create an instance of {@link CompteEntity }
     * 
     */
    public CompteEntity createCompteEntity() {
        return new CompteEntity();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCompte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.bankocash.imie.fr/", name = "createCompte")
    public JAXBElement<CreateCompte> createCreateCompte(CreateCompte value) {
        return new JAXBElement<CreateCompte>(_CreateCompte_QNAME, CreateCompte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCompteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.bankocash.imie.fr/", name = "createCompteResponse")
    public JAXBElement<CreateCompteResponse> createCreateCompteResponse(CreateCompteResponse value) {
        return new JAXBElement<CreateCompteResponse>(_CreateCompteResponse_QNAME, CreateCompteResponse.class, null, value);
    }

}
