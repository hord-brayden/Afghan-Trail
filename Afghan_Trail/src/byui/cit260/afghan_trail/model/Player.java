/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.model;
import byui.cit260.afghan_trail.model.Inventory;
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
    private boolean isDead;
    private boolean isSick;
    private long stamina;
    private int capacity;
    public Inventory playerInventory;
    private String playerClass;
    private long healthPoints;
    private BigDecimal money;
    private boolean isWagonBroken;
    private int speed;
    
    public Player() {
        setStamina(100);
        setIsSick(false);
        playerInventory = new Inventory();
    }

    public Player(String name, int capacity, String playerClass) {
        setStamina(100);
        setIsSick(false);
        setIsDead(false);
        this.name = name;
        this.capacity = capacity;
        this.playerClass = playerClass;
        playerInventory = new Inventory();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIsDead() {
        return isDead;
    }

    public void setIsDead(boolean isDead) {
        this.isDead = isDead;
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }



    public Inventory getPlayerInventory() {
        return playerInventory;
    }

    public void setPlayerInventory(Inventory playerInventory) {
        this.playerInventory = playerInventory;
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
  
    public int  getSpeed(){ return speed; }
    
    public void setSpeed(int speed){
        if (speed < 1)
            speed = 1;
        this.speed = speed;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + (this.isSick ? 1 : 0);
        hash = 71 * hash + (int) (this.stamina ^ (this.stamina >>> 32));
        hash = 71 * hash + this.capacity;
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
        if (this.isDead != other.isDead) {
            return false;
        }
        if (this.isSick != other.isSick) {
            return false;
        }
        if (this.stamina != other.stamina) {
            return false;
        }
        if (this.capacity != other.capacity) {
            return false;
        }
        if (this.healthPoints != other.healthPoints) {
            return false;
        }
        if (this.isWagonBroken != other.isWagonBroken) {
            return false;
        }
        if (this.speed != other.speed) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.playerClass, other.playerClass)) {
            return false;
        }
        if (!Objects.equals(this.playerInventory, other.playerInventory)) {
            return false;
        }
        if (!Objects.equals(this.money, other.money)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", isDead=" + isDead + ", isSick=" + isSick + ", stamina=" + stamina + ", capacity=" + capacity + ", playerInventory=" + playerInventory + ", playerClass=" + playerClass + ", healthPoints=" + healthPoints + ", money=" + money + ", isWagonBroken=" + isWagonBroken + ", speed=" + speed + '}';
    }

    public Item generateRandomItem(int typeInt){
        
        double money = Math.ceil(Math.random() * 5);
        BigDecimal price = new BigDecimal(money);
        
        int ind = (int) Math.floor(Math.random() * 5);
        String name = Item.itemTypes[typeInt][ind];
        
        Item newItem = new Item(name, typeInt, price);
        return newItem;
    }
  
    public void generateInventory(int stats[]){
        
        //medicine
        for (int i = 0; i < stats[0]; i++){
            Item newItem = generateRandomItem(0);
            playerInventory.addNewItem(newItem);
        }
        //food
        for (int i = 0; i < stats[1]; i++){
            Item newItem = generateRandomItem(1);
            playerInventory.addNewItem(newItem);
        }
        //parts
        for (int i = 0; i < stats[2]; i++){
            Item newItem = generateRandomItem(2);
            playerInventory.addNewItem(newItem);
        }
        //ammo
        for (int i = 0; i < stats[3]; i++){
            Item newItem = generateRandomItem(3);
            playerInventory.addNewItem(newItem);
        }
    }
    
    public void showStats(){
        System.out.print("\n");
        System.out.print("Name: " + getName() + "\n");
        System.out.print("Type: " + getPlayerClass() + "\n");
        System.out.print("Health: " + ((isIsSick()) ? "Sick":"Good") + "\n");
        System.out.print("Stamina: " + getStamina() + "\n");
        System.out.print("Speed: " + getSpeed() + "\n\n");
        System.out.print("Wagon: " + ((isIsWagonBroken()) ? "Broken":"Good") + "\n");

        playerInventory.display();
        System.out.print("\n");
    }
    
}
