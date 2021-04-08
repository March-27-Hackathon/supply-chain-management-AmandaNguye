/**
 * @author Amanda Nguyen <a href="mailto:amanda.nguyen1@ucalgary.ca">amanda.nguyen1@ucalgary.ca</a>
 * @author Dat Lam <a href="mailto:dat.lam1@ucalgary.ca">dat.lam1@ucalgary.ca</a>
 * @version 1.4
 * @since 1.1
 * 
 */

package edu.ucalgary.ensf409;

import java.util.ArrayList;

public class Request {

    private Storage storage;
    private int count;

    public Request(Storage storage) {
        this.storage = storage;
    }

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

    private void findValidChairCombos(ArrayList<Chair> list, ArrayList<ArrayList<Chair>> valids) {
        ArrayList<Chair> staged = new ArrayList<Chair>();
        findCombos(1, list, staged, valids);
    }

    private void findCombos(int index, ArrayList<Chair> list, ArrayList<Chair> staged,
            ArrayList<ArrayList<Chair>> valids) {
        if (index >= list.size()) {
            staged.remove(staged.size() - 1);
            staged.remove(staged.size() - 1);
            return;
        }
        staged.add(list.get(index));
        if (isValidChairCombo(staged)) {
            valids.add(staged);
        }
        findCombos(index++, list, staged, valids);
    }

    private boolean isValidChairCombo(ArrayList<Chair> staged) {
        int[] partsToFill = new int[4];
        for (int i = 0; i < staged.size(); i++) {
            if (staged.get(i).getArms() == true) {
                partsToFill[0]++;
            }
            if (staged.get(i).getCushion() == true) {
                partsToFill[1]++;
            }
            if (staged.get(i).getLegs() == true) {
                partsToFill[2]++;
            }
            if (staged.get(i).getSeat() == true) {
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

    private ArrayList<Chair> findLowestChairCombo(ArrayList<ArrayList<Chair>> valids) {
        ArrayList<Chair> temp = valids.get(0);
        for(ArrayList<Chair> combo : valids){
            if(priceOf(combo) < priceOf(temp)){
                temp = combo;
            }
        }
        return temp;
    }

    private int priceOf(ArrayList<Chair> list){
        int price = 0;
        for(Chair item : list){
            price += item.getPrice();
        }
        return price;
    }
}
