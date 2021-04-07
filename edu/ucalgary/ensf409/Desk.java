/** @author Tommy Tran <a 
 * href="mailto:tommy.tran3@ucalgary.ca">tommy.tran3@ucalgary.ca</a>
 * @version  1.1
 * @since    1.0 
 */

/**
 * Desk class is a class which contains fields unique to the desk class after 
 * inheriting from the Furniture abstract class.
 */

package edu.ucalgary.ensf409;

public class Desk extends Furniture {
    // class fields
    private boolean legs;
    private boolean top;
    private boolean drawer;

    /**
     * Desk Constructor, takes in boolean of its usable parts, its id, type,
     * manufactuer's ID, and its price.
     * 
     * @param legs   boolean
     * @param top    boolean
     * @param drawer boolean
     * @param id     String
     * @param type   String
     * @param manuId String
     * @param price  int
     */
    public Desk(boolean legs, boolean top, boolean drawer, String id, String type, String manuId, int price) {
        super(id, type, manuId, price);
        setLegs(legs);
        setTop(top);
        setDrawer(drawer);
    }

    // GETTER METHODS
    /**
     * Getter method for the legs. Indicates whether the desk has usable legs.
     * 
     * @return boolean legs
     */
    public boolean getLegs() {
        return legs;
    }

    /**
     * Getter method for the top. Indicates whether the desk has a usable top.
     * 
     * @return boolean top
     */
    public boolean getTop() {
        return top;
    }

    /**
     * Getter method for drawer. Indicates whether the desk has a usable drawer.
     * 
     * @return boolean drawer
     */
    public boolean getDrawer() {
        return drawer;
    }

    // SETTER METHODS
    /**
     * Setter method for legs' usability boolean.
     * 
     * @param legs boolean to set the legs variable
     */
    public void setLegs(boolean legs) {
        this.legs = legs;
    }

    /**
     * Setter method for top's usability boolean.
     * 
     * @param top boolean to set the top
     */
    public void setTop(boolean top) {
        this.top = top;
    }

    /**
     * Setter method for drawer's usability boolean.
     * 
     * @param drawer boolean to set the drawer
     */
    public void setDrawer(boolean drawer) {
        this.drawer = drawer;
    }

    /**
     * Method that returns a desk Object and its variables and information to a
     * formatted String.
     * 
     * @return String of formatted desk Object
     */
    public String toString() {
        String temp = "Desk Object consists of [";
        temp += "Legs: " + legs + ", ";
        temp += "Top: " + top + ", ";
        temp += "Drawer: " + drawer + ", ";
        temp += "ID: " + getId() + ", ";
        temp += "ManuID: " + getManuId() + ", ";
        temp += "Type: " + getType() + ", ";
        temp += "Price: " + getPrice() + "]";
        return temp;
    }
}
