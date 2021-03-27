package edu.ucalgary.ensf409;

import java.sql.*;
import java.util.LinkedList;

public class OutputRequest {
    private final String DBURL;
    private final String USERNAME;
    private final String PASSWORD;

    private Connection dbConnect;
    private ResultSet result;

    public OutputRequest(String dbUrl, String username, String password) {
        this.DBURL = dbUrl;
        this.USERNAME = username;
        this.PASSWORD = password;
        try {
            initialize();
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void initialize() throws SQLException {
        dbConnect = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
    }

    public OutputRequest find(InputOrder orderInfo) throws SQLException {
        result = dbConnect.createStatement().executeQuery(
                "SELECT COUNT(*) FROM " + orderInfo.getFurniture() + " WHERE Type='" + orderInfo.getFurType());
        // + "' ORDER BY ID LIMIT 1 OFFSET ?"
        result.beforeFirst();
        findValid(1);
        return null;
    }

    private void findValid(int index) throws SQLException {
        LinkedList<Integer> stagedIndices = new LinkedList<Integer>();
        result.absolute(index);
        stagedIndices.add(result.getRow());
        if (result.isAfterLast()) {
            stagedIndices.remove();
            return;
        }
        if (stagedIsValid(stagedIndices)) {
            return;
        } else {
            for (int i = 0; i < array.length; i++) {
                
            }
            findValid(index + 1);
        }
    }

    private boolean stagedIsValid(LinkedList<Integer> stagedIndices) throws SQLException {
        boolean[] parts = new boolean[result.getMetaData().getColumnCount() - 4];
        // default values are false

        for (int i = 0; i < stagedIndices.size(); i++) {
            result.absolute(i);
            for (int j = 2; j < result.getMetaData().getColumnCount(); j++) {
                if (result.getString(j).equals("Y")) {
                    parts[i] = true;
                }
            }
        }
        for (int i = 0; i < parts.length; i++) {
            if (parts[i] == false) {
                return false;
            }
        }
        return true;
    }

}
