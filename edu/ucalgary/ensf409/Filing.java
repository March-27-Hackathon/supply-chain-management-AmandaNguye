/**
 * Filing class is a class which contains fields unique to the filing class after 
 * inheriting from the Furniture abstract class.
 */

package edu.ucalgary.ensf409;

public class Filing extends Furniture {
    // class fields
    private boolean rails;
    private boolean drawers;
    private boolean cabinet;
    
    // constructor
    public Filing(boolean rails, boolean drawers, boolean cabinet, String id, String type, String manuId, int price){
        super(id, type, manuId, price);
        setRails(rails);
        setDrawers(drawers);
        setCabinet(cabinet);
    }

    // class methods



    // getter methods
    public boolean getRails() {
        return rails;
    }
    public boolean getDrawers() {
        return drawers;
    }
    public boolean getCabinet() {
        return cabinet;
    }

    // setter methods
    public void setRails(boolean rails) {
        this.rails = rails;
    }
    public void setDrawers(boolean drawers) {
        this.drawers = drawers;
    }
    public void setCabinet(boolean cabinet) {
        this.cabinet = cabinet;
    }

    //method to return a formatted string
    public String toString(){
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
