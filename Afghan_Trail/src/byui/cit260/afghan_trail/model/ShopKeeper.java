/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.model;

import java.util.Arrays;

/**
 *
 * @author jonsi
 */
public class ShopKeeper extends Player{
    
    private int stats[] = {2,2,2,2}; 
    public ShopKeeper(){
        generateInventory(stats);
    }
}
