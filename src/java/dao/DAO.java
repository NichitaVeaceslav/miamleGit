package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Herbert Caffarel
 * @param <T> bean implémentant l'interface Identifiable pour avoir la méthode
 * getId()
 */
public abstract class DAO<T extends Identifiable> {

    Connection connection;
    protected String table;

    public DAO(String table) {
        this.connection = MariaDBConnection.getConnection();
        this.table = table;
    }

    /**
     * Retourne l'utilisateur ayant l'identifiant id dans la DB ou null si non
     * trouvé.
     *
     * @param id identifiant de l'utilisateur en DB
     * @return une instance de User ou null
     */
    public abstract T find(Long id);

    /**
     * Supprime l'objet dans la table guest.
     *
     * @param obj
     */
    public abstract void delete(T obj);


    /**
     * Met à jour l'objet en DB
     *
     * @param obj
     */
    public abstract void update(T obj);

    /**
     * Crée l'utilisateur en DB et récupère son identifiant.
     *
     * @param obj
     */
    public abstract void create(T obj);

    /**
     * Retourne le nombre de ligne de la table.
     *
     * @return le nombre de ligne de la table
     */
    public int count() {
        String sql = "SELECT COUNT(*) FROM " + table;
        int count = 0;
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.first()) {
                count = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    /**
     * Retourne la collection de toutes les lignes de la table.
     *
     * @return
     */
    public abstract List<T> all();
}
