/** @author Tommy Tran <a 
 * href="mailto:tommy.tran3@ucalgary.ca">tommy.tran3@ucalgary.ca</a>
 * @version  1.1
 * @since    1.0 
 */

/**
 * Lamp class is a class which contains fields unique to the Lamp class after 
 * inheriting from the Furniture abstract class.
 */

package edu.ucalgary.ensf409;

public class Lamp extends Furniture {
    // class fields
    private boolean base;
    private boolean bulb;

    // constructor
    public Lamp(boolean base, boolean bulb, String id, String type, String manuId, int price){
        super(id, type, manuId, price);
        setBase(base);
        setBulb(bulb);
    }
    // class methods

    // getter methods
    public boolean getBulb() {
        return bulb;
    }
    public boolean getBase() {
        return base;
    }

    // setter methods
    public void setBulb(boolean bulb) {
        this.bulb = bulb;
    }
    public void setBase(boolean base) {
        this.base = base;
    }

    //method to return a formatted string
    public String toString(){
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
