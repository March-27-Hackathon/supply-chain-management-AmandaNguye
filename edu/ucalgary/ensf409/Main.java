/**
 * @author Amanda <a href="mailto:amanda.nguyen1@ucalgary.ca"> amanda.nguyen1@ucalgary.ca</a>
 * @author Tyler Tran <a href="mailto:tyler.tran3@ucalgary.ca"> tyler.tran3@ucalgary.ca</a>
 * @author Dat Lam <a href="mailto:dat.lam1@ucalgary.ca">dat.lam1@ucalgary.ca</a>
 * @version 1.6
 * @since 1.0
*/

// TODO
/**
 * JUnit test
 * Finishing UML
 * Youtube
 */

package edu.ucalgary.ensf409;

import java.util.ArrayList;

import javax.swing.JFrame;
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
        int repeat;
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

            arr = rq.request(input.getFurniture(), input.getFurType(), input.getQuantity());
            if(arr==null)
            {
                JOptionPane.showMessageDialog(new JFrame(),"Order cannot be processed");
                Output.unsuccessfulOutput(input.getFurniture(),input.getFurType(),input.getQuantity(),storage.getManufacturerStorage(input.getFurniture()));
            }
            else 
            {
                JOptionPane.showMessageDialog(new JFrame(),"order complete!");
                Output.writeFormattedFile("orderform",input.getFurniture(),input.getFurType(),input.getQuantity(),(ArrayList<Furniture>)arr);
                for(Furniture item: arr)
                {
                    storage.removeFromStorage(input.getFurniture(), item.getId());
                }
            }
            repeat = JOptionPane.showConfirmDialog(null, "Continue?", "Please Select", JOptionPane.YES_OPTION);
        }while(repeat==JOptionPane.YES_OPTION);

    }
}