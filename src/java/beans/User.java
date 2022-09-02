package beans;

import dao.Identifiable;
import java.io.Serializable;

/**
 *
 * @author stag
 */
public class User implements Serializable, Identifiable {

    private static final long serialVersionUID = 2L;

    private Long id;
    private String email;
    private String pwd;
    private String pseudo;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User{id=").append(id);
        sb.append(", email=").append(email);
        sb.append(", pwd=").append(pwd);
        sb.append(", pseudo=").append(pseudo);
        sb.append('}');
        return sb.toString();
    }
//    // On sort du modèle de bean en ajoutant une méthode me fournissant le bean
//    // User qui est l'auteur. Vu qu'on connait son Id, il est simple de
//    // fournir le bean complet, donc je crée un getter pour ça. Ainsi, dans la
//    // vue de l'accueil par exemple, il sera plus simple d'afficher le nom de
//    // l'auteur plutôt que son id

}
