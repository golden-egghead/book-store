/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tinnt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tinnt.registration.RegistrationDAO;
import tinnt.registration.RegistrationDTO;
import tinnt.util.DBHelper;
import tinnt.util.MyApplicationConstants;

/**
 *
 * @author Tin
 */
public class LoginServlet extends HttpServlet {

//    private final String INVALID_PAGE = "invalid.html";
//    private final String SEARCH_PAGE = "search.html";
//    private final String SEARCH_PAGE = "search.jsp";

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
        Properties siteMaps = (Properties)context.getAttribute("SITEMAPS");
        
        String url = siteMaps.getProperty(MyApplicationConstants.LoginFeature.INVALID_PAGE);
        
//        String url = MyApplicationConstants.LoginFeature.INVALID_PAGE;
        
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");

        try {
            //3. Call Model DAO
            //3.1 New Object
            RegistrationDAO dao = new RegistrationDAO();
            //3.2 call its method
            RegistrationDTO result = dao.checkLogin(username, password);

            if (result != null) {
                url = siteMaps.getProperty(MyApplicationConstants.LoginFeature.SEARCH_PAGE);
//                url = MyApplicationConstants.SearchFeature.SEARCH_CONTROLLER;
                
                HttpSession session = request.getSession(true);
                session.setAttribute("USER", result);
//                Cookie cookie = new Cookie(username, password);
//                cookie.setMaxAge(60*3);
//                response.addCookie(cookie);                
            }
            
        } catch (NamingException ex) {
            log("Create Account     Naming" + ex.getMessage());
        } catch (SQLException ex) {
            log("Create Account     SQL" + ex.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
//            response.sendRedirect(url);
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
