/**
 * 
 */
package fr.imie.formation.websocket;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Florent RICHARD
 *
 */
public class SocketProperties {
    private static final String FILE_PROPERTIES       = "/fr/imie/formation/websocket/socket.properties";
    private static final String PROPERTY_HOSTADDR             = "host_adress";
    private static final String PROPERTY_SERVERTOCUSTOMERPORT = "server_to_client_port";
    private static final String PROPERTY_CUSTOMERTOSERVERPORT = "client_to_server_port";
    private String hostaddress;
    private Integer serverToCustomerPort;
    private Integer customerToServer;
    
    /**
     * @throws Exception 
     * 
     */
    public SocketProperties() throws Exception {
        Properties properties = new Properties();
        InputStream fichierProperties = getClass().getResourceAsStream( FILE_PROPERTIES );
        if ( fichierProperties == null ) {
            throw new Exception( "Le fichier properties " + FILE_PROPERTIES + " est introuvable." );
        }
        try {
            properties.load( fichierProperties );
            hostaddress = properties.getProperty( PROPERTY_HOSTADDR );
            serverToCustomerPort = new Integer(properties.getProperty( PROPERTY_SERVERTOCUSTOMERPORT ));
            customerToServer = new Integer(properties.getProperty( PROPERTY_CUSTOMERTOSERVERPORT ));
        } catch ( IOException e ) {
            throw new Exception( "Impossible de charger le fichier properties " + FILE_PROPERTIES, e );
        }
    }

    /**
     * @return the hostaddress
     */
    public synchronized final String getHostaddress() {
        return hostaddress;
    }

    /**
     * @param hostaddress the hostaddress to set
     */
    public synchronized final void setHostaddress(String hostaddress) {
        this.hostaddress = hostaddress;
    }

    /**
     * @return the serverToCustomerPort
     */
    public synchronized final Integer getServerToCustomerPort() {
        return serverToCustomerPort;
    }

    /**
     * @param serverToCustomerPort the serverToCustomerPort to set
     */
    public synchronized final void setServerToCustomerPort(Integer serverToCustomerPort) {
        this.serverToCustomerPort = serverToCustomerPort;
    }

    /**
     * @return the customerToServer
     */
    public synchronized final Integer getCustomerToServer() {
        return customerToServer;
    }

    /**
     * @param customerToServer the customerToServer to set
     */
    public synchronized final void setCustomerToServer(Integer customerToServer) {
        this.customerToServer = customerToServer;
    }

}
