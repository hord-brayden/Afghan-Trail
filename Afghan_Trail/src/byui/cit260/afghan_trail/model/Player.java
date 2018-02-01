/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.model;
import java.util.Arrays;
import java.util.Objects;
import java.math.BigDecimal;
import java.io.Serializable;
//TODO import item class

/**
 *
 * @author jonsi
 */
public class Player implements Serializable {
    private String name;
    private boolean isSick;
    private long stamina;
    private int numOfItems;
    private Item inventoryItems[] = new Item[numOfItems];
    private String playerClass;
    private long healthPoints;
    private BigDecimal money;
    private boolean isWagonBroken;
    
    public Player() {
        setStamina(100);
        setIsSick(false);
    }

    public Player(String name, int numOfItems, String playerClass) {
        setStamina(100);
        setIsSick(false);
        this.name = name;
        this.numOfItems = numOfItems;
        this.playerClass = playerClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIsSick() {
        return isSick;
    }

    public void setIsSick(boolean isSick) {
        this.isSick = isSick;
    }

    public long getStamina() {
        return stamina;
    }

    public void setStamina(long stamina) {
        this.stamina = stamina;
    }

    public int getNumOfItems() {
        return numOfItems;
    }

    public void setNumOfItems(int numOfItems) {
        this.numOfItems = numOfItems;
    }

    public Item[] getInventoryItems() {
        return inventoryItems;
    }

    public void setInventoryItems(Item[] inventoryItems) {
        this.inventoryItems = inventoryItems;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    public long getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(long healthPoints) {
        this.healthPoints = healthPoints;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public boolean isIsWagonBroken() {
        return isWagonBroken;
    }

    public void setIsWagonBroken(boolean isWagonBroken) {
        this.isWagonBroken = isWagonBroken;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + (this.isSick ? 1 : 0);
        hash = 71 * hash + (int) (this.stamina ^ (this.stamina >>> 32));
        hash = 71 * hash + this.numOfItems;
    //  hash = 71 * hash + Arrays.deepHashCode(this.inventoryItems);
        hash = 71 * hash + Objects.hashCode(this.playerClass);
        hash = 71 * hash + (int) (this.healthPoints ^ (this.healthPoints >>> 32));
        hash = 71 * hash + Objects.hashCode(this.money);
        hash = 71 * hash + (this.isWagonBroken ? 1 : 0);
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
        final Player other = (Player) obj;
        if (this.isSick != other.isSick) {
            return false;
        }
        if (this.stamina != other.stamina) {
            return false;
        }
        if (this.numOfItems != other.numOfItems) {
            return false;
        }
        if (this.healthPoints != other.healthPoints) {
            return false;
        }
        if (this.isWagonBroken != other.isWagonBroken) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.playerClass, other.playerClass)) {
            return false;
        }
        if (!Arrays.deepEquals(this.inventoryItems, other.inventoryItems)) {
            return false;
        }
        if (!Objects.equals(this.money, other.money)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", isSick=" + isSick + ", stamina=" + stamina + ", numOfItems=" + numOfItems + ", inventoryItems=" + inventoryItems + ", playerClass=" + playerClass + ", healthPoints=" + healthPoints + ", money=" + money + ", isWagonBroken=" + isWagonBroken + '}';
    }
  
    
    
    
    
}
