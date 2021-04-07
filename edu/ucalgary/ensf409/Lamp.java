/** @author Tommy Tran <a 
 * href="mailto:tommy.tran3@ucalgary.ca">tommy.tran3@ucalgary.ca</a>
 * @version  1.1
 * @since    1.0 
 */

package edu.ucalgary.ensf409;

/**
 * Lamp class is a class which contains fields unique to the Lamp class after
 * inheriting from the Furniture abstract class.
 */
public class Lamp extends Furniture {
    // CLASS FIELDS
    private boolean base;
    private boolean bulb;

    /**
     * Lamp constructor, takes in boolean of its usable parts, its id, type,
     * manufactuer's ID, and price.
     * 
     * @param base   boolean
     * @param bulb   boolean
     * @param id     String
     * @param type   String
     * @param manuId String
     * @param price  int
     */
    public Lamp(boolean base, boolean bulb, String id, String type, String manuId, int price) {
        super(id, type, manuId, price);
        setBase(base);
        setBulb(bulb);
    }
    // class methods

    // GETTER METHODS
    /**
     * Method that indicates whether the Lamp has usable bulb.
     * 
     * @return boolean of bulb's usuability
     */
    public boolean getBulb() {
        return bulb;
    }

    /**
     * Method that indicates whether the Lamp has usable base.
     * 
     * @return boolean of base's usuability
     */
    public boolean getBase() {
        return base;
    }

    // SETTER METHODS
    /**
     * Method that sets the usuability of the Lamps's bulb.
     * 
     * @param bulb boolean to set the bulb's usability
     */
    public void setBulb(boolean bulb) {
        this.bulb = bulb;
    }

    /**
     * Method that sets the usuability of the Lamps's base.
     * 
     * @param base boolean to set the base's usability
     */
    public void setBase(boolean base) {
        this.base = base;
    }

    /**
     * Method that returns a Lamp Object and its variables and information to a
     * formatted String.
     * 
     * @return String of formatted Lamp output
     */
    public String toString() {
        String temp = "Lamp Object consists of [";
        temp += "Base: " + base + ", ";
        temp += "Bulb: " + bulb + ", ";
        temp += "ID: " + getId() + ", ";
        temp += "ManuID: " + getManuId() + ", ";
        temp += "Type: " + getType() + ", ";
        temp += "Price: " + getPrice() + "]";
        return temp;
    }
}
