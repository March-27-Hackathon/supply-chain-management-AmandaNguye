package edu.ucalgary.ensf409;

import java.util.*;

public class Prototype {
    Storage stor = new Storage("tyler","ensf409");

    ArrayList<Chair> arr = stor.getChairStorage("Task");

    ArrayList<ArrayList<? extends Furniture>> possibleCombinations = new ArrayList<>();

    /**
     * Iterates through and adds
     */
    public void addCombinations()
    {
        for(int i = 0; i < arr.size(); i++)
        {
            ArrayList<Chair> tmp = new ArrayList<>();
            tmp.add(arr.get(i));
            for(int j = i+1; j < arr.size(); j++)
            {
                tmp.add(arr.get(j));
                if(checkCombination(tmp))
                {
                    possibleCombinations.add((ArrayList<Chair>)tmp.clone());
                    tmp.remove(tmp.size()-1);
                }
            }
        }
    }

    /**
     * Checks to see if the current combination is valid
     * @param chairs
     * @return
     */
    private boolean checkCombination(ArrayList<Chair> chairs)
    {
        boolean legs = false, seat = false, arms = false, cushion = false;
        for(Chair chair: chairs)
        {
            legs = legs || chair.getLegs();
            seat = seat || chair.getSeat();
            arms = arms || chair.getArms();
            cushion = cushion || chair.getCushion();
        }
        return legs && seat && arms && cushion;
    }

    /**
     * Display method for the purposes of showing all combination of objects
     */
    public void displayAllCombo()
    {
        int count = 1;
        for(ArrayList<?> combo: possibleCombinations)
        {
            System.out.println("Combo "+count+": ");
            for(Object chair: combo)
            {
                System.out.println(chair);
            }
            System.out.println("");
            count++;
        }
    }

    public ArrayList<ArrayList<? extends Furniture>> getPossibleCombinations() {
        return possibleCombinations;
    }

    public static void main(String[] args) {
        Prototype p = new Prototype();
        p.addCombinations();
        p.displayAllCombo();
    }
}
