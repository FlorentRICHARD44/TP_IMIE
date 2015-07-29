
package fr.imie.bankocash.soap;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "BankocashSoapServiceService", targetNamespace = "http://soap.bankocash.imie.fr/", wsdlLocation = "file:/home/imie/DEV/GIT/TP_IMIE/TP_CommunicationComposants/bankocash/src/BankocashSoapService.xml")
public class BankocashSoapServiceService
    extends Service
{

    private final static URL BANKOCASHSOAPSERVICESERVICE_WSDL_LOCATION;
    private final static WebServiceException BANKOCASHSOAPSERVICESERVICE_EXCEPTION;
    private final static QName BANKOCASHSOAPSERVICESERVICE_QNAME = new QName("http://soap.bankocash.imie.fr/", "BankocashSoapServiceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/bankocash/BankocashSoapService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        BANKOCASHSOAPSERVICESERVICE_WSDL_LOCATION = url;
        BANKOCASHSOAPSERVICESERVICE_EXCEPTION = e;
    }

    public BankocashSoapServiceService() {
        super(__getWsdlLocation(), BANKOCASHSOAPSERVICESERVICE_QNAME);
    }

    public BankocashSoapServiceService(WebServiceFeature... features) {
        super(__getWsdlLocation(), BANKOCASHSOAPSERVICESERVICE_QNAME, features);
    }

    public BankocashSoapServiceService(URL wsdlLocation) {
        super(wsdlLocation, BANKOCASHSOAPSERVICESERVICE_QNAME);
    }

    public BankocashSoapServiceService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, BANKOCASHSOAPSERVICESERVICE_QNAME, features);
    }

    public BankocashSoapServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BankocashSoapServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns BankocashSoapService
     */
    @WebEndpoint(name = "BankocashSoapServicePort")
    public BankocashSoapService getBankocashSoapServicePort() {
        return super.getPort(new QName("http://soap.bankocash.imie.fr/", "BankocashSoapServicePort"), BankocashSoapService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BankocashSoapService
     */
    @WebEndpoint(name = "BankocashSoapServicePort")
    public BankocashSoapService getBankocashSoapServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://soap.bankocash.imie.fr/", "BankocashSoapServicePort"), BankocashSoapService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (BANKOCASHSOAPSERVICESERVICE_EXCEPTION!= null) {
            throw BANKOCASHSOAPSERVICESERVICE_EXCEPTION;
        }
        return BANKOCASHSOAPSERVICESERVICE_WSDL_LOCATION;
    }

}
