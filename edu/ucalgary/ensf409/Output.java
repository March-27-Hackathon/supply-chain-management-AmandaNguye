/** @author Amanda Nguyen <a href="mailto:amanda.nguyen1@ucalgary.ca">amanda.nguyen1@ucalgary.ca</a>
 * @version  1.1
 * @since    1.0 
 */

package edu.ucalgary.ensf409;

import java.io.*;
import java.util.ArrayList;

/**
 * Class to create and format the output file for scenarios
 */
public class Output {
    private static int orderId = 0;
    /**
     * Method that formats and writes the output files of a scenario if the case is
     * possible.
     *
     * @param fileName  String
     * @param furniture String
     * @param type      String
     * @param count     int
     * @param arr       ArrayList<Furniture>
     */
    public static void successfulInput(String fileName, String furniture, String type, int count,
            ArrayList<Furniture> arr) {
        // Write out the file in formatted form
        FileWriter out = null;
        try {
            out = new FileWriter(fileName + String.format("%03d.txt",orderId++));
            out.write("Furniture Order Form\n\nFaculty Name:\nContact:\nDate:\n");
            out.write("OriginalRequest: " + type + " " + furniture + ", " + count);
            out.write("\nItems Ordered\n");
            for (int i = 0; i < arr.size(); i++) {
                out.write("ID: " + arr.get(i).getId() + "\n");
            }
            out.write("Total Price: $" + getPrice(arr));
        } catch (Exception e) {
            System.err.println("I/O error writing to output file " + fileName + ".");
            System.err.println(e.toString());
            System.exit(1);
        }
        // Try to close an output file, exit(1) if not possible
        if (out != null) {
            try {
                out.close();
            } catch (Exception e) {
                System.err.println("I/O error closing output file " + fileName + ".");
                System.err.println(e.toString());
                System.exit(1);
            }
        }
        // Terminal Output
        System.out.println("User request: " + type + " " + furniture + ", " + count);
        System.out.println("Purchased: ");
        for (int i = 0; i < arr.size(); i++) {
            System.out.println("\t" + arr.get(i).getId());
        }
        System.out.println("Total Price: $" + getPrice(arr));
    }

    /**
     * Returns the price of all elements in the arraylist
     * 
     * @param arr ArrayList<Furniture>
     * @return int of lowest price
     */
    private static int getPrice(ArrayList<? extends Furniture> arr) {
        int sum = 0;
        for (Furniture obj : arr) {
            sum += obj.getPrice();
        }
        return sum;
    }

    /**
     * Method that formats and outputs a scenario to the terminal if the case cannot
     * be possible.
     * 
     * @param furniture    String
     * @param type         String
     * @param count        int
     * @param itemsOrdered ArrayList<Furniture>
     */
    public static void unsuccessfulOutput(String furniture, String type, int count, ArrayList<Manufacturer> arr) {
        // Terminal Output
        System.out.println("User request: " + type + " " + furniture + ", " + count);
        System.out.println("Output: Order cannot be fulfilled based on current inventory.");
        System.out.println("SUGGESTED MANUFACTURER(S):");
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i).getName());
        }
    }
}
