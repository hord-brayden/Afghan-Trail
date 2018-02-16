/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.controller;

import byui.cit260.afghan_trail.model.Player;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rizky
 */
public class EnterTownTest {
    int healthPoints;
    int progress;
    boolean expResult;
    
    public EnterTownTest() {
    }

    /**
     * Test of playerEntersTown method, of class EnterTown.
     */
    @Test
    public void testPlayerEntersTown() {
        System.out.println("playerEntersTown");
        
        System.out.println("Test Case 1");
 
        progress = 5;
        healthPoints = 80;
        expResult=true;
        boolean result = EnterTown.playerEntersTown(healthPoints, progress);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        System.out.println("\nTest Case 2");
 
        progress = 10;
        healthPoints = 90;
        expResult=true;
        result = EnterTown.playerEntersTown(healthPoints, progress);
        assertEquals(result, expResult);
        
        System.out.println("\nTest Case 3");
 
        progress = 25;
        healthPoints = 90;
        expResult=false;
        result = EnterTown.playerEntersTown(healthPoints, progress);
        assertEquals(result, expResult);
        
        System.out.println("\nTest Case 4"); 
        progress = 3;
        healthPoints = 0;
        expResult=false;
        result = EnterTown.playerEntersTown(healthPoints, progress);
        assertEquals(result, expResult);
        
        System.out.println("\nTest Case 5");
 
        progress = 0;
        healthPoints = 100;
        expResult=true;
        result = EnterTown.playerEntersTown(healthPoints, progress);
        assertEquals(result, expResult);
        
        System.out.println("\nTest Case 6");
 
        progress = 24;
        healthPoints = 100;
        expResult=true;
        result = EnterTown.playerEntersTown(healthPoints, progress);
        assertEquals(result, expResult);
        
        System.out.println("\nTest Case 7");
 
        progress = 24;
        healthPoints = 5;
        expResult=true;
        result = EnterTown.playerEntersTown(healthPoints, progress);
        assertEquals(result, expResult);
    }
            
        
    
    
}
