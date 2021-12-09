
package entity;

public class Image {

    /**
     * Create attributes
     */
    private int id;
    private int galeryId;
    private String imageUrl;

    /**
     * Create constructor with no parameters
     */
    public Image() {
    }

    /**
     * Create constructor with parameters
     *
     * @param id .It is<code>int</code>
     * @param galeryId .It is<code>int</code>
     * @param imageUrl .It is<code>String</code>
     */
    public Image(int id, int galeryId, String imageUrl) {
        this.id = id;
        this.galeryId = galeryId;
        this.imageUrl = imageUrl;
    }

    /**
     * This method used to get Id
     *
     * @return id .It is<code>int</code>
     */
    public int getId() {
        return id;
    }

    /**
     * This method used to set Id
     *
     * @param id .It is<code>int</code>
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * This method used to get Gallery Id
     *
     * @return galeryId .It is<code>int</code>
     */
    public int getGaleryId() {
        return galeryId;
    }

    /**
     * This method used to set Gallery Id
     *
     * @param galeryId .It is<code>int</code>
     */
    public void setGaleryId(int galeryId) {
        this.galeryId = galeryId;
    }

    /**
     * This method used to get Image url
     *
     * @return imageUrl .It is<code>String</code>
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * This method used to set Image url
     *
     * @param imageUrl .It is<code>String</code>
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
