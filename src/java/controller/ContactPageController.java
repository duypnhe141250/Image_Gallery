
package controller;

import dao.ContactDAO;
import dao.impl.ContactDAOImpl;
import dao.impl.GaleryDAOImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.GalleryDAO;

/**
 * This class uses to handle request and send response to Contact Page
 *
 * @author Nguyễn Xuân Hùng
 */
public class ContactPageController extends HttpServlet {

   /**
     * This method used to set all attribute to display data in Contact page by
     * get data from database throw DAO interface
     *
     * @param request It is a <code>HttpServletRequest</code> object
     * @param response It is a <code>HttpServletResponse</code> object
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            ContactDAO contactDAO = new ContactDAOImpl();
            GalleryDAO galleryDAO = new GaleryDAOImpl();
            //get top 3 galery
            request.setAttribute("top3", galleryDAO.getTop3Galery(3));
            //get contact infor
            request.setAttribute("contact", contactDAO.getContact());

            request.setAttribute("active", "4");
            request.getRequestDispatcher("Contact.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", ex);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
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
