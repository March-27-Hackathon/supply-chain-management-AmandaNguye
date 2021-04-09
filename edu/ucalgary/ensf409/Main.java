/**
 * ENSF 409: Final Project - Furniture.jar
 * Group 19: Amanda Nguyen, Dat Lam, Tyler Tran, Tommy Tran
 * 
 * @author Amanda <a href="mailto:amanda.nguyen1@ucalgary.ca"> amanda.nguyen1@ucalgary.ca</a>
 * @author Tyler Tran <a href="mailto:tyler.tran3@ucalgary.ca"> tyler.tran3@ucalgary.ca</a>
 * @author Dat Lam <a href="mailto:dat.lam1@ucalgary.ca">dat.lam1@ucalgary.ca</a>
 * @author Tommy Tran <a href="mailto:tommy.tran3@ucalgary.ca">tommy.tran3@ucalgary.ca</a>
 * @version 1.6
 * @since 1.0
*/

/*
<!--INSTRUCTIONS-->


(1)Run the program using the following line in the command prompt:
	"java -jar Furniture.jar"

(2)The panel shows "Please Enter a Username"
	-Enter your MySQL username (eg. "scm"). This is case-sensitive.
	-Hit "Enter".

(3)The panel shows "Please Enter a Password"
	-Enter your MySQL password (eg. "ensf409"). This is case-sensitive.
	-Hit "Enter".

   If either the unsername or password are invalid, the panel will show
   	"Invalid Username or Password, Try Again?"
        -Click "Repeat" to return to step (2).
   
   If the username and password are valid, the program will continue to step (4).

(4)The panel shows "Please input furniture"
	-Enter your category type followed by the furniture category separated by a space 
         (eg. "mesh chair", "staNdinG DESK"). This is not case-sensitive.
	-Hit "Enter".

(5)The panel shows "Please input the quantity"
	-Enter your requested integer furniture count (eg. "0" to "9").
	-Hit "Enter".

  If the input is not an integer, the panel will show
  	"Please input an integer"
  	And repeats Step (5) till the use inputs a valid integer.

(6)If the input to step (4) is invalid (nonexistent type, improper order) the panel will show
	"Furniture input is invalid"
 	-Hit "Enter"
   If the order cannot be fulfilled due to lack of quantity or parts, the panel will show
	"No available [furniture] to match the critera"
	where [furniture] is the validly requested furniture type and category,
	-Hit "Enter" and the program will output to the terminal a list of relevant manufacturers that
	can provide that furniture type and category.
   If the order can be fulfilled, an output txt file named orderform###.txt will be created, where ### is the order number.
	The txt file contains the IDs of the used items from the inventory and these items will be removed from the database.
	In addition, the order summary will be displayed in the terminal.

(7)The panel shows "Continue?"
	-Hit "Yes" to return to step (4).
	-Hit "No" to terminate the program.
 */

package edu.ucalgary.ensf409;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * The Main class house the main method that is use to run the program
 */
@SuppressWarnings("unchecked")
public class Main extends Output {
    /**
     * The main method is use to run the program First, it makes a connection to the
     * database using the promted user input. Then it tries to find the lowest
     * priced combination for the requested item (Which is also taken in through a
     * promted input). An output is produced detailed the success/fail of the order
     * and process can be repeated.
     * 
     * @param args
     */
    public static void main(String[] args) {

        /**
         * Attempts to intialize storage based on credentials Will loop until storage is
         * intialized or user decides to stop
         */
        Storage storage = null;
        do {
            String username = JOptionPane.showInputDialog("Please Enter a Username");
            String password = JOptionPane.showInputDialog("Please Enter a Password");
            try {
                storage = new Storage(username, password);
                break;
            } catch (SQLException e) {
                if (JOptionPane.showConfirmDialog(null, "Invalid Username or Password, Try Again?", "Repeat",
                        JOptionPane.YES_OPTION) == JOptionPane.NO_OPTION) {
                    System.exit(0);
                }
            }
        } while (true);

        // Creating the input object
        InputOrder input = new InputOrder();
        Request rq = new Request(storage);
        Boolean invalidChairInput = false;

        ArrayList<? extends Furniture> arr = new ArrayList<>();
        do {
            /*
             * Getting the furniture type by splitting the inputted furniture by spaces and
             * setting the furniture as the last substring and everything as the furniture
             * type.
             */
            String furnitureInput = JOptionPane.showInputDialog("Please input furniture");
            String[] splittedInput = furnitureInput.split("\\s+");

            input.setFurniture(splittedInput[splittedInput.length - 1]);
            String furType = "";
            furType += splittedInput[0];
            for (int i = 1; i < splittedInput.length - 1; i++) {
                furType += " " + splittedInput[i];
            }
            input.setFurType(furType);

            // Creating a loop to ensure that the inputted quantity is always an integer
            String quantity;
            do {
                quantity = JOptionPane.showInputDialog("Please input the quantity");
                if (quantity.matches("^[0-9]+$")) {
                    input.setQuantity(Integer.parseInt(quantity));
                } else {
                    JOptionPane.showMessageDialog(null, "Please input an integer");
                }

            } while (!quantity.matches("^[0-9]+$"));

            /**
             * Attempts to fetch the furniture based off the prompts
             */
            try {
                arr = rq.request(input.getFurniture(), input.getFurType(), input.getQuantity());
            } catch (IllegalArgumentException e) {
                invalidChairInput = true;
            }

            /**
             * If request throws and IllgalArgumentException, display "Furniture input is
             * invalid" If returned array is null, display "No available chairs to match the
             * critera" Otherwise order is filled and display the messages appropriately
             */
            if (invalidChairInput) {
                JOptionPane.showMessageDialog(null, "Furniture input is invalid");
            } else if (arr == null || arr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No available " + input.getFurniture() + " to match the critera");
                Output.unsuccessfulOutput(input.getFurniture(), input.getFurType(), input.getQuantity(),
                        storage.getManufacturerStorage(input.getFurniture()));
            } else {
                JOptionPane.showMessageDialog(null, "Order complete!");
                Output.successfulInput("orderform", input.getFurniture(), input.getFurType(), input.getQuantity(),
                        (ArrayList<Furniture>) arr);
                for (Furniture item : arr) {
                    storage.removeFromStorage(input.getFurniture(), item.getId());
                }
            }
        } while (JOptionPane.showConfirmDialog(null, "Continue?", "Please Select",
                JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION);
        System.exit(0);
    }
}