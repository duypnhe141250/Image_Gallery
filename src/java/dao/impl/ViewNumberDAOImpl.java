
package dao.impl;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dao.ViewNumberDAO;


public class ViewNumberDAOImpl extends DBContext implements ViewNumberDAO {
    /**
     * This method used to update Views +1 table
     *
     * @throws Exception
     */
    @Override
    public void updateViewNumber() throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String query = "UPDATE [Contact] SET viewnumber = viewnumber + 1";
            conn = getConnection();
            pr = conn.prepareStatement(query);
            pr.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pr);
            closeConnection(conn);
        }
    }
     /**
     * This method used to get Views table
     *
     * @return a integer number is view number. It is a <code>int</code>
     * @throws Exception
     */
    @Override
    public int getViewNumber() throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String query = "SELECT top 1 viewnumber from contact";
            conn = getConnection();
            pr = conn.prepareStatement(query);
            rs = pr.executeQuery();
            while (rs.next()) {             
                return rs.getInt("viewnumber");               
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pr);
            closeConnection(conn);
        }
        return 0;
    }

}
