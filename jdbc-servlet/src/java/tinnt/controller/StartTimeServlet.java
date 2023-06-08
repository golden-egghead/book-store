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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tinnt.registration.RegistrationDAO;
import tinnt.registration.RegistrationDTO;
import tinnt.util.MyApplicationConstants;

/**
 *
 * @author Tin
 */
@WebServlet(name = "StartTimeServlet", urlPatterns = {"/StartTimeServlet"})
public class StartTimeServlet extends HttpServlet {
//    private final String LOGIN_PAGE = "login.html";
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

        ServletContext context = this.getServletContext();
        Properties siteMaps = (Properties) context.getAttribute("SITEMAPS");

        Cookie[] cookies = null;
//        String url = LOGIN_PAGE;
        String url = siteMaps.getProperty(MyApplicationConstants.DispatchFeature.LOGIN_PAGE);
        try {
            cookies = request.getCookies();

            if (cookies != null) {
                //2. Get last cookies
                Cookie lastcookies = cookies[cookies.length - 1];
                String username = lastcookies.getName();
                String password = lastcookies.getValue();
                // 3. Call Model
                RegistrationDAO dao = new RegistrationDAO();
                RegistrationDTO result = dao.checkLogin(username, password);
                // 3'. Call login feature by using url reWriting
//                url = "DispatcherServlet"
//                        + "?btAction=Login"
//                        + "&txtUsername=" +username;
//                        + "&txtPasword" + password;
                if (result != null) {
//                    url = SEARCH_PAGE;
                    url = siteMaps.getProperty(MyApplicationConstants.LoginFeature.SEARCH_PAGE);
                }
            }//end cookies had existed
        } catch (SQLException ex) {
            log("Create Account     SQL" + ex.getMessage());
        } catch (NamingException ex) {
            log("Create Account     Naming" + ex.getMessage());
        } finally {
            //can use RequestDispatcher.forward
            response.sendRedirect(url);
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
