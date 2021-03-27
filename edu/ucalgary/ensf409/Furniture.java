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

    //--CLASS CONSTRUCTOR--
    public Furniture(String id, String type, String manuId, int price)
    {
        setId(id);
        setType(type);
        setManuId(manuId);
        setPrice(price);
    }

    //--CLASS METHODS--

    // GETTER METHODS
    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getManuId() {
        return manuId;
    }

    public int getPrice() {
        return price;
    }

    // SETTER METHODS
    public void setId(String id) {
        this.id = id;
    }

    public void setManuId(String manuId) {
        this.manuId = manuId;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    //method to return a formatted string
    public String toString(){
        String temp = "Furniture Object consists of [";
        temp += "ID: " + id + ", ";
        temp += "ManuID: " + manuId + ", ";
        temp += "Type: " + type + ", ";
        temp += "Price: " + price + "]";
        return temp;
    }

}