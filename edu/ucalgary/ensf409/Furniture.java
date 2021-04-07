/**
 * @author Tyler Tran <a href="mailto:tyler.tran3@ucalgary.ca"> tyler.tran3@ucalgary.ca</a>
 * @version 1.1
 * @since 1.0
*/

/**
 * Furniture class is an abstract class which contains fields and methods relavant
 * to all specific child furniture classes.
 */
package edu.ucalgary.ensf409;

public class Furniture
{
    //--CLASS FIELDS--
    private String id;
    private String type;
    private String manuId;
    private int price;

    /**
     * Furniture constructor, takes in its ID, type, manufactuer's ID, and price.
     * 
     * @param id
     * @param type
     * @param manuId
     * @param price
     */
    public Furniture(String id, String type, String manuId, int price)
    {
        setId(id);
        setType(type);
        setManuId(manuId);
        setPrice(price);
    }

    //--CLASS METHODS--

    // GETTER METHODS
    /**
     * Method that returns the Furniture's ID.
     * 
     * @return String ID
     */
    public String getId() {
        return id;
    }

    /**
     * Method that returns the Furniture's Type.
     * 
     * @return String Type
     */
    public String getType() {
        return type;
    }

    /**
     * Method that returns the Furniture's Manufactuer's ID.
     * 
     * @return String manufacturer's ID
     */
    public String getManuId() {
        return manuId;
    }

    /**
     * Method that returns the Furniture's price.
     * 
     * @return int price
     */
    public int getPrice() {
        return price;
    }

    // SETTER METHODS

    /**
     * Method that sets the ID of the furniture.
     * 
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Method that sets the price of the furniture.
     * 
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }
    
    /**
     * Method that sets the manufacturer's ID of the .
     * 
     * @param manuId
     */
    public void setManuId(String manuId) {
        this.manuId = manuId;
    }

    /**
     * Method that sets the type of the furniture.
     * 
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Method that returns a Furniture Object and its variables and information to
     * a formatted String.
     * 
     * @return String of formatted Furniture output
     */
    public String toString(){
        String temp = "Furniture Object consists of [";
        temp += "ID: " + id + ", ";
        temp += "ManuID: " + manuId + ", ";
        temp += "Type: " + type + ", ";
        temp += "Price: " + price + "]";
        return temp;
    }

}