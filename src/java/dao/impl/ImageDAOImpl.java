
package dao.impl;

import context.DBContext;
import dao.ImageDAO;
import entity.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ImageDAOImpl extends DBContext implements ImageDAO {

    /**
     * This method used to count total number of image with id input
     *
     * @param id  of Gallery input.It is <code>int</code>
     * @return count number of image.It is <code>int</code>
     * @throws Exception
     */
    @Override
    public int countImage(int id) throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String query = "SELECT count(*) from image where galery_id = ?";
            conn = getConnection();
            pr = conn.prepareStatement(query);
            pr.setInt(1, id);
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
     * This method used to get url of image with id input
     *
     * @param id of Gallery input.It is <code>int</code>
     * @return  a list of <code>String</code> url of image .It is a <code>java.util.List</code> object
     * @throws Exception
     */
    @Override
    public List<Image> getImageByGaleryID(int id) throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        List<Image> list = new ArrayList<>();
        try {
            String query = "select ROW_NUMBER() over (order by id ASC) as rn , "
                    + "* from  image where galery_id = ?";
            conn = getConnection();
            pr = conn.prepareStatement(query);
            pr.setInt(1, id);
            rs = pr.executeQuery();
            while (rs.next()) {
                Image image = new Image();
                image.setId(rs.getInt(1));
                image.setGaleryId(rs.getInt(3));
                image.setImageUrl(rs.getString(4));
                list.add(image);
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

    /**
     * This method used to get list of image with paging
     *
     * @param galeryID is id of gallery input .It is <code>int</code>
     * @param pageIndex is index of first gallery in list .It is <code>int</code>
     * @param pageSize is number of gallery in 1 page .It is <code>int</code>
     * @return list  is url of image <code>String</code>  .It is a <code>java.util.List</code> object
     * @throws Exception
     */
    @Override
    public List<Image> getListImageWithPaging(int galeryID, int pageIndex, int pageSize) throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        List<Image> list = new ArrayList<>();
        int size = countImage(galeryID);
        try {
            String query = "select * from ( select ROW_NUMBER() over (order by id ASC) as rn "
                    + ", * from  image where galery_id = ?) "
                    + "as b where rn between ((?*?) - ?)and (?*?)";
            conn = getConnection();
            pr = conn.prepareStatement(query);
            pr.setInt(1, galeryID);
            pr.setInt(2, pageSize);
            pr.setInt(3, pageIndex);
            pr.setInt(4, pageSize - 1);
            pr.setInt(5, pageSize);
            pr.setInt(6, pageIndex);
            rs = pr.executeQuery();
            while (rs.next()) {
                Image image = new Image();
                image.setId(rs.getInt("ID"));
                image.setGaleryId(rs.getInt("galery_id"));
                image.setImageUrl(rs.getString("image_url"));
                list.add(image);
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

    /**
     * This method used to get image by Gallery Id and Image Id
     *
     * @param id Gallery Id input .It is <code>int</code>
     * @param galeryId is Image Id .It is <code>Integer</code>
     * @return Image .It is <code>Object</code>
     * @throws Exception
     */
    @Override
    public Image getImageID(int id, int galeryId) throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * from image where id = ? and galery_id = ?";
            conn = getConnection();
            pr = conn.prepareStatement(query);
            pr.setInt(1, id);
            pr.setInt(2, galeryId);
            rs = pr.executeQuery();
            while (rs.next()) {
                Image image = new Image();
                image.setId(rs.getInt("ID"));
                image.setGaleryId(rs.getInt("galery_id"));
                image.setImageUrl(rs.getString("image_url"));
                return image;
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
     * This method used to get Image by Gallery ID
     *
     * @param galeryID is Image Id. It is <code>int</code>
     * @return Image .It is <code>Object</code>
     * @throws Exception
     */
    @Override
    public Image getTop1ImageGalery(int galeryID) throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String query = "SELECT top 1 * from image where galery_id = ?";
            conn = getConnection();
            pr = conn.prepareStatement(query);
            pr.setInt(1, galeryID);
            rs = pr.executeQuery();
            while (rs.next()) {
                Image image = new Image();
                image.setId(rs.getInt("ID"));
                image.setGaleryId(rs.getInt("galery_id"));
                image.setImageUrl(rs.getString("image_url"));
                return image;
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
