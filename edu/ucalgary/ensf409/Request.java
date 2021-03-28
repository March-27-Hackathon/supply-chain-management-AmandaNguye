/**
 * @author Dat Lam
 *         <a href="mailto:dat.lam1@ucalgary.ca">dat.lam1@ucalgary.ca</a>
 * @version 1.2
 * @since 1.1
 * 
 */

package edu.ucalgary.ensf409;

import java.util.ArrayList;

public class Request {

    private Storage storage;

    public Request(Storage storage)
    {
        this.storage = storage;
    }

    public ArrayList<? extends Furniture> request(String furniture, String type)
    {
        switch(furniture.toLowerCase())
        {
            case "chair":
                //List only contain chair of that type
                ArrayList<Chair> chairList = new ArrayList<Chair>();
                for(int i = 0; i < storage.getChairStorage().size(); i++)
                {
                    if(storage.getChairStorage().get(i).getType().equals(type))
                    {
                        chairList.add(storage.getChairStorage().get(i));
                    }
                }
                return requestChair(chairList);
            case "desk":
                //List only contain desk of that type
                ArrayList<Desk> deskList = new ArrayList<Desk>();
                for(int i = 0; i < storage.getDeskStorage().size(); i++)
                {
                    if(storage.getDeskStorage().get(i).getType().equals(type))
                    {
                        deskList.add(storage.getDeskStorage().get(i));
                    }
                }
                return requestDesk(deskList);
            case "filing":
                //List only contain filing of that type
                ArrayList<Filing> filingList = new ArrayList<Filing>();
                for(int i = 0; i < storage.getFilingStorage().size(); i++)
                {
                    if(storage.getFilingStorage().get(i).getType().equals(type))
                    {
                        filingList.add(storage.getFilingStorage().get(i));
                    }
                }
                return requestFiling(filingList);
            case "lamp":
                //List only contain desk of that type
                ArrayList<Lamp> lampList = new ArrayList<Lamp>();
                for(int i = 0; i < storage.getLampStorage().size(); i++)
                {
                    if(storage.getLampStorage().get(i).getType().equals(type))
                    {
                        lampList.add(storage.getLampStorage().get(i));
                    }
                }
                return requestLamp(lampList);
            default:
                throw new IllegalArgumentException();
        }
    }

    /**
     * Calculate and returnt the combined price of the items in the paramater
     * @param furnitures
     * @return price of all the item in the ArrayList
     */
    private static int priceOf(ArrayList<? extends Furniture> furnitures)
    {
        int total = 0;
        for(Furniture c: furnitures)
        {
            total += c.getPrice();
        }
        return total;
    }

    /**
     * Check wether or not the combination of chair will make a valid chair
     * @param chairs
     * @return if the combination of chair can make a valid chair
     */
    private boolean checkChairs(ArrayList<Chair> chairs)
    {
        boolean legs = false, arms = false, 
            seat = false, cushion = false;
        for(Chair c: chairs)
        {
            legs = legs || c.getLegs();
            arms = arms || c.getArms();
            cushion = cushion || c.getCushion();
            seat = seat || c.getSeat();
        }

        return legs && arms && seat && cushion;
    }
    
    /**
     * Make a a request for the lowest price combination of chairs
     * using the list of chairs provided. Then setting the class 
     * variables lowestPrice to it.
     * @param list
     */
    public ArrayList<Chair> requestChair(ArrayList<Chair> list)
    {
        ArrayList<ArrayList<Chair>> correctList = new ArrayList<ArrayList<Chair>>();
        ArrayList<Chair> temp;
        for(int i = 0; i < list.size(); i ++)
        {
            temp = new ArrayList<Chair>();
            temp.add(list.get(i));
            if(checkChairs(temp))
            {
                correctList.add((ArrayList<Chair>)temp.clone());
            }
            for(int j = i+1; j < list.size(); j ++)
            {
                temp.add(list.get(i));
                if(checkChairs(temp))
                {
                    correctList.add((ArrayList<Chair>)temp.clone());
                    temp.remove(temp.size()-1);
                }
            }
        }

        int lowest = priceOf(correctList.get(0));
        ArrayList<Chair> lowestChairs = new ArrayList<Chair>();
        for(int i = 1; i < list.size(); i++)
        {
            if(lowest > priceOf(correctList.get(i)))
            {
                lowest = priceOf(correctList.get(i));
                lowestChairs = correctList.get(i);
            }   
        }
        return lowestChairs;
    }


    /**
     * Check wether the combination of desk in param desks
     * can be combine into a new desk.
     * @param desks
     * @return if the desks in list "desks" can make a complete desk.
     */
    private boolean checkDesks(ArrayList<Desk> desks)
    {
        boolean legs = false, top = false, 
            drawer = false;
        for(Desk d: desks)
        {
            legs = legs || d.getLegs();
            top = top || d.getTop();
            drawer = drawer || d.getDrawer();
        }

        return legs && top && drawer;
    }

    /**
     * Make a a request for the lowest price combination of desks
     * using the list of desks provided. Then setting the class 
     * variables lowestPrice to it.
     * @param list
     */
    public ArrayList<Desk> requestDesk(ArrayList<Desk> list)
    {
        ArrayList<ArrayList<Desk>> correctList = new ArrayList<ArrayList<Desk>>();
        ArrayList<Desk> temp;
        for(int i = 0; i < list.size(); i ++)
        {
            temp = new ArrayList<Desk>();
            temp.add(list.get(i));
            if(checkDesks(temp))
            {
                correctList.add((ArrayList<Desk>)temp.clone());
            }
            for(int j = i+1; j < list.size(); j ++)
            {
                temp.add(list.get(i));
                if(checkDesks(temp))
                {
                    correctList.add((ArrayList<Desk>)temp.clone());
                    temp.remove(temp.size()-1);
                }
            }
        }

        int lowest = priceOf(correctList.get(0));
        ArrayList<Desk> lowestDesks = new ArrayList<Desk>();
        for(int i = 1; i < list.size(); i++)
        {
            if(lowest > priceOf(correctList.get(i)))
            {
                lowest = priceOf(correctList.get(i));
                lowestDesks = correctList.get(i);
            }   
        }

        return lowestDesks;
    }

    /**
     * Check wether the combination of desk in param filings
     * can be combine into a new filing.
     * @param filings
     * @return if the filings in  list "filings" can make a complete filing.
     */
    private boolean checkFilings(ArrayList<Filing> filings)
    {
        boolean rails = false, drawers = false, 
            cabinet = false;
        for(Filing f: filings)
        {
            rails = rails || f.getRails();
            cabinet = cabinet || f.getCabinet();
            drawers = drawers || f.getDrawers();
        }

        return rails && cabinet && drawers;
    }

    /**
     * Make a a request for the lowest price combination of filings
     * using the list of filings provided. Then setting the class 
     * variables lowestPrice to it.
     * @param list
     */
    public ArrayList<Filing> requestFiling(ArrayList<Filing> list)
    {
        ArrayList<ArrayList<Filing>> correctList = new ArrayList<ArrayList<Filing>>();
        ArrayList<Filing> temp;
        for(int i = 0; i < list.size(); i ++)
        {
            temp = new ArrayList<Filing>();
            temp.add(list.get(i));
            if(checkFilings(temp))
            {
                correctList.add((ArrayList<Filing>)temp.clone());
            }
            for(int j = i+1; j < list.size(); j ++)
            {
                temp.add(list.get(i));
                if(checkFilings(temp))
                {
                    correctList.add((ArrayList<Filing>)temp.clone());
                    temp.remove(temp.size()-1);
                }
            }
        }

        int lowest = priceOf(correctList.get(0));
        ArrayList<Filing> lowestFilings = new ArrayList<Filing>();
        for(int i = 1; i < list.size(); i++)
        {
            if(lowest > priceOf(correctList.get(i)))
            {
                lowest = priceOf(correctList.get(i));
                lowestFilings = correctList.get(i);
            }   

        }

        return lowestFilings;

    }
    
    /**
     * Check wether the combination of desk in param lamps
     * can be combine into a new lamps.
     * @param lamps
     * @return if the lamps in  list "lamps" can make a complete lamp.
     */
    private boolean checkLamps(ArrayList<Lamp> lamps)
    {
        boolean base = false, bulb = false;
        for(Lamp l: lamps)
        {
            base = base || l.getBase();
            bulb = bulb || l.getBulb();
        }

        return base && bulb;
    }

    /**
     * Make a a request for the lowest price combination of lamps
     * using the list of lamps provided. Then setting the class 
     * variables lowestPrice to it.
     * @param list
     */
    public ArrayList<Lamp> requestLamp(ArrayList<Lamp> list)
    {
        ArrayList<ArrayList<Lamp>> correctList = new ArrayList<ArrayList<Lamp>>();
        ArrayList<Lamp> temp;
        for(int i = 0; i < list.size(); i ++)
        {
            temp = new ArrayList<Lamp>();
            temp.add(list.get(i));
            if(checkLamps(temp))
            {
                correctList.add((ArrayList<Lamp>)temp.clone());
            }
            for(int j = i+1; j < list.size(); j ++)
            {
                temp.add(list.get(i));
                if(checkLamps(temp))
                {
                    correctList.add((ArrayList<Lamp>)temp.clone());
                    temp.remove(temp.size()-1);
                }
            }
        }

        int lowest = priceOf(correctList.get(0));
        ArrayList<Lamp> lowestLamps = new ArrayList<Lamp>();
        for(int i = 1; i < list.size(); i++)
        {
            if(lowest > priceOf(correctList.get(i)))
            {
                lowest = priceOf(correctList.get(i));
                lowestLamps = correctList.get(i);
            }   
        }

        return lowestLamps;
    }
}
