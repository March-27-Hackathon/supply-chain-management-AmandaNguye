/** @author Tommy Tran <a 
 * href="mailto:tommy.tran3@ucalgary.ca">tommy.tran3@ucalgary.ca</a>
 * @version  1.1
 * @since    1.0 
 */


/**
 * Chair class is a class which contains fields unique to the chair class after 
 * inheriting from the Furniture abstract class.
 */

package edu.ucalgary.ensf409;

public class Chair extends Furniture {
    // class fields
    private boolean legs;
    private boolean arms;
    private boolean seat;
    private boolean cushion;

    // constructor
    public Chair(boolean legs, boolean arms, boolean seat, boolean cushion, String id, String type, String manuId, int price){
        super(id, type, manuId, price);
        setArms(arms);
        setCushion(cushion);
        setSeat(seat);
        setLegs(legs);
    }

    // class methods

    // getter methods
    public boolean getArms() {
        return arms;
    }
    public boolean getCushion() {
        return cushion;
    }
    public boolean getLegs() {
        return legs;
    }
    public boolean getSeat() {
        return seat;
    }

    // setter methods
    public void setArms(boolean arms) {
        this.arms = arms;
    }
    public void setCushion(boolean cushion) {
        this.cushion = cushion;
    }
    public void setLegs(boolean legs) {
        this.legs = legs;
    }
    public void setSeat(boolean seat) {
        this.seat = seat;
    }

    //method to return a formatted string
    public String toString(){
        String temp = "Chair Object consists of [";
        temp += "Legs: " + legs + ", ";
        temp += "Arms: " + arms + ", ";
        temp += "Seat: " + seat + ", ";
        temp += "Cushion: " + cushion + ", ";
        temp += "ID: " + getId() + ", ";
        temp += "ManuID: " + getManuId() + ", ";
        temp += "Type: " + getType() + ", ";
        temp += "Price: " + getPrice() + "]";
        return temp;
    }

}