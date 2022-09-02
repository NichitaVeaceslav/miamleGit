/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Event;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stag
 */
public class EventDAO extends DAO<Event> {

    public EventDAO() {
        super("event");
    }

    @Override
    public Event find(Long id) {
        Event event = null;
        String sql = "SELECT * FROM " + table + " WHERE id_event=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery(); // Requête en sélection
            if (rs.first()) { // L'utilisateur a été trouvé dans la DB
                // => hydratation du bean
                event = new Event();
                event.setTitle(rs.getString("title"));
                event.setDate(rs.getDate("date"));
                event.setId(id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return event;
    }

    @Override
    public void update(Event obj) {
        String sql = "UPDATE " + table
                + " SET date=?, title=? WHERE id_event=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setDate(1, obj.getDate());
            pstmt.setString(2, obj.getTitle());
            pstmt.setLong(3, obj.getId());
            int nbLines = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EventDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void create(Event obj) {
        String sql = "INSERT INTO " + table
                + " (date, title) VALUES (?, ?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setDate(1, obj.getDate());
            pstmt.setString(2, obj.getTitle());
            int nbLines = pstmt.executeUpdate();
            System.out.println("création demandée");
            if (nbLines == 1) {
                System.out.println("création réussie");
                ResultSet keys = pstmt.getGeneratedKeys();
                if (keys.first()) {
                    obj.setId(keys.getLong(1));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Event obj) {
        String sql = "DELETE FROM " + table + " WHERE id_event=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, obj.getId());
            int nbLines = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EventDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Event> all() {

        ArrayList<Event> events = new ArrayList<>();

        String sql = "SELECT * FROM " + table;
        try {

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) { // Pour chaque ligne de résultat
                // On crée un nouvel evenement

                Event event = new Event();

                event.setId(rs.getLong("id_event"));
 
                event.setDate(rs.getDate("date"));

                event.setTitle(rs.getString("title"));

                System.out.println(event);
                // On l'ajoute à la liste
                events.add(event);

                System.out.println(events);
            }System.out.println(events);
        } catch (SQLException ex) {
            Logger.getLogger(EventDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return events;
    }

    /**
     * Retourne une collection d'evenements
     *
     * @param quantity le nombre d'evenement à retourner
     * @param offset lenombre d'evenement à ignorer
     * @return les quantity evenement à partir du offset-ième
     */
    public List<Event> getQuantityFrom(int quantity, int offset) {
        ArrayList<Event> events = new ArrayList<>();
        if (quantity > 0) {
            String sql = "SELECT * FROM " + table
                    + " LIMIT " + quantity + " OFFSET " + offset;
            try {
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) { // Pour chaque ligne de résultat
                    // On crée un utilisateur
                    Event event = new Event();
                    event.setId(rs.getLong("id_event"));
                    event.setDate(rs.getDate("date"));
                    event.setTitle(rs.getString("title"));
                    // On l'ajoute à la liste
                    events.add(event);
                }
            } catch (SQLException ex) {
                Logger.getLogger(EventDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return events;
    }

//    public Event getAffiche() {
//         String sql = "SELECT nbConvives, entree, entreeQty, plat, platQty, dessert, dessertQty, boisson, boissonQty, comment\n" +
//"FROM testParticipant\n" +
//"NATURAL JOIN testEvent USING(id_event)\n" +
//"NATURAL JOIN user USING(id_user)\n" +
//
//    }
    /**
     * Retourne les quantity derniers event
     *
     * @param quantity Le nombre d'event à retourner
     * @return la collection des quantity derniers event
     */
    public List<Event> getLastEvent(int quantity) {
        return getQuantityFrom(quantity, 0);
    }

    /**
     * Retourne le dernier Event
     *
     * @return le dernier event
     */
    public Event getLast() {
        List<Event> events = getLastEvent(1);
        if (!events.isEmpty()) {
            return events.get(0);
        } else {
            return null;
        }
    }

}
