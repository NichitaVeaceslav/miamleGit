package forms;

import beans.User;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nichita Veaceslav
 */
public class ProfileFormChecker extends FormChecker {

    private final int MIN_PWD_SIZE = 3;
    private final int MAX_PWD_SIZE = 24;

    public ProfileFormChecker(HttpServletRequest request) {
        super(request);
    }

    @Override
    public User check() {
        //Récupérer la session
        User user = new User();
        HttpSession session = request.getSession();

        user = (User) session.getAttribute("user");
        String pwdUser = user.getPwd();

        // Le message peut être soit une réussite, soit un échec. Il faut
        // donc indiquer cette information avec le message => c'est une Map
        Map<String, String> msgMap = new HashMap<>();

        // Les paramètres de la requête
        String pwd = request.getParameter("pwd");
        String newPWD = request.getParameter("newPWD");
        String confirm = request.getParameter("confirm");

//
        request.setAttribute("user", user);

        // Les tests
        try {
            mandatoryField(pwd);
            minFieldLength(pwd, MIN_PWD_SIZE);
            maxFieldLength(pwd, MAX_PWD_SIZE);
            //nous vérifions si le mot de passe saisi est le même avec pwd dans BDD)
            sameField(pwdUser, pwd);

        } catch (Exception ex) {
            errors.put("pwd", ex.getMessage());
        }

        try {
            mandatoryField(newPWD);
            minFieldLength(newPWD, MIN_PWD_SIZE);
            maxFieldLength(newPWD, MAX_PWD_SIZE);
        } catch (Exception ex) {
            errors.put("newPWD", ex.getMessage());
        }

        try {
            mandatoryField(confirm);
            sameField(newPWD, confirm);
        } catch (Exception ex) {
            errors.put("confirm", ex.getMessage());
        }

        // Ajouter la collection d'erreurs à la requête
        request.setAttribute("errors", errors);

        // Établissement du message d'erreur
        if (errors.isEmpty()) {
            msgMap.put("valid", "Bravo " + user.getPseudo() + ". Votre Mot de passe a été change.");
            user.setPwd(newPWD);
        } else {
            msgMap.put("error", "Votre formulaire comporte des erreurs");
        }

        // Ajout du dictionnaire de messages à la requête
        request.setAttribute("profileMessage", msgMap);

        // Enfin on n'oublie pas de retourner l'utilisateur !
        return user;

    }

    private void sameField(String one, String two) throws Exception {
        if (!one.strip().equals(two.strip())) {
            throw new Exception("Mots de passe ne sont pas identiques.");
        }
    }
}
