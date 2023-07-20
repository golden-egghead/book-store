/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tinnt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Properties;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tinnt.registration.RegistrationDAO;
import tinnt.util.MyApplicationConstants;

/**
 *
 * @author Tin
 */
@WebServlet(name = "UpdatePassRoleServlet", urlPatterns = {"/UpdatePassRoleServlet"})
public class UpdatePassRoleServlet extends HttpServlet {
//    private final String UPDATE_ERROR_PAGE = "updateErr.html";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        ServletContext context = this.getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITEMAPS");

//        String urlRewriting = UPDATE_ERROR_PAGE;
        String urlRewriting = siteMaps.getProperty(MyApplicationConstants.SearchFeature.UPDATE_ERROR_PAGE);
        try {
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            String admin = request.getParameter("checkRole");
            boolean role = false;
            if (admin != null) {
                role = true;
            }
            String searchValue = request.getParameter("lastSearchValue");

            RegistrationDAO dao = new RegistrationDAO();
            boolean result = dao.updatePassRole(username, password, role);

            if (result) {
                urlRewriting = "searchController?"
                        + "btAction=Search"
                        + "&txtSearchValue=" + searchValue;
            }

        } catch (NamingException ex) {
            log("Create Account     Naming" + ex.getMessage());
        } catch (SQLException ex) {
            log("Create Account     SQL" + ex.getMessage());
        } finally {
            response.sendRedirect(urlRewriting);
            out.close();
        }
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
