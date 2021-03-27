package edu.ucalgary.ensf409;

import java.io.*;

public class Output {
    private String fileName;
    private String requestedFurniture;
    private String requestedType;
    private String requestedCount;
    private String[] itemsOrdered;
    private int price;

    public Output(String furniture, String type, String count) {

    }

    public void writeFile() {
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
                System.exit(1);        }
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
