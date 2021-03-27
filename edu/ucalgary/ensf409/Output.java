package edu.ucalgary.ensf409;

import java.io.*;

/**
 * Class to create and format the output file for scenarios
 */
public class Output {
    private String fileName;
    private String requestedFurniture;
    private String requestedType;
    private String requestedCount;
    private String[] itemsOrdered;
    private int price;

    /**
     * Constructor
     * 
     * @param fileName
     * @param furniture
     * @param type
     * @param count
     * @param itemsOrdered
     * @param price
     */
    public Output(String fileName, String furniture, String type, String count, String[] itemsOrdered, int price) {
        this.fileName = fileName;
        this.requestedFurniture = furniture;
        this.requestedType = type;
        this.requestedCount = count;
        this.itemsOrdered = itemsOrdered;
        this.price = price;
    }

    /**
     * Method that formats and writes the output files of a scenario
     */
    public void writeFile() {
          // Write out the file in formatted form
        FileWriter out = null;
        try {
            out = new FileWriter(fileName + ".txt");
            out.write("Furniture Order Form\n\nFaculty Name:\nContact:\nDate:\n");
            out.write("OriginalRequest: " + requestedType + " " + requestedFurniture + ", " + requestedCount);
            out.write("\nItems Ordered");
            for (int i = 0; i < itemsOrdered.length; i++) {
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

}
