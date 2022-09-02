/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import beans.Event;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author stag
 */
public abstract class EventChecker {

    protected HttpServletRequest request;
    protected HashMap<String, String> errors;

    public EventChecker(HttpServletRequest request) {
        this.request = request;
        errors = new HashMap<>();
    }

    protected abstract Event checker();

    /*
     * Les différentes méthodes de vérifications de bases.
    Toutes ces méthodes vont retourner un booléen.
     */
    /**
     * Vérifie si un champ obligatoire est bien rempli.
     *
     * @param field
     * @throws java.lang.Exception si le champ est vide ou constitué d'espaces
     */
    protected void mandatoryField(String field) throws Exception {
        if (field.strip().length() == 0) {
            throw new Exception("Champ obligatoire");
        }
    }

    /**
     * Vérifie si un champ a la longueur minimale requise.
     *
     * @param field
     * @param minLength
     * @throws Exception
     */
    protected void minFieldLength(String field, int minLength) throws Exception {
        if (field.strip().length() < minLength) {
            throw new Exception("Longueur minimale requise : " + minLength + " caractères.");
        }
    }

    /**
     * Vérifie si un champ a la longueur maximale requise.
     *
     * @param field
     * @param maxLength
     * @throws Exception
     */
    protected void maxFieldLength(String field, int maxLength) throws Exception {
        if (field.strip().length() > maxLength) {
            throw new Exception("Longueur maximale admise : " + maxLength + " caractères.");
        }
    }

//        protected void isDate(Date date) throws Exception {
//        if (!date.toString().matches("/^(0[1-9]|[12][0-9]|3[01])- (0[1-9]|1[012])- (19|20)dd$/;")) {
//            throw new Exception("Merci de saisir une date valide.");
//        }
//    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

}
