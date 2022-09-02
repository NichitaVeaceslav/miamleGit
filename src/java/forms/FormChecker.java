package forms;

import beans.User;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

/**
 * Classe mère de vérification des formulaires.
 *
 * @author Herbert Caffarel
 */
public abstract class FormChecker {

    protected HttpServletRequest request;
    protected HashMap<String, String> errors;

    public FormChecker(HttpServletRequest request) {
        this.request = request;
        errors = new HashMap<>();
    }

    /**
     * Vérification du formulaire.
     */
    protected abstract User check();

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

    /**
     * Vérifie si un champ correspond à une adresse courriel.
     *
     * @param field
     * @throws Exception
     */
    protected void isEmail(String field) throws Exception {
        if (!field.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
            throw new Exception("Merci de saisir une adresse courriel valide.");
        }
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

}
