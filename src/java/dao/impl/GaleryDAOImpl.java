
package dao.impl;

import context.DBContext;
import entity.Gallery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.GalleryDAO;


public class GaleryDAOImpl extends DBContext implements GalleryDAO {

    /**
     * This method used to get top 3 Gallery from database
     *
     * @return list: List of Gallery
     * @throws Exception
     */
    @Override
    public List<Gallery> getTop3Galery(int topNumber) throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        List<Gallery> listGalery = new ArrayList<>();
        try {
            String query = "SELECT top (?) * from galery";
            conn = getConnection();
            pr = conn.prepareStatement(query);
            pr.setInt(1, topNumber);
            rs = pr.executeQuery();
            while (rs.next()) {
                Gallery galery = new Gallery();
                galery.setID(rs.getInt("ID"));
                galery.setTitle(rs.getString("title"));
                galery.setDescription(rs.getString("description"));
                galery.setName(rs.getString("name"));
                galery.setImage(rs.getString("image"));
                listGalery.add(galery);
            }

        } catch (SQLException ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pr);
            closeConnection(conn);
        }
        return listGalery;
    }

    /**
     * This method used to get Gallery by id input
     *
     * @param index .It is <code>int</code>
     * @param id .It is <code>int</code>
     * @return Gallery . It is <code>Object</code>
     * @throws Exception
     */
    @Override
    public Gallery getGaleryByID(int index, int id) throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String query = "SELECT top (?) * from galery where ID = ?";
            conn = getConnection();
            pr = conn.prepareStatement(query);
            pr.setInt(1, index);
            pr.setInt(2, id);
            rs = pr.executeQuery();
            while (rs.next()) {
                Gallery galery = new Gallery();
                galery.setID(rs.getInt("ID"));
                galery.setTitle(rs.getString("title"));
                galery.setDescription(rs.getString("description"));
                galery.setName(rs.getString("name"));
                galery.setImage(rs.getString("image"));
                return galery;
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

    /**
     * This method used to count total number of Gallery
     *
     * @return count is number of gallery.It is <code>int</code>
     * @throws Exception
     */
    @Override
    public int count() throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String query = "SELECT count(*) from galery";
            conn = getConnection();
            pr = conn.prepareStatement(query);
            rs = pr.executeQuery();
            int cout = 0;
            while (rs.next()) {
                cout = rs.getInt(1);
            }
            return cout;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pr);
            closeConnection(conn);
        }
    }

    /**
     * This method used to get list of Gallery with Paging
     *
     * @param pageIndex  index of first gallery in list.It is <code>int</code>
     * @param pageSize number of gallery in 1 page.It is <code>int</code>
     * @return list: is list Gallery object <code>Object</code>  .It is a <code>java.util.List</code> object
     * @throws Exception
     */
    @Override
    public List<Gallery> getListGaleryWithPaging(int pageIndex, int pageSize) throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        List<Gallery> list = new ArrayList<>();
        int size = count();
        try {
            String query = "select * from ( select ROW_NUMBER() over "
                    + "(order by id ASC) as rn , * from  galery )"
                    + "as b where rn between ((?*?) - ?)and (?*?)";
            conn = getConnection();
            pr = conn.prepareStatement(query);
            pr.setInt(1, pageSize);
            pr.setInt(2, pageIndex);
            pr.setInt(3, pageSize - 1);
            pr.setInt(4, pageSize);
            pr.setInt(5, pageIndex);
            rs = pr.executeQuery();
            while (rs.next()) {
                Gallery galery = new Gallery();
                galery.setID(rs.getInt("ID"));
                galery.setTitle(rs.getString("title"));
                galery.setDescription(rs.getString("description"));
                galery.setName(rs.getString("name"));
                galery.setImage(rs.getString("image"));
                list.add(galery);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pr);
            closeConnection(conn);
        }
        return list;
    }
    public static void main(String[] args) throws Exception {
        GalleryDAO g= new GaleryDAOImpl();
        List<Gallery> gallery=g.getListGaleryWithPaging(1, 2);
    }
}
