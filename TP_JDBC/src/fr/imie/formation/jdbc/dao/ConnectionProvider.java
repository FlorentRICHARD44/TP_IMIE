package fr.imie.formation.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** Singleton used to provide connection to database.
 * @author Florent RICHARD
 */
public final class ConnectionProvider {
    /** Instance for singleton.
     */
    private static ConnectionProvider instance;

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
    public Connection getConnection() throws SQLException {
        Connection connection = null;
        synchronized (DriverManager.class) {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/jdbc_TP_usager",
                    "postgres", "postgres");
        }
        return connection;
    }
}
