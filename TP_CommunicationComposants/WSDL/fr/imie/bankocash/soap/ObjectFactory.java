
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

    private final static QName _DebiteCompteResponse_QNAME = new QName("http://soap.bankocash.imie.fr/", "debiteCompteResponse");
    private final static QName _CrediteCompte_QNAME = new QName("http://soap.bankocash.imie.fr/", "crediteCompte");
    private final static QName _FindCompteByEmployee_QNAME = new QName("http://soap.bankocash.imie.fr/", "findCompteByEmployee");
    private final static QName _CreateCompte_QNAME = new QName("http://soap.bankocash.imie.fr/", "createCompte");
    private final static QName _FindCompteByEmployeeResponse_QNAME = new QName("http://soap.bankocash.imie.fr/", "findCompteByEmployeeResponse");
    private final static QName _DebiteCompte_QNAME = new QName("http://soap.bankocash.imie.fr/", "debiteCompte");
    private final static QName _CrediteCompteResponse_QNAME = new QName("http://soap.bankocash.imie.fr/", "crediteCompteResponse");
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
     * Create an instance of {@link CrediteCompteResponse }
     * 
     */
    public CrediteCompteResponse createCrediteCompteResponse() {
        return new CrediteCompteResponse();
    }

    /**
     * Create an instance of {@link DebiteCompte }
     * 
     */
    public DebiteCompte createDebiteCompte() {
        return new DebiteCompte();
    }

    /**
     * Create an instance of {@link FindCompteByEmployeeResponse }
     * 
     */
    public FindCompteByEmployeeResponse createFindCompteByEmployeeResponse() {
        return new FindCompteByEmployeeResponse();
    }

    /**
     * Create an instance of {@link CreateCompte }
     * 
     */
    public CreateCompte createCreateCompte() {
        return new CreateCompte();
    }

    /**
     * Create an instance of {@link CrediteCompte }
     * 
     */
    public CrediteCompte createCrediteCompte() {
        return new CrediteCompte();
    }

    /**
     * Create an instance of {@link FindCompteByEmployee }
     * 
     */
    public FindCompteByEmployee createFindCompteByEmployee() {
        return new FindCompteByEmployee();
    }

    /**
     * Create an instance of {@link DebiteCompteResponse }
     * 
     */
    public DebiteCompteResponse createDebiteCompteResponse() {
        return new DebiteCompteResponse();
    }

    /**
     * Create an instance of {@link CompteEntity }
     * 
     */
    public CompteEntity createCompteEntity() {
        return new CompteEntity();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DebiteCompteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.bankocash.imie.fr/", name = "debiteCompteResponse")
    public JAXBElement<DebiteCompteResponse> createDebiteCompteResponse(DebiteCompteResponse value) {
        return new JAXBElement<DebiteCompteResponse>(_DebiteCompteResponse_QNAME, DebiteCompteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CrediteCompte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.bankocash.imie.fr/", name = "crediteCompte")
    public JAXBElement<CrediteCompte> createCrediteCompte(CrediteCompte value) {
        return new JAXBElement<CrediteCompte>(_CrediteCompte_QNAME, CrediteCompte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCompteByEmployee }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.bankocash.imie.fr/", name = "findCompteByEmployee")
    public JAXBElement<FindCompteByEmployee> createFindCompteByEmployee(FindCompteByEmployee value) {
        return new JAXBElement<FindCompteByEmployee>(_FindCompteByEmployee_QNAME, FindCompteByEmployee.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCompteByEmployeeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.bankocash.imie.fr/", name = "findCompteByEmployeeResponse")
    public JAXBElement<FindCompteByEmployeeResponse> createFindCompteByEmployeeResponse(FindCompteByEmployeeResponse value) {
        return new JAXBElement<FindCompteByEmployeeResponse>(_FindCompteByEmployeeResponse_QNAME, FindCompteByEmployeeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DebiteCompte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.bankocash.imie.fr/", name = "debiteCompte")
    public JAXBElement<DebiteCompte> createDebiteCompte(DebiteCompte value) {
        return new JAXBElement<DebiteCompte>(_DebiteCompte_QNAME, DebiteCompte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CrediteCompteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.bankocash.imie.fr/", name = "crediteCompteResponse")
    public JAXBElement<CrediteCompteResponse> createCrediteCompteResponse(CrediteCompteResponse value) {
        return new JAXBElement<CrediteCompteResponse>(_CrediteCompteResponse_QNAME, CrediteCompteResponse.class, null, value);
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
