
package listener;

import dao.impl.ViewNumberDAOImpl;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import dao.ViewNumberDAO;


public class ViewsNumberListener implements HttpSessionListener {

   /**
     * This method used to get Views Number from database and display in client
     * when session is created
     *
     * @param se . It is a < HttpSessionEvent > object
     *
     */
    @Override
    @SuppressWarnings("null")
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext context = null;
        try {
            ViewNumberDAO viewsNumberDAO = new ViewNumberDAOImpl();
            //Get views from database
            int count = viewsNumberDAO.getViewNumber();
            //Formarted to format 6 digits
            NumberFormat formatter = new DecimalFormat("000000");
            String number = formatter.format(count);
            //Add to list to display in client
            List views = new ArrayList();
            for (int i = number.length() - 1; i >= 0; i--) {
                views.add(number.charAt(i));
            }
            //Update views on database and create session           
            viewsNumberDAO.updateViewNumber();
            context = se.getSession().getServletContext();
            //Set attributes
            context.setAttribute("totalViewsNumber", views);
        } catch (Exception ex) {
            //If had an error, send it to Error Page
            context.setAttribute("error", ex.getMessage());
        }
    }

    /**
     * Method do nothings
     *
     * @param se . It is a <code>HttpSessionEvent></code> object
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
