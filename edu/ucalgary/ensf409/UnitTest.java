/** @author Tommy Tran <a href="mailto:tommy.tran3@ucalgary.ca">tommy.tran3@ucalgary.ca</a>
 * @author Dat Lam <a href="mailto:dat.lam1@ucalgary.ca">dat.lam1@ucalgary.ca</a>
 * @author Tyler Tran <a href="mailto:tyler.tran3@ucalgary.ca"> tyler.tran3@ucalgary.ca</a>
 * @version  1.2
 * @since    1.0 
 */

/**
 * Unit tests for all of the furniture classes + manufacturer classes + ImportOrder
 */
package edu.ucalgary.ensf409;

import org.junit.*;
import static org.junit.Assert.*;

import java.sql.SQLException;


public class UnitTest {
    //MUST BE EDITED BEFORE UNIT TESTING
    String username = "tyler";
    String password = "ensf409";
    
    //--FURNITURE TEST--

    /**testing constructor and toString() method for Chair class
    */
    @Test
    public void testChairToString(){
        Chair test = new Chair(false, true, false, true, "C0194", "Mesh", "002", 50); 
        assertTrue("toString method outputted the incorrect String for Chair class", 
        test.toString().equals(
        "Chair Object consists of [Legs: false, Arms: true, Seat: false, Cushion: true, ID: C0194, ManuID: 002, Type: Mesh, Price: 50]"));
    }
    /**testing constructor and setLegs() for Chair class
    */
    @Test
    public void testChairSetLegs(){
        Chair test = new Chair(false, true, false, true, "C0194", "Mesh", "002", 50); 
        test.setLegs(true);
        assertTrue("setLegs method failed for Chair class", test.getLegs() == true);
    }

    /**testing constructor and setArms() for Chair class
    */
    @Test
    public void testChairSetArms(){
        Chair test = new Chair(false, true, false, true, "C0194", "Mesh", "002", 50); 
        test.setArms(false);
        assertTrue("setArms method failed for Chair class", test.getArms() == false);
    }

    /**testing constructor and setSeat() for Chair class
    */
    @Test
    public void testChairSetSeat(){
        Chair test = new Chair(false, true, false, true, "C0194", "Mesh", "002", 50); 
        test.setSeat(true);
        assertTrue("setSeat method failed for Chair class", test.getSeat() == true);
    }

    /**testing constructor and setCushion() for Chair class
    */
    @Test
    public void testChairSetCushion(){
        Chair test = new Chair(false, true, false, true, "C0194", "Mesh", "002", 50); 
        test.setCushion(false);
        assertTrue("setCushion method failed for Chair class", test.getCushion() == false);
    }

    /**testing constructor and toString() method for Desk class
    */
    @Test
    public void testDeskToString(){
        Desk test = new Desk(false, false, true, "D0890", "Traditional", "002", 25);
        assertTrue("toString method outputted the incorrect String for Desk class", 
        test.toString().equals(
        "Desk Object consists of [Legs: false, Top: false, Drawer: true, ID: D0890, ManuID: 002, Type: Traditional, Price: 25]"));
    }

    /**testing constructor and setLegs() for Desk class
    */
    @Test
    public void testDeskSetLegs(){
        Desk test = new Desk(false, false, true, "D0890", "Traditional", "002", 25);
        test.setLegs(true);
        assertTrue("setLegs method failed for Desk class", test.getLegs() == true);
    }

    /**testing constructor and setTop() for Desk class
    */
    @Test
    public void testDeskSetTop(){
        Desk test = new Desk(false, false, true, "D0890", "Traditional", "002", 25);
        test.setTop(true);
        assertTrue("setTop method failed for Desk class", test.getTop() == true);
    }

    /**testing constructor and setLegs() for Desk class
    */
    @Test
    public void testDeskSetDrawer(){
        Desk test = new Desk(false, false, true, "D0890", "Traditional", "002", 25);
        test.setDrawer(false);
        assertTrue("setLegs method failed for Desk class", test.getDrawer() == false);
    }

    /**testing constructor and toString() method for Filing class
    */
    @Test
    public void testFilingToString(){
        Filing test = new Filing(true, true, false, "F001", "Small", "005", 50);
        assertTrue("toString method outputted the incorrect String for Filing class", 
        test.toString().equals(
        "Filing Object consists of [Rails: true, Drawers: true, Cabinet: false, ID: F001, ManuID: 005, Type: Small, Price: 50]"));
    }

    /**testing constructor and setRails() for Filing class
    */
    @Test
    public void testFilingSetRails(){
        Filing test = new Filing(true, true, false, "F001", "Small", "005", 50);
        test.setRails(false);
        assertTrue("setRails method failed for Filing class", test.getRails() == false);
    }

    /**testing constructor and setDrawers() for Filing class
    */
    @Test
    public void testDrawersSetRails(){
        Filing test = new Filing(true, true, false, "F001", "Small", "005", 50);
        test.setDrawers(false);
        assertTrue("setDrawers method failed for Filing class", test.getDrawers() == false);
    }

    /**testing constructor and setCabinet() for Filing class
    */
    @Test
    public void testFilingSetCabinet(){
        Filing test = new Filing(true, true, false, "F001", "Small", "005", 50);
        test.setCabinet(true);
        assertTrue("setCabinet method failed for Filing class", test.getRails() == true);
    }

    /**testing constructor and toString() method for Lamp class
    */
    @Test
    public void testLampToString(){
        Lamp test = new Lamp(true, false, "L013", "Desk", "004", 18);
        assertTrue("toString method outputted the incorrect String for Lamp class", 
        test.toString().equals(
        "Lamp Object consists of [Base: true, Bulb: false, ID: L013, ManuID: 004, Type: Desk, Price: 18]"));
    }

    /**testing constructor and setBase() for Lamp class
    */
    @Test
    public void testLampSetBase(){
        Lamp test = new Lamp(true, false, "L013", "Desk", "004", 18);
        test.setBase(false);
        assertTrue("setBase method failed for Lamp class", test.getBase() == false);
    }

    /**testing constructor and setBulb() for Lamp class
    */
    @Test
    public void testLampSetBulb(){
        Lamp test = new Lamp(true, false, "L013", "Desk", "004", 18);
        test.setBulb(true);
        assertTrue("setBulb method failed for Lamp class", test.getBulb() == true);
    }

    /**testing constructor and toString() method for Furniture class
    */
    @Test
    public void testFurnitureToString(){
        Furniture test = new Furniture("L013", "Swing arm", "003", 15);
        assertTrue("toString method outputted the incorrect String for Furniture class", 
        test.toString().equals(
        "Furniture Object consists of [ID: L013, ManuID: 003, Type: Swing arm, Price: 15]"));
    }

    
    /**testing constructor and setId() for Furniture class
    */
    @Test
    public void testFurnitureSetId(){
        Furniture test = new Furniture("L013", "Swing arm", "003", 15);
        test.setId("C3P0");
        assertTrue("setId method failed for Furniture class", test.getId().equals("C3P0"));
    }

    /**testing constructor and setType() for Furniture class
    */
    @Test
    public void testFurnitureSetType(){
        Furniture test = new Furniture("L013", "Swing arm", "003", 15);
        test.setType("mesh");
        assertTrue("setType method failed for Furniture class", test.getType().equals("mesh"));
    }

    /**testing constructor and setManuId() for Furniture class
    */
    @Test
    public void testFurnitureSetManuId(){
        Furniture test = new Furniture("L013", "Swing arm", "003", 15);
        test.setManuId("004");
        assertTrue("setManuId method failed for Furniture class", test.getManuId().equals("004"));
    }

    /**testing constructor and setPrice() for Furniture class
    */
    @Test
    public void testFurnitureSetPrice(){
        Furniture test = new Furniture("L013", "Swing arm", "003", 15);
        test.setPrice(17);
        assertTrue("setPrice method failed for Furniture class", test.getPrice() == 17);
    }

    /**testing constructor and setFurType() for InputOrder class
    */
    @Test
    public void testInputOrderSetFurType(){
        InputOrder test = new InputOrder();
        test.setFurType("small");
        assertTrue("setFurType method failed for InputOrder class", test.getFurType().equals("small"));
    }

    /**testing constructor and setFurniture() for InputOrder class
    */
    @Test
    public void testInputOrderSetFurniture(){
        InputOrder test = new InputOrder();
        test.setFurniture("filing");
        assertTrue("setFurniture method failed for InputOrder class", test.getFurniture().equals("filing"));
    }

    /**testing constructor and setQuantity() for InputOrder class
    */
    @Test
    public void testInputOrderSetQuantity(){
        InputOrder test = new InputOrder();
        test.setQuantity(17);
        assertTrue("setQuantity method failed for InputOrder class", test.getQuantity() == 17);
    }

    /**testing constructor and toString() method for Manufacturer class
    */
    @Test
    public void testManufacturerToString(){
        Manufacturer test = new Manufacturer("001", "Academic Desks", "236-145-2542", "BC");
        assertTrue("toString method outputted the incorrect String for Manufacturer class", 
        test.toString().equals(
        "Manufacturer Object consists of [ManuID: 001, Name: Academic Desks, Phone: 236-145-2542, Province: BC]"));
    }

    /**testing constructor and setManuId() for Manufacturer class
    */
    @Test
    public void testManufacturerSetManuId(){
        Manufacturer test = new Manufacturer("001", "Academic Desks", "236-145-2542", "BC");
        test.setManuId("003");
        assertTrue("setManuId method failed for Manufacturer class", test.getManuId().equals("003"));
    }

    /**testing constructor and setName() for Manufacturer class
    */
    @Test
    public void testManufacturerSetName(){
        Manufacturer test = new Manufacturer("001", "Academic Desks", "236-145-2542", "BC");
        test.setName("Desks R Us");
        assertTrue("setName method failed for Manufacturer class", test.getName().equals("Desks R Us"));
    }

    /**testing constructor and setPhone() for Manufacturer class
    */
    @Test
    public void testManufacturerSetPhone(){
        Manufacturer test = new Manufacturer("001", "Academic Desks", "236-145-2542", "BC");
        test.setPhone("1800-567-2001");
        assertTrue("setPhone method failed for Manufacturer class", test.getPhone().equals("1800-567-2001"));
    }

    /**testing constructor and setProvince() for Manufacturer class
    */
    @Test
    public void testManufacturerSetProvince(){
        Manufacturer test = new Manufacturer("001", "Academic Desks", "236-145-2542", "BC");
        test.setProvince("AB");
        assertTrue("setProvince method failed for Manufacturer class", test.getProvince().equals("AB"));
    }

     //--STORAGE TEST--
     /**Testing Storage contructor, and that getChairStorage does return Chairs from the database*/
    @Test
    public void testStorageChairInitialization() throws SQLException
    {
        assertTrue("Chair not initialzied", new Storage(username, password).getChairStorage().size()!=0);
    }
    /**Testing Storage contructor, and that getDeskStorage does return Desks from the database*/
    @Test
    public void testStorageDeskInitialization() throws SQLException
    {
        assertTrue("Desk not initialzied", new Storage(username, password).getDeskStorage().size()!=0);
    }

    /**Testing Storage contructor, and that getFilingStorage does return Filings from the database*/
    @Test
    public void testStorageFilingInitialization() throws SQLException
    {
        assertTrue("Filing not initialzied", new Storage(username, password).getFilingStorage().size()!=0);
    }

    /**Testing Storage contructor, and that getLampStorage does return Lamps from the database*/
    @Test
    public void testStorageLampInitialization() throws SQLException
    {
        assertTrue("Lamp not initialzied", new Storage(username, password).getLampStorage().size()!=0);
    }

    /**
     * Testing storage filtered Chair getter to have returned an ArrayList of Chair with type Mesh
     */
    @Test
    public void testStorageChairFiltered() throws SQLException
    {
        assertTrue("Chair filter does not correctly return", new Storage(username, password).getChairStorage("mesh").size()!=0);
    }

    /**Testing Storage filtered Chair getter to have returned an Empty ArrayList with an invalid input*/
    @Test
    public void testStorageChairFilteredFail() throws SQLException
    {
        assertTrue("Chair filter does not correctly return", new Storage(username, password).getChairStorage("me sh").size()==0);
    }

    /**
     * Testing Storage filtered Desk getter to have returned an ArrayList of Desk with type Standing
     */
    @Test
    public void testStorageDeskFiltered() throws SQLException
    {
        assertTrue("Desk filter does not correctly return", new Storage(username, password).getDeskStorage("standing").size()!=0);
    }

    /**Testing Storage filtered Desk getter to have returned an Empty ArrayList with an invalid input*/
    public void testStorageDeskFilteredFail() throws SQLException
    {
        assertTrue("Desk filter does not correctly return", new Storage(username, password).getDeskStorage("stand ing").size()==0);
    }

    /**
     * Testing Storage filtered Filing getter to have returned an ArrayList of Filing with type small
     */
    @Test
    public void testStorageFilingFiltered() throws SQLException
    {
        assertTrue("Filing filter does not correctly return", new Storage(username, password).getFilingStorage("small").size()!=0);
    }

    /**Testing Storage filtered Filing getter to have returned an Empty ArrayList with an invalid input*/
    @Test
    public void testStorageFilingFilteredFail() throws SQLException
    {
        assertTrue("Filing filter does not correctly return", new Storage(username, password).getFilingStorage("sma ll").size()==0);
    }

    /**
     * Testing Storage filtered Lamp getter to have returned an ArrayList of Lamp with type Swing Arm
     */
    @Test
    public void testStorageLampFiltered() throws SQLException
    {
        assertTrue("Lamp filter does not correctly return", new Storage(username, password).getLampStorage("swing arm").size()!=0);
    }

    /**Testing Storage filtered Lamp getter to have returned an Empty ArrayList with an invalid input*/
    @Test
    public void testStorageLampFilteredFail() throws SQLException
    {
        assertTrue("Lamp filter does not correctly return", new Storage(username, password).getLampStorage("sw ing arm").size()==0);
    }
    
    /**Testing is done using the inventory.sql database
     * This test the request class to generate an output for a valid amount of Mesh Chair
     */
    @Test
    public void testRequestChairSuccess() throws SQLException
    {
        Storage stor = new Storage(username, password);
        Request rq = new Request(stor);
        assertTrue("Unable to find a possible combination of chair", rq.request("chair", "mesh", 1).size()!=0);
    }

    /**Testing is done using the inventory.sql database
     * This test the request class to generate an output for a invalid input
     */
    @Test
    public void testRequestChairFail() throws SQLException
    {
        Storage stor = new Storage(username, password);
        Request rq = new Request(stor);
        assertTrue("Unable to find a possible combination of chair", rq.request("chair", "mush", 1)==null);
    }

    
}
