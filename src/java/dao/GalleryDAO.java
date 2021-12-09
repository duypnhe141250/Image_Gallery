
package dao;

import entity.Gallery;
import java.util.List;


public interface GalleryDAO {

    /**
     * This method used to get top 3 Gallery from database
     *
     * @param topNumber .It is <code>int</code>
     * @return a list  List of Gallery<code>Object</code>.It is <code>java.util.List</code>
     * @throws Exception
     */
    public List<Gallery> getTop3Galery(int topNumber) throws Exception;

    /**
     * This method used to get Gallery by id input
     *
     * @param index .It is <code>int</code>
     * @param id .It is <code>int</code>
     * @return Gallery .It is <code>Object</code>
     * @throws Exception
     */
    public Gallery getGaleryByID(int index, int id) throws Exception;

    /**
     * This method used to count total number of Gallery
     *
     * @return count is number of gallery.It is <code>int</code>
     * @throws Exception
     */
    public int count() throws Exception;

    /**
     * This method used to get list of Gallery with Paging
     *
     * @param pageIndex is index of first gallery in list .It is <code>int</code>
     * @param pageSize is number of gallery in 1 page.It is <code>int</code>
     * @return list is List of Gallery <code>Object</code>.It is <code>java.util.List</code>
     * @throws Exception
     */
    public List<Gallery> getListGaleryWithPaging(int pageIndex, int pageSize) throws Exception;
}
