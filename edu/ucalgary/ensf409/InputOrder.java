/**
 * @author Dat Lam
 *         <a href="mailto:dat.lam1@ucalgary.ca">dat.lam1@ucalgary.ca</a>
 * @version 1.0
 * @since 1.0
 * 
 */
package edu.ucalgary.ensf409;


public class InputOrder 
{
    private String furType;
    private String furniture;
    private int quantity;

    
    public InputOrder()
    {
    }

    //Setter methods
    /**
     * Set furType to param
     * @param furType
     */
    public void setFurType(String furType) {
        this.furType = furType;
    }

    /**
     * Set furniture to param
     * @param furniture
     */
    public void setFurniture(String furniture) {
        this.furniture = furniture;
    }

    /**
     * Set quantity to param
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //Getters Methods
    public String getFurType() {
        return furType;
    }

    public String getFurniture() {
        return furniture;
    }

    public int getQuantity() {
        return quantity;
    }
}
