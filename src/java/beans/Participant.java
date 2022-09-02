/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.DAOFactory;
import dao.Identifiable;
import java.io.Serializable;

/**
 *
 * @author stag
 */
public class Participant implements Serializable, Identifiable {

    private static final long serialVersionUID = 2L;

    private Long id;
    private Long id_event;
    private Long id_user;
//    private String pseudo;
    private int nbPersons;
    private int nbPlat;
    private int nbEntree;
    private int nbDessert;
    private int nbBoisson;
    private String comment;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_event() {
        return id_event;
    }

    public void setId_event(Long id_event) {
        this.id_event = id_event;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public int getNbPersons() {
        return nbPersons;
    }

    public void setNbPersons(int nbPersons) {
        this.nbPersons = nbPersons;
    }

    public int getNbPlat() {
        return nbPlat;
    }

    public void setNbPlat(int nbPlat) {
        this.nbPlat = nbPlat;
    }

    public int getNbEntree() {
        return nbEntree;
    }

    public void setNbEntree(int nbEntree) {
        this.nbEntree = nbEntree;
    }

    public int getNbDessert() {
        return nbDessert;
    }

    public void setNbDessert(int nbDessert) {
        this.nbDessert = nbDessert;
    }

    public int getNbBoisson() {
        return nbBoisson;
    }

    public void setNbBoisson(int nbBoisson) {
        this.nbBoisson = nbBoisson;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Participant{id=").append(id);
        sb.append(", id_event=").append(id_event);
        sb.append(", id_user=").append(id_user);
        sb.append(", nbPersons=").append(nbPersons);
        sb.append(", nbPlat=").append(nbPlat);
        sb.append(", nbEntree=").append(nbEntree);
        sb.append(", nbDessert=").append(nbDessert);
        sb.append(", nbBoisson=").append(nbBoisson);
        sb.append(", comment=").append(comment);
        sb.append('}');
        return sb.toString();
    }

    public User getUser() {
        return DAOFactory.getUserDAO().find(id_user);
    }

    public Event getEvent() {
        return DAOFactory.getEventDAO().find(id_event);
    }

}
