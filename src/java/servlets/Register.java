package servlets;

import dao.DAOFactory;
import forms.RegisterFormChecker;
import beans.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Herbert Caffarel
 */
@WebServlet(name = "Register", urlPatterns = {"/register"})
public class Register extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher("/WEB-INF/register.jsp")
                .forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        RegisterFormChecker checker = new RegisterFormChecker(request);
        User user = checker.check();

        // voir si le checker n'a pas d'erreur
        if (checker.getErrors().isEmpty()) {
            // L'inscription est valide => utilisateur en session
            request.getSession().setAttribute("user", user);
            // et utilisateur en DB !
            DAOFactory.getUserDAO().create(user);
        } else {
            request.getSession().invalidate();
//            response.sendRedirect(request.getServletContext().getContextPath() + "/");

        }
        getServletContext()
                .getRequestDispatcher("/WEB-INF/register.jsp")
                .forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Register controller";
    }

}
