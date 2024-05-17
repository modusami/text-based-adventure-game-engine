package dev.mike.objects;

import java.io.Serializable;

/**
 * Represents a single item in the data
 */
public class Item implements Serializable {
    private String id;
    private String fromId; // id of room where item lays
    private String name;
    private String description;

    /**
     * Constructs an Item object
     * @param id of item
     * @param name of item
     * @param description of item
     * @param fromId of item
     */
    public Item(String id, String name, String description, String fromId){
        this.id = id;
        this.name = name;
        this.description = description;
        this.fromId = fromId;
    }

    /**
     * Gets the id of the item
     * @return id of the item
     */
    public String getId(){
        return this.id;
    }

    /**
     * Gets the description of the item
     * @return description of the item
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * Gets the name of the item
     * @return name of the item
     */
    public String getName(){
        return this.name;
    }

    /**
     * Gets the from id of the item
     * @return from id of the item
     */
    public String getFromId(){
        return this.fromId;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(name).append(": ").append(description);
        return str.toString();
    }
}
