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
}