/**
 * @author Amanda <a href="mailto:amanda.nguyen1@ucalgary.ca"> amanda.nguyen1@ucalgary.ca</a>
 * @author Tyler Tran <a href="mailto:tyler.tran3@ucalgary.ca"> tyler.tran3@ucalgary.ca</a>
 * @version 1.0
 * @since 1.0
*/

// TODO
/**
 * If output is null, print manufacturer
 * Output to console even when sucessful
 * Remove from database (if sucessful)
 * JUnit test
 * Finishing UML
 * WebDev
 */

package edu.ucalgary.ensf409;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import javax.lang.model.util.ElementScanner14;
import javax.swing.JOptionPane;

public class Main extends Output{
    public static void main(String[] args) {
        String username = "tyler";
        String password = "ensf409";

        //Creating the input object
        InputOrder input = new InputOrder();
        Storage storage = new Storage(username,password);
        Request rq = new Request(storage);

        ArrayList<? extends Furniture> arr = new ArrayList<>();
        boolean repeat = true;
        
        do
        {
            /*Getting the furniture type by splitting the inputted furniture by spaces
            and setting the furniture as the last substring and everything as the
            furniture type.
            */
            String furnitureInput = JOptionPane.showInputDialog("Please input furniture");
            String[] splittedInput = furnitureInput.split("\\s+");
            
            input.setFurniture(splittedInput[splittedInput.length-1]);
            String furType = "";
            furType += splittedInput[0];
            for(int i = 1 ; i < splittedInput.length -1; i++)
            {
                furType += " " + splittedInput[i];
            }
            input.setFurType(furType);

            //Creating a loop to ensure that the inputted quantity is always an integer
            String quantity;
            do 
            {
                quantity = JOptionPane.showInputDialog("Please input the quantity");
                if(quantity.matches("^[0-9]+$"))
                {
                    input.setQuantity(Integer.parseInt(quantity));
                } else 
                {
                    JOptionPane.showMessageDialog(null, "Please input an integer");
                }

            } while(!quantity.matches("^[0-9]+$"));

            arr = rq.request(input.getFurniture(), input.getFurType(),input.getQuantity());
            if(arr==null)
            {
                Output.writeFormattedTerminal(input.getFurniture(),input.getFurType(),input.getQuantity(),storage.getManufacturerStorage(input.getFurniture()));
            }
            else 
            {
                Output.writeFormattedFile("orderform",input.getFurniture(),input.getFurType(),input.getQuantity(),(ArrayList<Furniture>)arr);
                for(Furniture item: arr)
                {
                    storage.removeFromStorage(input.getFurType(), item.getId());
                }
            }

        }while(repeat);

    }
}