package edu.ucalgary.ensf409;

import java.sql.*;
import java.util.*;

public class Storage {
    private final String DBURL;
    private final String USERNAME;
    private final String PASSWORD;

    private Connection dbConnect;
    private ResultSet result;

    private HashMap<String, Furniture> chairStorage, deskStorage, filingStorage, lampStorage;
    private HashMap<String, Manufacturer> manufacturerStorage;

    public Storage(String dbUrl, String username, String password)
    {
        this.DBURL = dbUrl;
        this.USERNAME = username;
        this.PASSWORD = password;
        try
        {
            initialize();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }

        chairStorage = populateFurniture("chair");
        deskStorage = populateFurniture("desk");
        filingStorage = populateFurniture("filing");
        lampStorage = populateFurniture("lamp");

    }

    public void initialize() throws SQLException
    {
        dbConnect = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
    }

    public HashMap<String, Furniture> populateFurniture(String tableName)
    {
        HashMap<String, Furniture> tempHashSet = new HashMap<>();
        try
        {
            result = dbConnect.createStatement().executeQuery("SELECT * FROM "+tableName);
            while(result.next())
            {
                Furniture obj = new Furniture(result.getString("ID"),result.getString("Type"),result.getString("ManuID"),result.getInt("Price"));
                if(tableName == "chair")
                {
                    Chair chair = (Chair)obj;
                    chair.setLegs(getBool(result.getString("Legs")));
                    chair.setArms(getBool(result.getString("Arms")));
                    chair.setSeat(getBool(result.getString("Seat")));
                    chair.setCushion(getBool(result.getString("Cushion")));
                    tempHashSet.put(result.getString("ID"),chair);
                }
                else if(tableName == "desk")
                {
                    Desk desk = (Desk)obj;
                    desk.setLegs(getBool(result.getString("Legs")));
                    desk.setTop(getBool(result.getString("Top")));
                    desk.setDrawer(getBool(result.getString("Drawer")));
                    tempHashSet.put(result.getString("ID"),desk);
                }
                else if(tableName == "filing")
                {
                    Filing filing = (Filing)obj;
                    filing.setCabinet(getBool(result.getString("Cabinet")));
                    filing.setDrawers(getBool(result.getString("Drawers")));
                    filing.setRails(getBool(result.getString("Rails")));
                    tempHashSet.put(result.getString("ID"),filing);
                }
                else if(tableName == "lamp")
                {
                    Lamp lamp = (Lamp)obj;
                    lamp.setBase(getBool(result.getString("Base")));
                    lamp.setBulb(getBool(result.getString("Bulb")));
                    tempHashSet.put(result.getString("ID"), lamp);
                }
                else 
                {
                    throw new SQLException();
                }
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }

        return tempHashSet;
    }

    private boolean getBool(String c)
    {
        return c=="Y";
    }

    private void removeFromDatabase(String tableName, String key)
    {
        try
        {
            dbConnect.createStatement().executeQuery("DELETE FROM "+tableName+" WHERE ID = "+key);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
    }

    //--GETTER METHODS--
    public HashMap<String, Furniture> getChairStorage() {
        return chairStorage;
    }

    public HashMap<String, Furniture> getDeskStorage() {
        return deskStorage;
    }

    public HashMap<String, Furniture> getFilingStorage() {
        return filingStorage;
    }

    public HashMap<String, Furniture> getLampStorage() {
        return lampStorage;
    }

    public HashMap<String, Manufacturer> getManufacturerStorage() {
        return manufacturerStorage;
    }

    //--MUTATOR METHODS--
    public void removeFromStorage(String tableName, String id)
    {
        chairStorage.remove(id);
        removeFromDatabase("chair", id);
    }
}
