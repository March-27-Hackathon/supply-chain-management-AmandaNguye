package edu.ucalgary.ensf409;

import java.io.*;
import java.util.ArrayList;

/**
 * Class to create and format the output file for scenarios
 */
public class Output {
    /**
     * Method that formats and writes the output files of a scenario if the case is
     * possible.
     *
     * @param fileName
     * @param furniture
     * @param type
     * @param count
     * @param arr
     */
    public static void writeFormattedFile(String fileName, String furniture, String type, String count, ArrayList<? extends Furniture> arr) {
        // Write out the file in formatted form
        FileWriter out = null;
        try {
            out = new FileWriter(fileName + ".txt");
            out.write("Furniture Order Form\n\nFaculty Name:\nContact:\nDate:\n");
            out.write("OriginalRequest: " + type + " " + furniture + ", " + count);
            out.write("\nItems Ordered");
            for (int i = 0; i < arr.size() - 1; i++) {
                out.write("ID: " + arr.get(i).getId());
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
    }

    /**
     * Returns the price of all elements in the arraylist
     * @param arr
     * @return lowest price
     */
    private static int getPrice(ArrayList<? extends Furniture> arr)
    {
        int sum = 0;
        for(Furniture obj: arr)
        {
            sum += obj.getPrice();
        }
        return sum;
    }

    /**
     * Method that formats and outputs a scenario to the terminal if the case cannot
     * be possible.
     * 
     * @param type
     * @param count
     * @param itemsOrdered
     * @param price
     */
    public static void writeFormattedTerminal(String furniture, String type, String count, ArrayList<Manufacturer> arr) {
        System.out.println("User request: " + type + " " + furniture + ", " + count);
        System.out.println("Output: Order cannot be fulfilled based on current inventory.");
        System.out.println("SUGGESTED MANUFACTURER(S):");
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i).getName());
        }
    }
}
