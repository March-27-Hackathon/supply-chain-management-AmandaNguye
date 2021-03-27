/**
 * Unit tests for all of the furniture classes + manufacturer classes + ImportOrder
 */
package edu.ucalgary.ensf409;

import org.junit.*;
import static org.junit.Assert.*;


public class FurnitureTest {
    
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

        //test toString funtion
        System.out.println(test);
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
}
