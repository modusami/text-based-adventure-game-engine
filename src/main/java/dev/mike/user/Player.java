package dev.mike.user;

import dev.mike.objects.Item;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a single user playing this game
 */
public class Player implements Serializable {
    private String name; // name of player
    private String currentRoomId; // the room the player is currently in

    private List<Item> inventory; // the items the player holds

    /**
     * Represents a single player starting the game
     * @param name of player
     */
    public Player(String name){
        this.name = name;
        this.currentRoomId = "start";
        this.inventory = new ArrayList<>();
    }

    /**
     * Gets the name of the player
     * @return name of the player
     */
    public String getName(){
        return this.name;
    }

    /**
     * gets the current room id the player is in
     * @return the current room id
     */
    public String getCurrentRoomId(){
        return this.currentRoomId;
    }

    /**
     * Sets the current room id of the player
     * @param tempId of the room the player enters
     */
    public void setCurrentRoomId(String tempId){
        this.currentRoomId = tempId;
    }

    /**
     * Adds an item to the player's list of items
     * @param tempItem the user wants to add to his inventory
     */
    public void addItems(Item tempItem){
        inventory.add(tempItem);
    }

    /**
     * Removes an item from the inventory
     * @param itemId of item
     * @return if item has been removed
     */
    public boolean removeItem(String itemId){
        int index = -1;
        int len = inventory.size();
        for (int i = 0; i < len; i++){
            if (inventory.get(i).getId().equals(itemId)){
                index = i;
                break;
            }
        }
        if (index != -1) {
            inventory.remove(index);
            return true;
        }

        return false;
    }


    /**
     * To string method
     * @return the string representation of a player
     */
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Player name: ").append(name).append("\n");
        str.append("Room currently in: ").append(currentRoomId).append("\n");
        str.append("Items Held: \n");
        if (inventory.isEmpty()){
            str.append("None...");
        }
        else {
            for (Item item : inventory) {
                str.append(item.toString()).append("\n");
            }
        }

        return str.toString();
    }

}

