/**
 * Chair class is a class which contains fields unique to the chair class after 
 * inheriting from the Furniture abstract class.
 */

package edu.ucalgary.ensf409;

public class Chair extends Furniture {
    // class fields
    private char legs;
    private char arms;
    private char seat;
    private char cushion;
    // class methods

    // getter methods
    public char getArms() {
        return arms;
    }
    public char getCushion() {
        return cushion;
    }
    public char getLegs() {
        return legs;
    }
    public char getSeat() {
        return seat;
    }

    // setter methods
    public void setArms(char arms) {
        this.arms = arms;
    }
    public void setCushion(char cushion) {
        this.cushion = cushion;
    }
    public void setLegs(char legs) {
        this.legs = legs;
    }
    public void setSeat(char seat) {
        this.seat = seat;
    }

}