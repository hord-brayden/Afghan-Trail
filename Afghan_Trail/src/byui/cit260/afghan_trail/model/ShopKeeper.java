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
public class ShopKeeper{

    public static void shopKeeper(Player player, char shopKeeperChar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Item inventoryItems[] = new Item[4];
    
    public ShopKeeper() {
        
    }
    
    /*
    public Item[] getInventoryItems(){
        
    }
    */
    
    public void setInventoryItems(Item[] inventoryItems){
        //set invetory to this.inventory
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Arrays.deepHashCode(this.inventoryItems);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ShopKeeper other = (ShopKeeper) obj;
        if (!Arrays.deepEquals(this.inventoryItems, other.inventoryItems)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ShopKeeper{" + "inventoryItems=" + inventoryItems + '}';
    }
    
    
    //TODO
    //buy()
    //sell()
    //leave()
    
    
    
    
}
