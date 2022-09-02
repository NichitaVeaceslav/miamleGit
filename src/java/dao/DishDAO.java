/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Dish;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stag
 */
public class DishDAO extends DAO<Dish> {

    public DishDAO() {
        super("dish");
    }

    @Override
    public Dish find(Long id) {
        Dish dish = null;
        String sql = "SELECT * FROM " + table + " WHERE id=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery(); // Requête en sélection
            if (rs.first()) { // L'utilisateur a été trouvé dans la DB
                // => hydratation du bean
                dish = new Dish();
                dish.setId_guest(id);
                dish.setBoisson(rs.getString("id_guest"));
                dish.setEntree(rs.getString("entree"));
                dish.setPlat(rs.getString("plat"));
                dish.setDessert(rs.getString("dessert"));
                dish.setNb_boisson(rs.getInt("nb_boisson"));
                dish.setNb_entrée(rs.getInt("nb_entree"));
                dish.setNb_plat(rs.getInt("nb_plat"));
                dish.setNb_dessert(rs.getInt("nb_dessert"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DishDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dish;
    }

    @Override
    public void update(Dish obj) {
        String sql = "UPDATE " + table
                + " SET boisson=?, entree=?, plat=?, dessert=?, nb_boisson=?, nb_entree=?, nb_plat=?, nb_dessert=?, id_guest= ? WHERE id=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, obj.getBoisson());
            pstmt.setString(2, obj.getEntree());
            pstmt.setString(3, obj.getPlat());
            pstmt.setString(4, obj.getDessert());
            pstmt.setInt(5, obj.getNb_boisson());
            pstmt.setInt(6, obj.getNb_entrée());
            pstmt.setInt(7, obj.getNb_plat());
            pstmt.setInt(8, obj.getNb_dessert());
            pstmt.setLong(9, obj.getId_guest());
            pstmt.setLong(10, obj.getId());
            int nbLines = pstmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DishDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void create(Dish obj) {
        String sql = "INSERT INTO " + table
                + " (boisson, entree, plat, dessert, nb_boisson, nb_entree, nb_plat, nb_dessert, id_guest) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, obj.getBoisson());
            pstmt.setString(2, obj.getEntree());
            pstmt.setString(3, obj.getPlat());
            pstmt.setString(4, obj.getDessert());
            pstmt.setInt(5, obj.getNb_boisson());
            pstmt.setInt(6, obj.getNb_entrée());
            pstmt.setInt(7, obj.getNb_plat());
            pstmt.setInt(8, obj.getNb_dessert());
            pstmt.setLong(9, obj.getId_guest());
            int nbLines = pstmt.executeUpdate();
            if (nbLines == 1) {
                ResultSet keys = pstmt.getGeneratedKeys();
                if (keys.first()) {
                    obj.setId(keys.getLong(1));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DishDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Dish> all() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Dish obj) {
        String sql = "DELETE FROM " + table + " WHERE id=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, obj.getId());
            int nbLines = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DishDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
