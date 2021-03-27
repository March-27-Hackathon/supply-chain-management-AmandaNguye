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

    // constructor
    public Desk(boolean legs, boolean top, boolean drawer, String id, String type, String manuId, int price){
        super(id, type, manuId, price);
        setLegs(legs);
        setTop(top);
        setDrawer(drawer);
    }

    // getter methods
    public boolean getLegs(){
        return legs;
    }
    public boolean getTop(){
        return top;
    }
   public boolean getDrawer(){
       return drawer;
   }

   // setter methods
   public void setLegs(boolean legs){
       this.legs = legs;
   }
   public void setTop(boolean top){
       this.top = top;
   }
   public void setDrawer(boolean drawer){
       this.drawer = drawer;
   }

   //method to return a formatted string
   public String toString(){
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
