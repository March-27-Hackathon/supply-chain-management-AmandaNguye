/**
 * @author Dat Lam
 *         <a href="mailto:dat.lam1@ucalgary.ca">dat.lam1@ucalgary.ca</a>
 * @version 1.0
 * @since 1.0
 * 
 */
package edu.ucalgary.ensf409;

public class InputOrder {
    // class variables
    private String furType;
    private String furniture;
    private int quantity;

    /**
     * InputOrder cnstructor, takes in no params. Sets variables to default values.
     * 
     */
    public InputOrder() {
    }

    // Setter methods
    /**
     * Method that sets the furniture type of the order request.
     * 
     * @param furType
     */
    public void setFurType(String furType) {
        this.furType = furType;
    }

    /**
     * Method that sets the furniture category of the order request.
     * 
     * @param furniture
     */
    public void setFurniture(String furniture) {
        this.furniture = furniture;
    }

    /**
     * Method that sets the furniture quantity of the order request.
     * 
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // GETTER METHODS
    /**
     * Method that returns the furniture type of the order request.
     * 
     * @return String of furniture type
     */
    public String getFurType() {
        return furType;
    }

    /**
     * Method that returns the furniture category of the order request.
     * 
     * @return String of furniture category
     */
    public String getFurniture() {
        return furniture;
    }

    /**
     * Method that returns the quantity of the order request.
     * 
     * @return int of the quantity
     */
    public int getQuantity() {
        return quantity;
    }
}
