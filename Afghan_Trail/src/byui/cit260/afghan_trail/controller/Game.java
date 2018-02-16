/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.controller;
import byui.cit260.afghan_trail.model.Player;
import byui.cit260.afghan_trail.controller.BeingAttacked;
import byui.cit260.afghan_trail.model.Player;
import byui.cit260.afghan_trail.controller.BrokenWagon;
import byui.cit260.afghan_trail.controller.EnterTown;
import java.io.Serializable;

/**
 *
 * @author jonsi
 */
public class Game implements Serializable{
    private int progress;
    Player player;

    public Game() {
        setProgress(1);
    }  

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        //keep progress withing limits
        if (progress < 1)
            progress = 1;
        else if (progress > 25)
            progress = 25;
        
        this.progress = progress;
    }

    public Player getPlayer() {
        return player;
    }
    
    public void setPlayer(Player player){
        this.player = player;
    }
    
    @Override
    public String toString() {
        return "Game{" + "progress=" + progress + ", player=" + 
        player.toString() + "}";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.progress;
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
        final Game other = (Game) obj;
        if (this.progress != other.progress) {
            return false;
        }
        return true;
    }
  
    public void generateEvent(){
        
        //update progress  display
        setProgress(getProgress() + player.getSpeed());
        System.out.print("progress = " + progress + "\n");
        System.out.print("stamina = " + player.getStamina() + "\n");
        
        //check if player has entered town
        if (progress % 5 == 0)
            EnterTown.playerEntersTown(player, progress);
        else{
            //get random on event
            int numOfEvents = 3;
            int eventId = (int) Math.ceil(Math.random() * numOfEvents);
            
            switch(eventId){
                case 1:
                    BeingAttacked.attacked(player);
                break;
                case 2:
                    Hunt.tryHunt(player);
                break;
                case 3:
                    BrokenWagon.brokenWagonComplete(player);
                break;
                default:
                    System.out.print("Non eventful stop on the map\n");
            }
        }
        
        //30% chance of being attacked
//        boolean isAttacked = (((int) Math.ceil(Math.random() * 3)) > 1);
//        if (isAttacked)
//            BeingAttacked.attacked(player);
    }
}
