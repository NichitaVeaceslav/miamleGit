package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * Établissement d'une connexion avec la DB selon le pattern Singleton.
 *
 * @author Herbert Caffarel
 */
public final class MariaDBConnection {

    private static Connection connection = null;

    private MariaDBConnection() {
    }

    /**
     * Retourne une connexion à la DB de façon lazy.
     *
     * @return la connexion
     * @throws RuntimeException si la connexion échoue
     */
    public static Connection getConnection() throws RuntimeException {
        if (connection == null) {
            // faire un fichier de configuration 
            String login = "user";
            String password = "user";
            String host = "localhost";
            String database = "miamle";
            int port = 3306;
            
            String driver = "mysql";
            // Version produite : jdbc:mysql://localhost:3306/blog
            String url = "jdbc:" + driver + "://" + host + ":"
                    + port + "/" + database;
            // Premier appel : on doit construire la connexion
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                connection = DriverManager.getConnection(url, login, password);
            } catch (SQLException ex) {
                throw new RuntimeException("Connexion à la base de données impossible");
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException("Driver " + driver + " inconnu.");
            }
        }
        return connection;
    }
}
//////////////////////////Penser à faire le fichier de configuration//////////
