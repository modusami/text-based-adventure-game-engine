package dev.mike.objects;

/**
 * Represents a single world in our text based adventure
 */
public class World {

    private String name; // name of world
    private String description;

    private Room[] rooms;

    /**
     * Constructs a world object
     * @param name of world
     * @param description of world
     * @param rooms belonging to world
     */
    public World(String name, String description, Room[] rooms){
        this.name = name;
        this.description = description;
        this.rooms = rooms;
    }

    /**
     * Gets the description of the world
     * @return description of the world
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * Gets the name of the world
     * @return name of the world
     */
    public String getName(){
        return this.name;
    }

    /**
     * Gets all the rooms
     * @return all the rooms
     */
    public Room[] getRooms(){
        return this.rooms;
    }


    /**
     * Returns string version of world
     */
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("WORLD: ").append(name).append("\n");
        str.append("This world: ").append(description).append("\n");
        for (Room r : rooms){
            str.append(r.toString()).append("\n");
        }

        return str.toString();
    }
}
