
package entity;


public class Gallery {

    /**
     * create attributes
     */
    private int ID;
    private String title;
    private String description;
    private String name;
    private String image;

    /**
     * Create constructor with no parameters
     */
    public Gallery() {
    }

    /**
     * Create constructor with parameters
     *
     * @param ID .It is<code>int</code>
     * @param title .It is<code>String</code>
     * @param description .It is<code>String</code>
     * @param name .It is<code>String</code>
     * @param image .It is<code>String</code>
     */
    public Gallery(int ID, String title, String description, String name, String image) {
        this.ID = ID;
        this.title = title;
        this.description = description;
        this.name = name;
        this.image = image;
    }

    /**
     * This method used to get url of image by Gallery Id
     *
     * @return url of image
     */
    public String getImage(){
        return image;
    }

    /**
     * This method used to set url of image
     *
     * @param image .It is<code>String</code>
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * This method used to get Name
     *
     * @return name .It is<code>String</code>
     */
    public String getName() {
        return name;
    }

    /**
     * This method used to set Name
     *
     * @param name .It is<code>String</code>
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method used to get Id
     *
     * @return ID .It is<code>int</code>
     */
    public int getID() {
        return ID;
    }

    /**
     * This method used to set Id
     *
     * @param ID .It is<code>int</code>
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * This method used to get Title
     *
     * @return title .It is<code>String</code>
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method used to set Title
     *
     * @param title .It is<code>String</code>
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method used to get Description
     *
     * @return description .It is<code>String</code>
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method used to set Description
     *
     * @param description .It is<code>String</code>
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method used to get String of Gallery
     *
     * @return a String display in contact page .It is<code>String</code>
     */
    @Override
    public String toString() {
        return "Galery{" + "ID=" + ID + ", title=" + title + ", description=" + description + '}';
    }

}
