package edu.ucalgary.ensf409;

import java.sql.*;
import java.util.*;

public class Storage {
    private final String DBURL;
    private final String USERNAME;
    private final String PASSWORD;

    private Connection dbConnect;
    private ResultSet result;

    HashMap<String, Chair> chairStorage;

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
    }

    public void initialize() throws SQLException
    {
        dbConnect = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
    }

    public HashMap<String, Furniture> populateFurniture(String tableName)
    {
        HashMap<String, Furniture> temp = new HashMap<>();
        try
        {
            result = dbConnect.createStatement().executeQuery("SELECT * FROM "+tableName);

            while(result.next())
            {
                temp.put(result.getString("ID"),new Chair())
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
