/** @author Tommy Tran <a 
 * href="mailto:tommy.tran3@ucalgary.ca">tommy.tran3@ucalgary.ca</a>
 * @version  1.1
 * @since    1.0 
 */


package edu.ucalgary.ensf409;

/**
 * Chair class is a class which contains fields unique to the chair class after 
 * inheriting from the Furniture abstract class.
 */
public class Chair extends Furniture {
    // CLASS FIELDS
    private boolean legs;
    private boolean arms;
    private boolean seat;
    private boolean cushion;

    /**
     * Chair constructor, takes in boolean of its usable parts, its ID, type,
     * manufactuer's ID, and price.
     * 
     * @param legs    boolean
     * @param arms    boolean
     * @param seat    boolean
     * @param cushion boolean
     * @param id      String
     * @param type    String
     * @param manuId  String
     * @param price   int
     */
    public Chair(boolean legs, boolean arms, boolean seat, boolean cushion, String id, String type, String manuId,
            int price) {
        super(id, type, manuId, price);
        setArms(arms);
        setCushion(cushion);
        setSeat(seat);
        setLegs(legs);
    }

    // class methods

    // GETTER METHODS
    /**
     * Method that indicates whether the Chair has usable arms.
     * 
     * @return boolean of arms' usuability
     */
    public boolean getArms() {
        return arms;
    }

    /**
     * Method that indicates whether the Chair has a usable cushion.
     * 
     * @return boolean of cushion's usuability
     */
    public boolean getCushion() {
        return cushion;
    }

    /**
     * Method that indicates whether the Chair has usable legs.
     * 
     * @return boolean of legs' usuability
     */
    public boolean getLegs() {
        return legs;
    }

    /**
     * Method that indicates whether the Chair has a usable seat.
     * 
     * @return boolean of seat's usuability
     */
    public boolean getSeat() {
        return seat;
    }

    // SETTER METHODS
    /**
     * Method that sets the usuability of the Chair's arms.
     * @param arms
     */
    public void setArms(boolean arms) {
        this.arms = arms;
    }

    /**
     * Method that sets the usuability of the Chair's cushion.
     * 
     * @param cushion
     */
    public void setCushion(boolean cushion) {
        this.cushion = cushion;
    }

    /**
     * Method that sets the usuability of the Chair's legs.
     * 
     * @param legs
     */
    public void setLegs(boolean legs) {
        this.legs = legs;
    }

    /**
     * Method that sets the usuability of the Chair's seat.
     * 
     * @param seat
     */
    public void setSeat(boolean seat) {
        this.seat = seat;
    }

    /**
     * Method that returns a Chair Object and its variables and information to a
     * formatted String.
     * 
     * @return String of formatted Chair Object
     */
        public String toString() {
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