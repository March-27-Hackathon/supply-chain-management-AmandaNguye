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

 /**
  * Package Declaration
  */
package edu.ucalgary.ensf409;

import java.nio.file.FileStore;
/**
 * Import Packages
 */
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class Storage {
    /**
     * Class fields
     */
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
                if(tableName == "chair")
                {
                    Chair chair = new Chair(
                        getBool(result.getString("Legs")), 
                        getBool(result.getString("Arms")), 
                        getBool(result.getString("Seat")), 
                        getBool(result.getString("Cushion")), 
                        result.getString("ID"), 
                        result.getString("Type"), 
                        result.getString("ManuID"), 
                        result.getInt("Price"));
                    arr.add(type.cast(chair));
                }
                else if(tableName == "desk")
                {
                    Desk desk = new Desk(
                        getBool(result.getString("Legs")), 
                        getBool(result.getString("Top")), 
                        getBool(result.getString("Drawer")), 
                        result.getString("ID"), 
                        result.getString("Type"), 
                        result.getString("ManuID"), 
                        result.getInt("Price"));
                    arr.add(type.cast(desk));
                }
                else if(tableName == "filing")
                {
                    Filing filing = new Filing(
                        getBool(result.getString("Rails")), 
                        getBool(result.getString("Drawers")), 
                        getBool(result.getString("Cabinet")), 
                        result.getString("ID"), 
                        result.getString("Type"), 
                        result.getString("ManuID"), 
                        result.getInt("Price"));
                    arr.add(type.cast(filing));
                }
                else if(tableName == "lamp")
                {
                    Lamp lamp = new Lamp(
                        getBool(result.getString("Base")), 
                        getBool(result.getString("Bulb")), 
                        result.getString("ID"), 
                        result.getString("Type"), 
                        result.getString("ManuID"), 
                        result.getInt("Price"));
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
        return c.equals("Y");
    }

    private void removeFromDatabase(String tableName, String key)
    {
        try
        {
            dbConnect.createStatement().execute("DELETE FROM "+tableName+" WHERE ID = "+key);
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
        arr.addAll(chairStorage.stream().filter(c -> c.getType().equals(type)).collect(Collectors.toList()));
        return arr;
    }

    public ArrayList<Desk> getDeskStorage(String type)
    {
        ArrayList<Desk> arr = new ArrayList<>();
        arr.addAll(deskStorage.stream().filter(c -> c.getType().equals(type)).collect(Collectors.toList()));
        return arr;
    }

    public ArrayList<Filing> getFilingStorage(String type)
    {
        ArrayList<Filing> arr = new ArrayList<>();
        arr.addAll(filingStorage.stream().filter(c -> c.getType().equals(type)).collect(Collectors.toList()));
        return arr;
    }

    //--MUTATOR METHODS--
    public void removeFromStorage(String tableName, String id)
    {
        if(tableName.equals("chair"))
        {
            for(Chair chair: chairStorage)
            {
                if(chair.getId().equals(id))
                {
                    chairStorage.remove(chair);
                    break;
                }
            }
        }
        else if(tableName.equals("desk"))
        {
            for(Desk desk: deskStorage)
            {
                if(desk.getId().equals(id))
                {
                    deskStorage.remove(desk);
                    break;
                }
            }
        }
        else if(tableName.equals("filing"))
        {
            for(Filing file: filingStorage)
            {
                if(file.getId().equals(id))
                {
                    filingStorage.remove(file);
                    break;
                }
            }
        }
        else if(tableName.equals("lamp"))
        {
            for(Lamp lamp: lampStorage)
            {
                if(lamp.getId().equals(id))
                {
                    lampStorage.remove(lamp);
                    break;
                }
            }
        }
        else if(tableName.equals("manufacturer"))
        {
            for(Manufacturer manufacturer: manufacturerStorage)
            {
                if(manufacturer.getManuId().equals(id))
                {
                    manufacturerStorage.remove(manufacturer);
                    break;
                }
            }
        }
        //removeFromDatabase(tableName, id);
    }

    public static void main(String[] args) {
        Storage stor = new Storage("tyler", "ensf409");
        for(Chair chair: stor.getChairStorage("Task"))
        {
            System.out.println(chair.getId()+" Type: "+chair.getType()+" Legs: "+chair.getLegs()+" Arms: "+chair.getArms() );
        }
    }
}
