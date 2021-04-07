/** @author Tommy Tran <a href="mailto:tommy.tran3@ucalgary.ca">tommy.tran3@ucalgary.ca</a>
 * @version  1.1
 * @since    1.0 
 */


package edu.ucalgary.ensf409;

/**
 * Filing class is a class which contains fields unique to the filing class after 
 * inheriting from the Furniture abstract class.
 */
public class Filing extends Furniture {
    // CLASS FIELDS
    private boolean rails;
    private boolean drawers;
    private boolean cabinet;

    /**
     * Filing constructor, takes in boolean of its usable parts, its ID, type,
     * manufactuer's ID, and price.
     * 
     * @param rails   boolean
     * @param drawers boolean
     * @param cabinet boolean
     * @param id      String
     * @param type    String
     * @param manuId  String
     * @param price   int
     */
    public Filing(boolean rails, boolean drawers, boolean cabinet, String id, String type, String manuId, int price) {
        super(id, type, manuId, price);
        setRails(rails);
        setDrawers(drawers);
        setCabinet(cabinet);
    }

    // class methods

    // GETTER METHODS
    /**
     * Method that indicates whether the Filing has usable rails.
     * 
     * @return boolean of rails' usuability
     */
    public boolean getRails() {
        return rails;
    }

    /**
     * Method that indicates whether the Filing has usable drawers.
     * 
     * @return boolean of drawers' usuability
     */
    public boolean getDrawers() {
        return drawers;
    }

    /**
     * Method that indicates whether the Filing has a usable cabinet.
     * 
     * @return boolean of cabinet' usuability
     */
    public boolean getCabinet() {
        return cabinet;
    }

    // SETTER METHODS
    /**
     * Method that sets the usuability of the desk's rails.
     * 
     * @param rails boolean to set the rails variable
     */
    public void setRails(boolean rails) {
        this.rails = rails;
    }

    /**
     * Method that sets the usuability of the desk's drawers.
     * 
     * @param rails boolean to set the drawers variable
     */
    public void setDrawers(boolean drawers) {
        this.drawers = drawers;
    }

    /**
     * Method that sets the usuability of the desk's cabinet.
     * 
     * @param rails boolean to set the cabinet variable
     */
    public void setCabinet(boolean cabinet) {
        this.cabinet = cabinet;
    }

    /**
     * Method that returns a Filing Object and its variables and information to a
     * formatted String.
     * 
     * @return String of formatted Filing Object
     */
    public String toString() {
        String temp = "Filing Object consists of [";
        temp += "Rails: " + rails + ", ";
        temp += "Drawers: " + drawers + ", ";
        temp += "Cabinet: " + cabinet + ", ";
        temp += "ID: " + getId() + ", ";
        temp += "ManuID: " + getManuId() + ", ";
        temp += "Type: " + getType() + ", ";
        temp += "Price: " + getPrice() + "]";
        return temp;
    }
}
