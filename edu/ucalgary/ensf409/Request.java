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
     * Constructor of a Request, takes in the storage, an ArrayList of the
     * inventory.
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
     * @throws IllegalArgumentException
     * @return Array list of type object that extend from furniture
     */
    public ArrayList<? extends Furniture> request(String furniture, String type, int quantity) throws IllegalArgumentException {
        count = quantity;
        switch (furniture.toLowerCase()) {
            case "chair":
                // List only contain chair of that type
                ArrayList<Chair> chairList = storage.getChairStorage(type);
                if(chairList == null || chairList.isEmpty())
                {
                    throw new IllegalArgumentException();
                }
                ArrayList<ArrayList<Chair>> validChairCombinations = new ArrayList<ArrayList<Chair>>();
                findValidChairCombos(chairList, validChairCombinations);
                ArrayList<Chair> returnChair = findLowestChairCombo(validChairCombinations);
                return returnChair;
            case "desk":
                // List only contain chair of that type
                ArrayList<Desk> deskList = storage.getDeskStorage(type);
                if(deskList == null || deskList.isEmpty())
                {
                    throw new IllegalArgumentException();
                }
                ArrayList<ArrayList<Desk>> validDeskCombinations = new ArrayList<ArrayList<Desk>>();
                findValidDeskCombos(deskList, validDeskCombinations);
                ArrayList<Desk> returnDesk = findLowestDeskCombo(validDeskCombinations);
                return returnDesk;
            case "filing":
                // List only contain filing of that type
                ArrayList<Filing> filingList = storage.getFilingStorage(type);
                if(filingList == null || filingList.isEmpty())
                {
                    throw new IllegalArgumentException();
                }
                ArrayList<ArrayList<Filing>> validFilingCombinations = new ArrayList<ArrayList<Filing>>();
                findValidFilingCombos(filingList, validFilingCombinations);
                ArrayList<Filing> returnFiling = findLowestFilingCombo(validFilingCombinations);
                return returnFiling;
            case "lamp":
                // List only contain lamp of that type
                ArrayList<Lamp> lampList = storage.getLampStorage(type);
                if(lampList == null || lampList.isEmpty())
                {
                    throw new IllegalArgumentException();
                }
                ArrayList<ArrayList<Lamp>> validLampCombinations = new ArrayList<ArrayList<Lamp>>();
                findValidLampCombos(lampList, validLampCombinations);
                ArrayList<Lamp> returnLamp = findLowestLampCombo(validLampCombinations);
                return returnLamp;
            
        }
        return null;
    }

    /**
     * Method that tests all of the possible combinations of a certain type of chair
     * by calling its recursive function.
     * 
     * @param list
     * @param valids
     */
    private void findValidChairCombos(ArrayList<Chair> list, ArrayList<ArrayList<Chair>> valids) {
        ArrayList<Chair> staged = new ArrayList<Chair>();
        testChairCombos(0, list, staged, valids);
    }

    /**
     * Method that tests all of the possible combinations of a certain type of chair
     * and adds valid combinations to a list.
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
        if (valids == null || valids.isEmpty()) {
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
     * Method that tests all of the possible combinations of a certain type of Desk
     * by calling its recursive function.
     * 
     * @param list
     * @param valids
     */
    private void findValidDeskCombos(ArrayList<Desk> list, ArrayList<ArrayList<Desk>> valids) {
        ArrayList<Desk> staged = new ArrayList<Desk>();
        testDeskCombos(0, list, staged, valids);
    }

    /**
     * Method that tests all of the possible combinations of a certain type of Desk
     * and adds valid combinations to a list.
     * 
     * @param index  int of list to be added next
     * @param list   ArrayList<Desk> raw list of typed Desk
     * @param staged ArrayList<Desk> Desk combination to be tested
     * @param valids ArrayList<ArrayList<Desk>> list of valid Desk combinations
     */
    private void testDeskCombos(int index, ArrayList<Desk> list, ArrayList<Desk> staged,
            ArrayList<ArrayList<Desk>> valids) {
        if (index >= list.size()) {
            staged.remove(staged.size() - 1);
            if (staged.size() == 0) {
                return;
            } else {
                int temp = list.indexOf(staged.get(staged.size() - 1));
                staged.remove(staged.size() - 1);
                testDeskCombos(temp + 1, list, staged, valids);
            }
        } else {
            staged.add(list.get(index));
            if (isValidDeskCombo(staged)) {
                valids.add(new ArrayList<Desk>(staged));
            }
            testDeskCombos(index + 1, list, staged, valids);
        }
    }

    /**
     * Method that returns true if the input Desk combination fills the input
     * request.
     * 
     * @param staged ArrayList<Desk> Desk combination to be tested
     * @return boolean of combincation validity
     */
    private boolean isValidDeskCombo(ArrayList<Desk> staged) {
        int[] partsToFill = new int[] { 0, 0, 0 };
        for (int i = 0; i < staged.size(); i++) {
            if (staged.get(i).getDrawer()) {
                partsToFill[0]++;
            }
            if (staged.get(i).getLegs()) {
                partsToFill[1]++;
            }
            if (staged.get(i).getTop()) {
                partsToFill[2]++;
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
     * Method that returns the lowest priced Desk combination in a list of Desk
     * combinations.
     * 
     * @param valids ArrayList<ArrayList<Desk>>
     * @return ArrayList<Desk> lowest priced Desk combination
     */
    private ArrayList<Desk> findLowestDeskCombo(ArrayList<ArrayList<Desk>> valids) {
        if (valids == null || valids.isEmpty()) {
            return null;
        }
        ArrayList<Desk> temp = valids.get(0);
        for (ArrayList<Desk> combo : valids) {
            if (priceOf(combo) < priceOf(temp)) {
                temp = combo;
            }
        }
        return temp;
    }

    /**
     * Method that tests all of the possible combinations of a certain type of
     * Filing by calling its recursive function.
     * 
     * @param list
     * @param valids
     */
    private void findValidFilingCombos(ArrayList<Filing> list, ArrayList<ArrayList<Filing>> valids) {
        ArrayList<Filing> staged = new ArrayList<Filing>();
        testFilingCombos(0, list, staged, valids);
    }

    /**
     * Method that tests all of the possible combinations of a certain type of
     * Filing and adds valid combinations to a list.
     * 
     * @param index  int of list to be added next
     * @param list   ArrayList<Filing> raw list of typed Filing
     * @param staged ArrayList<Filing> Filing combination to be tested
     * @param valids ArrayList<ArrayList<Filing>> list of valid Filing combinations
     */
    private void testFilingCombos(int index, ArrayList<Filing> list, ArrayList<Filing> staged,
            ArrayList<ArrayList<Filing>> valids) {
        if (index >= list.size()) {
            staged.remove(staged.size() - 1);
            if (staged.size() == 0) {
                return;
            } else {
                int temp = list.indexOf(staged.get(staged.size() - 1));
                staged.remove(staged.size() - 1);
                testFilingCombos(temp + 1, list, staged, valids);
            }
        } else {
            staged.add(list.get(index));
            if (isValidFilingCombo(staged)) {
                valids.add(new ArrayList<Filing>(staged));
            }
            testFilingCombos(index + 1, list, staged, valids);
        }
    }

    /**
     * Method that returns true if the input Filing combination fills the input
     * request.
     * 
     * @param staged ArrayList<Filing> Filing combination to be tested
     * @return boolean of combincation validity
     */
    private boolean isValidFilingCombo(ArrayList<Filing> staged) {
        int[] partsToFill = new int[] { 0, 0, 0 };
        for (int i = 0; i < staged.size(); i++) {
            if (staged.get(i).getCabinet()) {
                partsToFill[0]++;
            }
            if (staged.get(i).getDrawers()) {
                partsToFill[1]++;
            }
            if (staged.get(i).getRails()) {
                partsToFill[2]++;
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
     * Method that returns the lowest priced Filing combination in a list of Filing
     * combinations.
     * 
     * @param valids ArrayList<ArrayList<Filing>>
     * @return ArrayList<Filing> lowest priced Filing combination
     */
    private ArrayList<Filing> findLowestFilingCombo(ArrayList<ArrayList<Filing>> valids) {
        if (valids == null || valids.isEmpty()) {
            return null;
        }
        ArrayList<Filing> temp = valids.get(0);
        for (ArrayList<Filing> combo : valids) {
            if (priceOf(combo) < priceOf(temp)) {
                temp = combo;
            }
        }
        return temp;
    }

    /**
     * Method that tests all of the possible combinations of a certain type of Lamp
     * by calling its recursive function.
     * 
     * @param list
     * @param valids
     */
    private void findValidLampCombos(ArrayList<Lamp> list, ArrayList<ArrayList<Lamp>> valids) {
        ArrayList<Lamp> staged = new ArrayList<Lamp>();
        testLampCombos(0, list, staged, valids);
    }

    /**
     * Method that tests all of the possible combinations of a certain type of Lamp
     * and adds valid combinations to a list.
     * 
     * @param index  int of list to be added next
     * @param list   ArrayList<Lamp> raw list of typed Lamp
     * @param staged ArrayList<Lamp> Lamp combination to be tested
     * @param valids ArrayList<ArrayList<Lamp>> list of valid Lamp combinations
     */
    private void testLampCombos(int index, ArrayList<Lamp> list, ArrayList<Lamp> staged,
            ArrayList<ArrayList<Lamp>> valids) {
        if (index >= list.size()) {
            staged.remove(staged.size() - 1);
            if (staged.size() == 0) {
                return;
            } else {
                int temp = list.indexOf(staged.get(staged.size() - 1));
                staged.remove(staged.size() - 1);
                testLampCombos(temp + 1, list, staged, valids);
            }
        } else {
            staged.add(list.get(index));
            if (isValidLampCombo(staged)) {
                valids.add(new ArrayList<Lamp>(staged));
            }
            testLampCombos(index + 1, list, staged, valids);
        }
    }

    /**
     * Method that returns true if the input Lamp combination fills the input
     * request.
     * 
     * @param staged ArrayList<Lamp> Lamp combination to be tested
     * @return boolean of combincation validity
     */
    private boolean isValidLampCombo(ArrayList<Lamp> staged) {
        int[] partsToFill = new int[] { 0, 0 };
        for (int i = 0; i < staged.size(); i++) {
            if (staged.get(i).getBase()) {
                partsToFill[0]++;
            }
            if (staged.get(i).getBulb()) {
                partsToFill[1]++;
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
     * Method that returns the lowest priced Lamp combination in a list of Lamp
     * combinations.
     * 
     * @param valids ArrayList<ArrayList<Lamp>>
     * @return ArrayList<Lamp> lowest priced Lamp combination
     */
    private ArrayList<Lamp> findLowestLampCombo(ArrayList<ArrayList<Lamp>> valids) {
        if (valids == null || valids.isEmpty()) {
            return null;
        }
        ArrayList<Lamp> temp = valids.get(0);
        for (ArrayList<Lamp> combo : valids) {
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
