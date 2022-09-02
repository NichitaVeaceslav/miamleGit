/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Participant;
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
public class ParticipantDAO extends DAO<Participant> {

    public ParticipantDAO() {
        super("participant");
    }

    @Override
    public Participant find(Long id) {
        Participant participant = null;
        String sql = "SELECT * FROM " + table + " WHERE id_participant=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery(); // Requête en sélection
            if (rs.first()) { // L'utilisateur a été trouvé dans la DB
                // => hydratation du bean
                participant = new Participant();
                participant.setId_event(rs.getLong("id_event"));
                participant.setId_user(rs.getLong("id_user"));
                participant.setNbPersons(rs.getInt("nbPersons"));
                participant.setNbPlat(rs.getInt("nbPlat"));
                participant.setNbEntree(rs.getInt("nbEntree"));
                participant.setNbDessert(rs.getInt("nbDessert"));
                participant.setNbBoisson(rs.getInt("nbBoisson"));
                participant.setComment(rs.getString("comment"));

                participant.setId(id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ParticipantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return participant;
    }

    @Override
    public void create(Participant obj) {
        String sql = "INSERT INTO " + table + " (id_user, id_event, nbPlat, nbEntree, nbDessert, nbBoisson, nbPersons, comment) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            pstmt.setLong(1, obj.getId_user());
            pstmt.setLong(2, obj.getId_event());
            pstmt.setInt(3, obj.getNbPlat());
            pstmt.setInt(4, obj.getNbEntree());
            pstmt.setInt(5, obj.getNbDessert());
            pstmt.setInt(6, obj.getNbBoisson());
            pstmt.setInt(7, obj.getNbPersons());
            pstmt.setString(8, obj.getComment());
            int nbLines = pstmt.executeUpdate();
            if (nbLines == 1) {
                ResultSet keys = pstmt.getGeneratedKeys();
                if (keys.first()) {
                    obj.setId(keys.getLong(1));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ParticipantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Participant obj) {
        String sql = "UPDATE " + table + " SET id_user=?, id_event=?, nbPlat=?,"
                + "nbEntree=?, nbDessert=?, nbBoisson=?, nbPersons=?, comment=? WHERE id_participant=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setLong(1, obj.getId_user());
            pstmt.setLong(2, obj.getId_event());
            pstmt.setInt(3, obj.getNbPlat());
            pstmt.setInt(4, obj.getNbEntree());
            pstmt.setInt(5, obj.getNbDessert());
            pstmt.setInt(6, obj.getNbBoisson());
            pstmt.setInt(7, obj.getNbPersons());
            pstmt.setString(8, obj.getComment());
            pstmt.setLong(9, obj.getId());

            int nbLines = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ParticipantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Participant obj) {
        String sql = "DELETE FROM " + table + " WHERE id_participant=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, obj.getId());
            int nbLines = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ParticipantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    @Override
//    public List<Participant> all() {
//        ArrayList<Participant> participants = new ArrayList<>();
//        String sql = "SELECT * FROM " + table;
//        try {
//            Statement stmt = connection.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()) { // Pour chaque ligne de résultat
//                // On crée un utilisateur
//                Participant user = new Participant();
//                user.set(rs.getString("email"));
//                user.setId_event(rs.getLong("id_event"));
//                user.setCommentaire(rs.getString("comment"));
//                user.setNb_participant(rs.getInt("nbPersons"));
//                user.setPseudo(rs.getString("name"));
//                user.setPwd(rs.getString("pwd"));
//                user.setId(rs.getLong("id"));
//                // On l'ajoute à la liste
//                users.add(user);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return users;
//    }
    @Override
    public List<Participant> all() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
