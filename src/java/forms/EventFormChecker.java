/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import beans.Event;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author stag
 */
public class EventFormChecker extends EventChecker {

    private final int MIN_PWD_SIZE = 3;
    private final int MAX_PWD_SIZE = 24;

    public EventFormChecker(HttpServletRequest request) {
        super(request);
    }

    @Override
    public Event checker() {
        // Le message peut être soit une réussite, soit un échec. Il faut
        // donc indiquer cette information avec le message => c'est une Map
        Map<String, String> msgMap = new HashMap<>();
        // Les paramètres de la requête
        Date date = Date.valueOf(request.getParameter("date"));
        String title = request.getParameter("title");
        System.out.println(request.getParameter("title"));
        // Le bean hydraté par les données du formulaire pour le réaffichage
        // desdites données dans le formulaire, donc à mettre en attribut de
        // requête
        Event event = new Event();
        event.setDate(date);
        System.out.println(request.getParameter("date"));
        event.setTitle(title);
        System.out.println(request.getParameter("title"));

        request.setAttribute("event", event);

        // Les tests
        try {

            mandatoryField(title);

            minFieldLength(title, MIN_PWD_SIZE);
            maxFieldLength(title, MAX_PWD_SIZE);

        } catch (Exception ex) {

            errors.put("title", ex.getMessage());
        }

        try {

            if (title.trim().length() != 0) {
                minFieldLength(title, 3);

            }
        } catch (Exception ex) {
            errors.put("title", ex.getMessage());
            System.out.println("phase test créa P");
        }

//            isDate(date);
//        } catch (Exception ex) {
//            errors.put("date", ex.getMessage());
//        }
        // Ajouter la collection d'erreurs à la requête
        request.setAttribute("errors", errors);

        // Établissement du message d'erreur
        if (errors.isEmpty()) {

            msgMap.put("valid", "Création de " + request.getParameter("title") + ". Votre evenement à bien été créer.");
        } else {

            msgMap.put("error", "Votre formulaire comporte des erreurs");
        }

        // Ajout du dictionnaire de messages à la requête
        request.setAttribute("eventMessage", msgMap);

        // Retour de l'event
        return event;
    }

}
