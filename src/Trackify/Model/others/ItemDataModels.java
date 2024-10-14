
package Trackify.Model.others;

import javax.swing.Icon;


public class ItemDataModels {

    /**
     * @return the cartQuantity
     */
    public int getCartQuantity() {
        return cartQuantity;
    }

    /**
     * @param cartQuantity the cartQuantity to set
     */
    public void setCartQuantity(int cartQuantity) {
        this.cartQuantity = cartQuantity;
    }

    /**
     * @return the itemID
     */
    public String getItemID() {
        return itemID;
    }

    /**
     * @param itemID the itemID to set
     */
    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the itemImage
     */
    public Icon getItemImage() {
        return itemImage;
    }

    /**
     * @param itemImage the itemImage to set
     */
    public void setItemImage(Icon itemImage) {
        this.itemImage = itemImage;
    }

    public ItemDataModels(String itemID, String title, String location, String category, int quantity, String status, Icon itemImage) {
        this.itemID = itemID;
        this.title = title;
        this.location = location;
        this.category = category;
        this.quantity = quantity;
        this.status = status;
        this.itemImage = itemImage;
    }

 
    
    public ItemDataModels() {
    }
    private String itemID;
    private String title;
    private String location;
    private String category;
    private int quantity;
    private String status;
    private Icon itemImage;
    private int cartQuantity;
}
