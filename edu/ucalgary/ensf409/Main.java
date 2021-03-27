/**
 * @author Amanda <a href="mailto:amanda.nguyen1@ucalgary.ca"> amanda.nguyen1@ucalgary.ca</a>
 * @version 1.0
 * @since 1.0
*/
package edu.ucalgary.ensf409;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your Funiture Category:");
        String category = reader.readLine();
        System.out.println("Enter your furniture type:");
        String type = reader.readLine();
        System.out.println("Enter your furniture count:");
        String count = reader.readLine();

    }
}