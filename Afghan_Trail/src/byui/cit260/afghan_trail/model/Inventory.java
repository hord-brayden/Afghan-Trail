/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.model;
import byui.cit260.afghan_trail.model.Item;
import java.lang.Math;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author jonsi
 */
public class Inventory {
    private int capacity = 12;
    private ArrayList<Item> inventoryItems = new ArrayList<Item>(12); 
    
    public Inventory(){
    }
    
    public Inventory(int capacity){
        this.capacity = 12;
        inventoryItems.ensureCapacity(capacity);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ArrayList<Item> getInventoryItems() {
        return inventoryItems;
    }

    public void setInventoryItems(ArrayList<Item> inventoryItems) {
        this.inventoryItems = inventoryItems;
    }
    
    public void addNewItem(Item item){
        inventoryItems.add(item);
    }
    
    public Item removeRandomItem(){
        if (inventoryItems.size() > 0){
            int rand = (int) Math.floor(Math.random() * inventoryItems.size());
            Item removedItem = inventoryItems.get(rand);
            inventoryItems.remove(rand);
            return removedItem;
        } else {
            return null;
        }
    }
    
    public Item removeItemOfType(String type){
        Item removedItem = null;
        if (inventoryItems.size() > 0 && hasItemType(type))
        {
            Item lastItemOfType = null;
            Iterator<Item> iterator = inventoryItems.iterator();
            while (iterator.hasNext()) {
                Item thisItem = iterator.next();
                if (thisItem.getType() == type)
                    lastItemOfType = thisItem;
            }
            if (lastItemOfType != null){
                removedItem = lastItemOfType;
                inventoryItems.remove(lastItemOfType);
            }
        }
        return removedItem;
    }
    
    public void removeItem(Item item){
        inventoryItems.remove(item);
    }

    @Override
    public String toString() {
        return "Inventory{" + "capacity=" + capacity + ", inventoryItems=" + inventoryItems + '}';
    } 
    
    public void display(){
        System.out.print("Inventory: \n");
        Iterator<Item> iterator = inventoryItems.iterator();
 
        // while loop
        while (iterator.hasNext()) {
            Item thisItem = iterator.next();
            thisItem.display();
        }
    }
    
    public boolean hasItemType(String type){
        Iterator<Item> iterator = inventoryItems.iterator();
        boolean hasParts = false;
        while (iterator.hasNext()) {
            Item thisItem = iterator.next();
            String itemType = thisItem.getType();
            if (itemType == type)
                hasParts = true;
        }
        return hasParts;
    }
    
    public int getNumberOfItemsOfType(String type){
        Iterator<Item> iterator = inventoryItems.iterator();
        int numOfItems = 0;
        for (Item item : inventoryItems){
            String itemType = item.getType();
            if (itemType == type)
                numOfItems++;
        }
        return numOfItems;
        /*
        while (iterator.hasNext()) {
            Item thisItem = iterator.next();
            String itemType = thisItem.getType();
            if (itemType == type)
                numOfItems++;
        }
        return numOfItems;
        */
    }
    
    
    
}
