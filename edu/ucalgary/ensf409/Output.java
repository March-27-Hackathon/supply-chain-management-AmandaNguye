package edu.ucalgary.ensf409;

import java.io.*;

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
     * @param itemsOrdered
     * @param price
     */
    public static void writeFormattedFile(String fileName, String furniture, String type, String count,
            String[] itemsOrdered, int price) {
        // Write out the file in formatted form
        FileWriter out = null;
        try {
            out = new FileWriter(fileName + ".txt");
            out.write("Furniture Order Form\n\nFaculty Name:\nContact:\nDate:\n");
            out.write("OriginalRequest: " + type + " " + furniture + ", " + count);
            out.write("\nItems Ordered");
            for (int i = 0; i < itemsOrdered.length - 1; i++) {
                out.write("ID: " + itemsOrdered[i]);
            }
            out.write("Total Price: $" + price);
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
     * Method that formats and outputs a scenario to the terminal if the case cannot
     * be possible.
     * 
     * @param type
     * @param count
     * @param itemsOrdered
     * @param price
     */
    public static void writeFormattedTerminal(String furniture, String type, String count, String[] manufacturers) {
        System.out.println("User request: " + type + " " + furniture + ", " + count);
        System.out.print("Output: Order cannot be fulfilled based on current inventory. Suggested manufacturer(s) are "
                + manufacturers[0]);
        for (int i = 1; i < manufacturers.length - 1; i++) {
            System.out.print(", " + manufacturers[i]);
        }
        System.out.print(", and " + manufacturers[manufacturers.length]);
    }
}
