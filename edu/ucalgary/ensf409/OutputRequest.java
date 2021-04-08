package edu.ucalgary.ensf409;

import java.sql.*;
import java.io.*;
import java.util.LinkedList;

public class OutputRequest {

    public static void main(String[] args) throws IOException, SQLException {
        // Main Instructions
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputOrder order = new InputOrder();
        System.out.println("Enter your Funiture Category:");
        order.setFurniture(reader.readLine());
        System.out.println("Enter your furniture type:");
        order.setFurType(reader.readLine());
        System.out.println("Enter your furniture count:");
        order.setQuantity(Integer.parseInt(reader.readLine()));
        reader.close();
        OutputRequest dburl = new OutputRequest("jdbc:mysql://localhost/inventory","amanda","ensf409");
        LinkedList<Integer> results = dburl.find(order);
        for(Integer s:results){
            System.out.println(s);
        }

    }

    private final String DBURL;
    private final String USERNAME;
    private final String PASSWORD;

    private Connection dbConnect = null;
    private ResultSet result;
    LinkedList<LinkedList<Integer>> validScenarios = new LinkedList<LinkedList<Integer>>();
    LinkedList<String> scenarioIds = new LinkedList<String>();
    LinkedList<String> manufacturerNames = new LinkedList<String>();
    int count;
    int resultPrice;

    public OutputRequest(String dbUrl, String username, String password) {
        this.DBURL = dbUrl;
        this.USERNAME = username;
        this.PASSWORD = password;
        try {
            dbConnect = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public LinkedList<Integer> find(InputOrder orderInfo) throws SQLException {
        result = dbConnect.createStatement()
                .executeQuery("SELECT * FROM " + orderInfo.getFurniture() + " WHERE Type='" + orderInfo.getFurType());
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
        resultPrice = priceOf(lowestPrice);
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
        int[] parts = new int[result.getMetaData().getColumnCount() - 4];
        // default values are false

        for (int i = 0; i < stagedIndices.size(); i++) {
            result.absolute(i);
            for (int j = 2; j < result.getMetaData().getColumnCount(); j++) {
                if (result.getString(j).equals("Y")) {
                    parts[i]++;
                }
            }
        }
        for (int i = 0; i < parts.length; i++) {
            if (parts[i] < count) {
                return false;
            }
        }
        return true;
    }

    public LinkedList<String> getManufacturers(InputOrder orderInfo) throws SQLException {
        LinkedList<String> manufacturerIds = new LinkedList<String>();
        result = dbConnect.createStatement()
                .executeQuery("SELECT * FROM " + orderInfo.getFurniture() + " WHERE Type='" + orderInfo.getFurType());
        while (result.next()) {
            manufacturerIds.add(result.getString("ManuID"));
        }
        result = dbConnect.createStatement().executeQuery("SELECT * FROM manufacturer");
        while (result.next()) {
            if (manufacturerIds.contains(result.getString("ManuID"))) {
                manufacturerNames.add(result.getString("Name"));
            }
        }
        return manufacturerNames;
    }
}
