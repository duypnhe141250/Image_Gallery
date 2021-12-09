
package dao.impl;

import context.DBContext;
import dao.ContactDAO;
import entity.Contact;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ContactDAOImpl extends DBContext implements ContactDAO {

    /**
     * This method used to get all contact from database
     * @return Contact .It is <code>Object</code>
     * @throws Exception
     */
    @Override
    public Contact getContact() throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String query = "SELECT top 1 * from contact";
            conn = getConnection();
            pr = conn.prepareStatement(query);
            rs = pr.executeQuery();
            while (rs.next()) {
                Contact contact = new Contact();
                contact.setTelephone(rs.getString("telephone"));
                contact.setEmail(rs.getString("email"));
                contact.setFaceUrl(rs.getString("face_url"));
                contact.setTwitterUrl(rs.getString("twitter_url"));
                contact.setGoogleUrl(rs.getString("google_url"));
                contact.setAbout(rs.getString("about"));
                contact.setAddress(rs.getString("address"));
                contact.setCity(rs.getString("city"));
                contact.setCountry(rs.getString("country"));
                contact.setMapUrl(rs.getString("map_url"));
                contact.setImageMain(rs.getString("image_main"));
                contact.setIconFace(rs.getString("icon_face"));
                contact.setIconTwitter(rs.getString("icon_twitter"));
                contact.setIconGoogle(rs.getString("icon_google"));
                contact.setViewNumber(rs.getInt("viewnumber"));              
                return contact;               
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pr);
            closeConnection(conn);
        }
        return null;
    }
}
