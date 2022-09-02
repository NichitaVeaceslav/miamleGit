package forms;

import beans.User;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Herbert Caffarel
 */
public class RegisterFormChecker extends FormChecker {

    private final int MIN_PWD_SIZE = 3;
    private final int MAX_PWD_SIZE = 24;

    public RegisterFormChecker(HttpServletRequest request) {
        super(request);
    }

    @Override
    public User check() {
        // Le message peut être soit une réussite, soit un échec. Il faut
        // donc indiquer cette information avec le message => c'est une Map
        Map<String, String> msgMap = new HashMap<>();

        // Les paramètres de la requête
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        String confirm = request.getParameter("confirm");
        String pseudo = request.getParameter("pseudo");

        // Le bean hydraté par les données du formulaire pour le réaffichage
        // desdites données dans le formulaire, donc à mettre en attribut de
        // requête
        User user = new User();
        user.setEmail(email);
        user.setPseudo(pseudo);
        user.setPwd(pwd);
        request.setAttribute("user", user);

        // Les tests
        try {
            mandatoryField(email);
            isEmail(email);
        } catch (Exception ex) {
            errors.put("email", ex.getMessage());
        }
        try {
            mandatoryField(pwd);
            minFieldLength(pwd, MIN_PWD_SIZE);
            maxFieldLength(pwd, MAX_PWD_SIZE);
        } catch (Exception ex) {
            errors.put("pwd", ex.getMessage());
        }
        try {
            mandatoryField(confirm);
            sameField(pwd, confirm);
        } catch (Exception ex) {
            errors.put("confirm", ex.getMessage());
        }
        try {
            if (pseudo.trim().length() != 0) {
                minFieldLength(pseudo, 3);
            }
        } catch (Exception ex) {
            errors.put("pseudo", ex.getMessage());
        }

        // Ajouter la collection d'erreurs à la requête
        request.setAttribute("errors", errors);

        // Établissement du message d'erreur
        if (errors.isEmpty()) {
            msgMap.put("valid", "Bienvenue " + request.getParameter("pseudo") + ". Votre inscription a été acceptée, vous êtes maintenant connecté.");
        } else {
            msgMap.put("error", "Votre formulaire comporte des erreurs");
        }

        // Ajout du dictionnaire de messages à la requête
        request.setAttribute("registerMessage", msgMap);

        // Enfin on n'oublie pas de retourner l'utilisateur !
        return user;
    }

    private void sameField(String one, String two) throws Exception {
        if (!one.strip().equals(two.strip())) {
            throw new Exception("Mot de passe et confirmation ne sont pas identiques.");
        }
    }
}
