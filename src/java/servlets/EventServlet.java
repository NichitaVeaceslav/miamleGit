/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.DAOFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author stag
 */
@WebServlet(name = "EventServlet", urlPatterns = {"/event"})
public class EventServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        //récuperer la session puis recuperer le membre de la session ?
//        HttpSession session = request.getSession();
//        System.out.println(session.getId());
//        //verifier si elle est null ou non et rediriger le get en fonction
//
//        if (session. == null) {
//            response.sendRedirect(request.getServletContext()
//                    .getContextPath() + "/");
//
//        } else {
           System.out.println("doget liste event A");
        request.setAttribute("events", DAOFactory.getEventDAO().all());
        System.out.println("doget liste event Z");
            getServletContext()
                    .getRequestDispatcher("/WEB-INF/event.jsp")
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
        // update et création de particiant
        getServletContext()
                .getRequestDispatcher("/WEB-INF/event.jsp")
                .forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Event cSontroller";
    }// </editor-fold>

}
