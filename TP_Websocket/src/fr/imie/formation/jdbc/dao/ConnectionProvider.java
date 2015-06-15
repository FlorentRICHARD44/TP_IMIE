package fr.imie.formation.jdbc.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/** Singleton used to provide connection to database.
 * @author Florent RICHARD
 */
public final class ConnectionProvider {
    /** Instance for singleton.
     */
    private static ConnectionProvider instance;
    /** Properties: file path.
     */
    private static final String FILE_PROPERTIES       = "/fr/imie/formation/jdbc/database.properties";
    /** Properties: url of database.
     */
    private static final String PROPERTY_URL             = "url";
    /** Properties: user name to access to databse.
     */
    private static final String PROPERTY_USERNAME = "username";
    /** Properties: password for user.
     */
    private static final String PROPERTY_PASSWORD    = "password";

    /** Constructor;
     * Private because in Singleton.
     */
    private ConnectionProvider() {
    }

    /** Returns the instance of this singleton.
     * @return instance of this singleton.
     */
    public static synchronized ConnectionProvider getInstance() {
        if (instance == null) {
            instance = new ConnectionProvider();
        }
        return instance;
    }

    /** Returns the connection to Database.
     * @return Connection to database.
     * @throws SQLException Case of error during connection.
     */
    public Connection getConnection() throws SQLException, DAOConfigurationException, IOException {
        Connection connection = null;
        Properties properties = new Properties();
        String url;
        String username;
        String password;
        InputStream fichierProperties = getClass().getResourceAsStream( FILE_PROPERTIES );
        if ( fichierProperties == null ) {
            throw new DAOConfigurationException( "Le fichier properties " + FILE_PROPERTIES + " est introuvable." );
        }
        try {
            properties.load( fichierProperties );
            url = properties.getProperty( PROPERTY_URL );
            username = properties.getProperty( PROPERTY_USERNAME );
            password = properties.getProperty( PROPERTY_PASSWORD );
        } catch ( IOException e ) {
            throw new DAOConfigurationException( "Impossible de charger le fichier properties " + FILE_PROPERTIES, e );
        }

        synchronized (DriverManager.class) {
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }
}
