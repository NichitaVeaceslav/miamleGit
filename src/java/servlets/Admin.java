/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.Event;
import dao.DAOFactory;
import forms.EventFormChecker;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author stag
 */
@WebServlet(name = "Admin", urlPatterns = {"/admin"})
public class Admin extends HttpServlet {

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
//        HttpSession session = request.getSession(true);
//        int id_user = (int)session.getAttribute("id_user");
//        if
//        request.getSession().setAttribute("user", user);
//        System.out.println(System.currentTimeMillis());
//  System.out.println(new java.util.Date().getTime());
        request.setAttribute("events", DAOFactory.getEventDAO().all());
        getServletContext()
                .getRequestDispatcher("/WEB-INF/admin.jsp")
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
        EventFormChecker check = new EventFormChecker(request);
        Event event = check.checker();

        if (check.getErrors().isEmpty()) {

            // La création est valide
//            request.setAttribute("event", event);
            // et nouvel evenement en DB !
            DAOFactory.getEventDAO().create(event);

        } else {
            getServletContext()
                    .getRequestDispatcher("/WEB-INF/admin.jsp")
                    .forward(request, response);
        }
        getServletContext()
                .getRequestDispatcher("/WEB-INF/admin.jsp")
                .forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Admin controller";
    }// </editor-fold>

}
