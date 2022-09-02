/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import dao.Identifiable;
import java.io.Serializable;

/**
 *
 * @author stag
 */
public class Dish implements Serializable, Identifiable {

    private static final long serialVersionUID = 2L;

    private Long id;
    private Long id_guest;
    private String entree;
    private String plat;
    private String dessert;
    private String boisson;
    private int nb_entrée;
    private int nb_plat;
    private int nb_dessert;
    private int nb_boisson;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlat() {
        return plat;
    }

    public void setPlat(String plat) {
        this.plat = plat;
    }

    public String getDessert() {
        return dessert;
    }

    public void setDessert(String dessert) {
        this.dessert = dessert;
    }

    public String getBoisson() {
        return boisson;
    }

    public void setBoisson(String boisson) {
        this.boisson = boisson;
    }

    public int getNb_entrée() {
        return nb_entrée;
    }

    public void setNb_entrée(int nb_entrée) {
        this.nb_entrée = nb_entrée;
    }

    public int getNb_plat() {
        return nb_plat;
    }

    public void setNb_plat(int nb_plat) {
        this.nb_plat = nb_plat;
    }

    public int getNb_dessert() {
        return nb_dessert;
    }

    public void setNb_dessert(int nb_dessert) {
        this.nb_dessert = nb_dessert;
    }

    public int getNb_boisson() {
        return nb_boisson;
    }

    public void setNb_boisson(int nb_boisson) {
        this.nb_boisson = nb_boisson;
    }

    public String getEntree() {
        return entree;
    }

    public void setEntree(String entree) {
        this.entree = entree;
    }

    public Long getId_guest() {
        return id_guest;
    }

    public void setId_guest(Long id_guest) {
        this.id_guest = id_guest;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dish{id=").append(id);
        sb.append(", id_guest=").append(id_guest);
        sb.append(", entree=").append(entree);
        sb.append(", plat=").append(plat);
        sb.append(", dessert=").append(dessert);
        sb.append(", boisson=").append(boisson);
        sb.append(", nb_entr\u00e9e=").append(nb_entrée);
        sb.append(", nb_plat=").append(nb_plat);
        sb.append(", nb_dessert=").append(nb_dessert);
        sb.append(", nb_boisson=").append(nb_boisson);
        sb.append('}');
        return sb.toString();
    }

}
