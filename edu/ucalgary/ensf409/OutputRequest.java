package edu.ucalgary.ensf409;

import java.sql.*;
import java.util.LinkedList;

public class OutputRequest {
    private final String DBURL;
    private final String USERNAME;
    private final String PASSWORD;

    private Connection dbConnect;
    private ResultSet result;
    LinkedList<LinkedList<Integer>> validScenarios;
    LinkedList<String> scenarioIds;

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

    public LinkedList<Integer> find(InputOrder orderInfo) throws SQLException {
        result = dbConnect.createStatement().executeQuery(
                "SELECT COUNT(*) FROM " + orderInfo.getFurniture() + " WHERE Type='" + orderInfo.getFurType());
        // + "' ORDER BY ID LIMIT 1 OFFSET ?"
        result.beforeFirst();
        LinkedList<Integer> stagedIndices = new LinkedList<Integer>();
        testAdd(1, stagedIndices);
        return findLowest(validScenarios);
    }

    private LinkedList<Integer> findLowest(LinkedList<LinkedList<Integer>> validScenarios) throws SQLException {
        LinkedList<Integer> lowestPrice = validScenarios.get(0);
        for (LinkedList<Integer> eIntegers : validScenarios) {
            if (priceOf(eIntegers) < priceOf(lowestPrice)) {
                lowestPrice = eIntegers;
            }
        }
        return lowestPrice;

    }

    private int priceOf(LinkedList<Integer> scenario) throws SQLException {
        int price = 0;
        for (int j = 0; j < scenario.size(); j++) {
            result.absolute(scenario.get(j));
            price += result.getInt("Price");
        }
        return price;
    }

    private void testAdd(int index, LinkedList<Integer> stagedIndices) throws SQLException {
        result.absolute(index);
        stagedIndices.add(result.getRow());
        if (result.isAfterLast()) {
            stagedIndices.remove();
            stagedIndices.remove();
            return;
        }
        if (stagedIsValid(stagedIndices)) {
            validScenarios.add(new LinkedList<Integer>(stagedIndices));
            stagedIndices.remove();
            testAdd(index++, stagedIndices);
        }
        testAdd(index++, stagedIndices);
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
