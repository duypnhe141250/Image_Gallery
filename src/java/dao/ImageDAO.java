
package dao;

import entity.Image;
import java.util.List;


public interface ImageDAO {

    /**
     * This method used to count total number of image with id input
     *
     * @param id is identity number of Gallery  .It is <code>int</code>
     * @return count is number of image.It is <code>int</code>
     * @throws Exception
     */
    public int countImage(int id) throws Exception;

    /**
     * This method used to get url of image with id input
     *
     * @param id is identity number of Gallery .It is <code>int</code>
     * @return url is url of image .It is <code>String</code>
     * @throws Exception
     */
    public List<Image> getImageByGaleryID(int id) throws Exception;

    /**
     * This method used to get list of image with paging
     *
     * @param galeryID is identity of gallery  .It is <code>int</code>
     * @param pageIndex is index of first gallery in list .It is <code>int</code>
     * @param pageSize is number of gallery in 1 page.It is <code>int</code>
     * @return list is List of Image <code>Object</code> .It is <code>java.util.List</code>
     * @throws Exception
     */
    public List<Image> getListImageWithPaging(int galeryID, int pageIndex, int pageSize) throws Exception;

    /**
     * This method used to get image by Gallery Id and Image Id
     *
     * @param id is  identity number of Gallery . It is <code>int</code>
     * @param galeryId is Image Id .It is <code>int</code>
     * @return Image .It is <code>Object</code>
     * @throws Exception
     */
    public Image getImageID(int id, int galeryId) throws Exception;

    /**
     * This method used to get Image by Gallery ID
     *
     * @param galeryID is identity number of Image .It is <code>int</code>
     * @return Image .It is <code>Object</code>
     * @throws Exception
     */
    public Image getTop1ImageGalery(int galeryID) throws Exception;
}
