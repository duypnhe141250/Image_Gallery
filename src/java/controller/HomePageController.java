
package controller;

import dao.ContactDAO;
import dao.impl.ContactDAOImpl;
import dao.impl.GaleryDAOImpl;
import entity.Gallery;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.GalleryDAO;


public class HomePageController extends HttpServlet {

    /**
     * This method used to set all attribute to display data in Gallery page by
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
            //Set page size by 3
            int pageSize = 3;
            String pageIndex = request.getParameter("index");
            int index = 0;
            //check index page
            if (pageIndex != null) {
                try {
                    index = Integer.parseInt(pageIndex);
                } catch (NumberFormatException e) {
                    request.setAttribute("error", "This page is invalid!!");
                    request.getRequestDispatcher("Error.jsp").forward(request, response);
                }
            } else {
                index = 1;
            }
            //count total result 
            GalleryDAO galleryDAO = new GaleryDAOImpl();
            //phan trang
            int totalRecord = galleryDAO.count();
            if (totalRecord <= 0) {
                request.setAttribute("error", "No result!!");
                request.getRequestDispatcher("Error.jsp").forward(request, response);
            }
            int maxPage = totalRecord / pageSize;
            if ((totalRecord % pageSize) != 0) {
                maxPage++;
            }
            //get list galery with paging 
            List<Gallery> galleryList = galleryDAO.getListGaleryWithPaging(index, pageSize);
            request.setAttribute("listGalery", galleryList);
            request.setAttribute("index", index);
            request.setAttribute("maxPage", maxPage);
            request.setAttribute("totalRecord", totalRecord);

            //get top 3 galery
            request.setAttribute("top3", galleryDAO.getTop3Galery(3));

            //get contact infor
            ContactDAO contactDAO = new ContactDAOImpl();
            request.setAttribute("contact", contactDAO.getContact());

            //Set active and forward to Home Page
            request.setAttribute("active", "0");
            request.getRequestDispatcher("HomePage.jsp").forward(request, response);
        } catch (Exception ex) {
            //If had an error, send to Error Page
            request.setAttribute("error", ex.getMessage());
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
