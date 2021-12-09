
package dao;

import entity.Contact;

public interface ContactDAO {

    /**
     * This method used to get all contact from database
     *
     * @return Contact. It is <code>Object</code>
     * @throws Exception
     */
    public Contact getContact() throws Exception;
}
