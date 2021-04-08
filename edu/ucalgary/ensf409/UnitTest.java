/** @author Tommy Tran <a 
 * href="mailto:tommy.tran3@ucalgary.ca">tommy.tran3@ucalgary.ca</a>
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
    
    //--FURNITURE TEST--

    //test for Chair class
    @Test
    public void testChair(){
        //test constructor
        Chair test = new Chair(false, true, false, true, "C0194", "Mesh", "002", 50);

        //test setter functions
        test.setArms(false);
        test.setLegs(true);

        //test getter functions
        assertEquals(true,test.getLegs());
        assertEquals(false,test.getArms());
        assertEquals(false,test.getSeat());
        assertEquals(true,test.getCushion());

        //test toString function
        System.out.println(test);
    }
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

    //test for Desk class
    @Test
    public void testDesk(){
        //test constructor
        Desk test = new Desk(false, false, true, "D0890", "Traditional", "002", 25);

        //test setter functions
        test.setLegs(true);
        test.setDrawer(false);

        //test getter functions
        assertEquals(true,test.getLegs());
        assertEquals(false,test.getTop());
        assertEquals(false,test.getDrawer());

        //test toString function
        System.out.println(test);
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

     //test for Filing class
     @Test
     public void testFiling(){
         //test constructor
         Filing test = new Filing(true, true, false, "F001", "Small", "005", 50);
 
         //test setter functions
         test.setRails(false);
         test.setDrawers(false);
 
         //test getter functions
         assertEquals(false,test.getRails());
         assertEquals(false,test.getDrawers());
         assertEquals(false,test.getCabinet());

         System.out.println(test);
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

    //test for Lamp class
    @Test
    public void testLamp(){
        //test constructor
        Lamp test = new Lamp(true, false, "L013", "Desk", "004", 18);

        //test setter functions
        test.setBulb(true);

        //test getter functions
        assertEquals(true,test.getBase());
        assertEquals(true,test.getBulb());

        //test for toString function
        System.out.println(test);
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

     //test for Furniture parent class
     @Test
     public void testFurniture(){
         //test constructor
         Furniture test = new Furniture("L013", "Swing arm", "003", 15);
 
         //test setter functions
         test.setId("C3P0");
         test.setPrice(19);
 
         //test getter functions
         assertEquals("C3P0",test.getId());
         assertEquals("Swing arm",test.getType());
         assertEquals("003",test.getManuId());
         assertEquals(19,test.getPrice());
        
         //test toString function
        System.out.println(test);

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

    @Test
    public void testInputOrder(){
        InputOrder test = new InputOrder();
        
        //testing the setter functions of InputOrder
        test.setFurType("small");
        test.setFurniture("filing");
        test.setQuantity(19);
    
        //testing getter functions of InputOrder
        assertEquals("small",test.getFurType());
        assertEquals("filing",test.getFurniture());
        assertEquals(19, test.getQuantity());
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

     @Test
     public void testManufacturer(){
        //test constructor
        Manufacturer test = new Manufacturer("001", "Academic Desks", "236-145-2542", "BC");

        //testing setter functions
        test.setManuId("019");
        test.setPhone("1-800-267-2001");

        //testing getter functions
        assertEquals("019",test.getManuId());
        assertEquals("Academic Desks",test.getName());
        assertEquals("1-800-267-2001",test.getPhone());
        assertEquals("BC",test.getProvince());

        //testing toString function
        System.out.println(test);
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
     @Test
     public void testStorageChairInitialization()
     {
         //MUST BE EDITED BEFORE UNIT TESTING
         String username = "tyler";
         String password = "ensf409";

         assertTrue("Chair not initialized", new Storage(username, password).getChairStorage()!=null);
     }

     @Test
     public void testStorageDeskInitialization()
     {
         //MUST BE EDITED BEFORE UNIT TESTING
         String username = "tyler";
         String password = "ensf409";

         assertTrue("Desk not initialzied", new Storage(username, password).getDeskStorage()!=null);
     }

     @Test
     public void testStorageFilingInitialization()
     {
         //MUST BE EDITED BEFORE UNIT TESTING
         String username = "tyler";
         String password = "ensf409";

         assertTrue("Filing not initialzied", new Storage(username, password).getFilingStorage()!=null);
     }

     @Test
     public void testStorageLampInitialization()
     {
         //MUST BE EDITED BEFORE UNIT TESTING
         String username = "tyler";
         String password = "ensf409";

         assertTrue("Lamp not initialzied", new Storage(username, password).getLampStorage()!=null);
     }

     
     
    
}
