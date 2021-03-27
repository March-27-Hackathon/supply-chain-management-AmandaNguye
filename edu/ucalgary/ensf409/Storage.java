/**
 * @author Tyler Tran <a href="mailto:tyler.tran3@ucalgary.ca"> tyler.tran3@ucalgary.ca</a>
 * @version 1.5
 * @since 1.0
*/

/**
 * Storage reads all tables in the SQL database and stores the data as objects into
 * hashmaps which then can be easily used by other classes. Methods are provided to easily access each
 * hashmap and easily remove any element from each map and database
 */

package edu.ucalgary.ensf409;

import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class Storage {
    private final String DBURL="jdbc:mysql://localhost/inventory";
    private final String USERNAME;
    private final String PASSWORD;

    private Connection dbConnect;
    private ResultSet result;

    private ArrayList<Chair> chairStorage;
    private ArrayList<Desk> deskStorage;
    private ArrayList<Filing> filingStorage;
    private ArrayList<Lamp> lampStorage;
    private ArrayList<Manufacturer> manufacturerStorage;

    public Storage(String username, String password)
    {
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

        chairStorage = populateFurniture("chair",Chair.class);
        deskStorage = populateFurniture("desk",Desk.class);
        filingStorage = populateFurniture("filing",Filing.class);
        lampStorage = populateFurniture("lamp",Lamp.class);
        manufacturerStorage = populateManufacturer();
    }

    public void initialize() throws SQLException
    {
        dbConnect = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
    }

    public <T extends Furniture> ArrayList<T> populateFurniture(String tableName, Class<T> type)
    {
        ArrayList<T> arr = new ArrayList<>();
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
                    arr.add(type.cast(chair));
                }
                else if(tableName == "desk")
                {
                    Desk desk = (Desk)obj;
                    desk.setLegs(getBool(result.getString("Legs")));
                    desk.setTop(getBool(result.getString("Top")));
                    desk.setDrawer(getBool(result.getString("Drawer")));
                    arr.add(type.cast(desk));
                }
                else if(tableName == "filing")
                {
                    Filing filing = (Filing)obj;
                    filing.setCabinet(getBool(result.getString("Cabinet")));
                    filing.setDrawers(getBool(result.getString("Drawers")));
                    filing.setRails(getBool(result.getString("Rails")));
                    arr.add(type.cast(filing));
                }
                else if(tableName == "lamp")
                {
                    Lamp lamp = (Lamp)obj;
                    lamp.setBase(getBool(result.getString("Base")));
                    lamp.setBulb(getBool(result.getString("Bulb")));
                    arr.add(type.cast(lamp));
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

        return arr;
    }

    public ArrayList<Manufacturer> populateManufacturer()
    {
        ArrayList<Manufacturer> arr = new ArrayList<>();
        try
        {
            result = dbConnect.createStatement().executeQuery("SELECT * FROM manufacturer");

            while(result.next())
            {
                arr.add(new Manufacturer(
                    result.getString("ManuID"), 
                    result.getString("Name"), 
                    result.getString("Name"), 
                    result.getString("Province")));
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }

        return arr;
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
    public ArrayList<Chair>  getChairStorage() {
        return chairStorage;
    }

    public ArrayList<Desk>  getDeskStorage() {
        return deskStorage;
    }

    public ArrayList<Filing> getFilingStorage() {
        return filingStorage;
    }

    public ArrayList<Lamp>  getLampStorage() {
        return lampStorage;
    }

    public ArrayList<Manufacturer> getManufacturerStorage() {
        return manufacturerStorage;
    }

    public ArrayList<Chair> getChairStorage(String type)
    {
        ArrayList<Chair> arr = new ArrayList<>();
        arr.addAll(chairStorage.stream().filter(c -> c.getType() == type).collect(Collectors.toList()));
        return arr;
    }

    public ArrayList<Desk> getDeskStorage(String type)
    {
        ArrayList<Desk> arr = new ArrayList<>();
        arr.addAll(deskStorage.stream().filter(c -> c.getType() == type).collect(Collectors.toList()));
        return arr;
    }

    public ArrayList<Filing> getFilingStorage(String type)
    {
        ArrayList<Filing> arr = new ArrayList<>();
        arr.addAll(filingStorage.stream().filter(c -> c.getType() == type).collect(Collectors.toList()));
        return arr;
    }

    //--MUTATOR METHODS--
    public void removeFromStorage(String tableName, String id)
    {
        if(tableName=="chair")
        {
            for(int i = 0; i < chairStorage.size(); i++)
            {
                if(chairStorage.get(i).equals(id))
                {
                    chairStorage.remove(i);
                    return;
                }
            }
        }
        else if(tableName=="desk")
        {
            for(int i = 0; i < deskStorage.size(); i++)
            {
                if(deskStorage.get(i).getId().equals(id))
                {
                    deskStorage.remove(i);
                    break;
                }
            }
        }
        else if(tableName == "filing")
        {
            for(int i = 0; i < filingStorage.size(); i++)
            {
                if(filingStorage.get(i).getId().equals(id))
                {
                    filingStorage.remove(i);
                    break;
                }
            }
        }
        else if(tableName == "lamp")
        {
            for(int i = 0; i < lampStorage.size(); i++)
            {
                if(lampStorage.get(i).getId().equals(id))
                {
                    lampStorage.remove(i);
                    break;
                }
            }
        }
        else if(tableName == "manufacturer")
        {
            for(int i = 0; i < manufacturerStorage.size(); i++)
            {
                if(manufacturerStorage.get(i).getManuId().equals(id))
                {
                    manufacturerStorage.remove(i);
                    break;
                }
            }
        }
        removeFromDatabase(tableName, id);
    }
}
