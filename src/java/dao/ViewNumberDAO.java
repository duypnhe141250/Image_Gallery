
package dao;

public interface ViewNumberDAO {


    /**
     * This method used to update Views +1 table
     *
     * @throws Exception
     */
    public void updateViewNumber() throws Exception;
     /**
     * This method used to get Views table
     *
     * @return a integer number is view number. It is a <code>int</code>
     * @throws Exception
     */
    public int getViewNumber() throws Exception;
}
