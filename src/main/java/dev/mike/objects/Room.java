package dev.mike.objects;

import dev.mike.exceptions.InvalidCharacterPlacement;
import dev.mike.exceptions.InvalidItemPlacement;
import dev.mike.exceptions.InvalidRoomExit;
import dev.mike.utility.Print;

/**
 * Represents a single room in the world
 */
public class Room {
    private String id;
    private String name;
    private String description;

    private Exit[] exits;

    private SingleCharacter[] characters;

    private Item[] items;

    /**
     * Constructs a room
     * @param id of room
     * @param name of room
     * @param description of room
     * @param exits out of the room
     * @throws InvalidRoomExit if exit is invalid
     * @throws InvalidCharacterPlacement if character is in the wrong room
     */
    public Room(String id, String name, String description, Exit[] exits, SingleCharacter[] characters, Item[] items) throws InvalidRoomExit, InvalidCharacterPlacement, InvalidItemPlacement {
        this.id = id;
        this.name = name;
        this.description = description;
        setExits(exits);
        setCharacters(characters);
        setItems(items);
    }

    /**
     * Safeguard to check if an item belongs in their room
     * @param tempItems to check
     * @throws InvalidItemPlacement if item  is in the wrong room
     */
    private void setItems(Item[] tempItems) throws InvalidItemPlacement{
        if (!isObjectNull(tempItems)){
            for (Item item : tempItems){
                if (!item.getFromId().equals(id)){
                    throw new InvalidItemPlacement();
                }
            }
        }

        this.items = tempItems;
    }


    /**
     * Safeguard to check if a character belongs in their room
     * @param tempCharacters  to check
     * @throws InvalidCharacterPlacement if character is in the wrong room
     */
    private void setCharacters(SingleCharacter[] tempCharacters) throws InvalidCharacterPlacement {
        if (!isObjectNull(tempCharacters)) {
            for (SingleCharacter c : tempCharacters) {
                if (!c.getFromId().equals(id)) {
                    throw new InvalidCharacterPlacement();
                }
            }
        }

        this.characters = tempCharacters;
    }

    /**
     * Safeguard to check if an exit is valid
     * @param tempExits exits to check
     * @throws InvalidRoomExit if exit is invalid
     */
    private void setExits(Exit[] tempExits) throws InvalidRoomExit {
        if (!isObjectNull(tempExits)) {
            for (Exit exit : tempExits) {
                if (!exit.getFromId().equals(id)) {
                    Print.n("ID Of room: " + id + " | Invalid From ID: " + exit.getFromId());
                    throw new InvalidRoomExit();
                }
            }
        }

        this.exits = tempExits;
    }

    /**
     * Gets the id of the room
     * @return id of the room
     */
    public String getId(){
        return this.id;
    }

    /**
     * Gets the description of the room
     * @return description of the room
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * Gets the name of the room
     * @return name of the room
     */
    public String getName(){
        return this.name;
    }

    /**
     * Gets exits out of the room
     * @return exits out of the room
     */
    public Exit[] getExits(){
        return this.exits;
    }

    /**
     * Gets all characters within the room
     * @return all characters within the room
     */
    public SingleCharacter[] getCharacters(){
        return this.characters;
    }

    /**
     * Gets all items within the room
     * @return all items within the room
     */
    public Item[] getItems() {return items;}

    /**
     * Gets exit based on the direction
     * @param dir direction
     * @return the exit based on the direction
     */
    public Exit getExit(Direction dir){
        int len = exits.length;
        String direction = dir.direction();
        for (Exit exit : exits) {
            if (exit.getDirection().direction().equals(direction)) {
                return exit;
            }
        }

        return null;
    }

    /**
     * To String Method
     */
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Room: ").append(name).append("\n");
        str.append("id: ").append(id).append("\n");
        str.append("Description: ").append(description).append("\n");


        if (!isObjectNull(exits)) {
            int len = exits.length;
            for (Exit exit : exits) {
                str.append(exit.toString()).append("\n");
            }
        }
        if (!isObjectNull(characters)) {
            str.append("Characters: \n");
            for (SingleCharacter c : characters) {
                str.append(c.toString()).append("\n");
            }
        }
        if (!isObjectNull(items)) {
            str.append("Items: \n");
            for (Item i : items) {
                str.append(i.toString()).append("\n");
            }
        }

        return str.toString();
    }

    /**
     * Returns if object is null or not
     * @param obj to check
     * @return if object is null or not
     */
    private boolean isObjectNull(Object obj){
        return obj == null;
    }
}
