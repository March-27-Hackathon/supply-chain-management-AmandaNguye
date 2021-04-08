/**
 * @author Amanda Nguyen <a href="mailto:amanda.nguyen1@ucalgary.ca">amanda.nguyen1@ucalgary.ca</a>
 * @author Dat Lam <a href="mailto:dat.lam1@ucalgary.ca">dat.lam1@ucalgary.ca</a>
 * @version 2.0
 * @since 1.4
 * 
 */

package edu.ucalgary.ensf409;

import java.util.ArrayList;

public class Request {
    // CLASS FIELDS
    private Storage storage;
    private int count;

    /**
     * Constructor of a Request, takes in the storage, an ArrayList of the inventory.
     */
    public Request(Storage storage) {
        this.storage = storage;
    }

    // CLASS METHODS
    /**
     * Calculate posible combination of furniture that would make a complete
     * furniture of the type, then return the array list of those furnitures.
     * 
     * @param furniture
     * @param type
     * @return Array list of type object that extend from furniture
     */
    public ArrayList<? extends Furniture> request(String furniture, String type, int quantity) {
        count = quantity;
        switch (furniture.toLowerCase()) {
        case "chair":
            // List only contain chair of that type
            ArrayList<Chair> chairList = storage.getChairStorage(type);
            ArrayList<ArrayList<Chair>> validCombinations = new ArrayList<ArrayList<Chair>>();
            findValidChairCombos(chairList, validCombinations);
            ArrayList<Chair> returnChair = findLowestChairCombo(validCombinations);
            return returnChair;
        }
        return null;
    }

    /**
     * Method that tests all of the possible combinations of a certain type of
     * chair by calling its recursive function.
     * 
     * @param list
     * @param valids
     */
    private void findValidChairCombos(ArrayList<Chair> list, ArrayList<ArrayList<Chair>> valids) {
        ArrayList<Chair> staged = new ArrayList<Chair>();
        testChairCombos(0, list, staged, valids);
    }

    /**
     * Method that tests all of the possible combinations of a certain type of
     * chair and adds valid combinations to a list.
     * 
     * @param index  int of list to be added next
     * @param list   ArrayList<Chair> raw list of typed chair
     * @param staged ArrayList<Chair> Chair combination to be tested
     * @param valids ArrayList<ArrayList<Chair>> list of valid Chair combinations
     */
    private void testChairCombos(int index, ArrayList<Chair> list, ArrayList<Chair> staged,
            ArrayList<ArrayList<Chair>> valids) {
        if (index >= list.size()) {
            staged.remove(staged.size() - 1);
            if (staged.size() == 0) {
                return;
            } else {
                int temp = list.indexOf(staged.get(staged.size() - 1));
                staged.remove(staged.size() - 1);
                testChairCombos(temp + 1, list, staged, valids);
            }
        } else {
            staged.add(list.get(index));
            if (isValidChairCombo(staged)) {
                valids.add(new ArrayList<Chair>(staged));
            }
            testChairCombos(index + 1, list, staged, valids);
        }
    }

    /**
     * Method that returns true if the input Chair combination fills the input
     * request.
     * 
     * @param staged ArrayList<Chair> Chair combination to be tested
     * @return boolean of combincation validity
     */
    private boolean isValidChairCombo(ArrayList<Chair> staged) {
        int[] partsToFill = new int[] { 0, 0, 0, 0 };
        for (int i = 0; i < staged.size(); i++) {
            if (staged.get(i).getArms()) {
                partsToFill[0]++;
            }
            if (staged.get(i).getCushion()) {
                partsToFill[1]++;
            }
            if (staged.get(i).getLegs()) {
                partsToFill[2]++;
            }
            if (staged.get(i).getSeat()) {
                partsToFill[3]++;
            }
        }
        for (int j = 0; j < partsToFill.length; j++) {
            if (partsToFill[j] < count) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method that returns the lowest priced Chair combination in a list of Chair
     * combinations.
     * 
     * @param valids ArrayList<ArrayList<Chair>>
     * @return ArrayList<Chair> lowest priced Chair combination
     */
    private ArrayList<Chair> findLowestChairCombo(ArrayList<ArrayList<Chair>> valids) {
        if (valids == null) {
            return null;
        }
        ArrayList<Chair> temp = valids.get(0);
        for (ArrayList<Chair> combo : valids) {
            if (priceOf(combo) < priceOf(temp)) {
                temp = combo;
            }
        }
        return temp;
    }

    /**
     * Method that returns the price of a Furniture list
     * 
     * @param list ArrayList<? extends Furniture>
     * @return int total price of list
     */
    private int priceOf(ArrayList<? extends Furniture> list) {
        int price = 0;
        for (Furniture item : list) {
            price += item.getPrice();
        }
        return price;
    }
}
