package dev.mike.objects;

/**
 * Represents a single character in the world
 */
public class SingleCharacter {
    // TODO : add a character array to a room to hold potential characters

    private String id;
    private  String name;
    private String description;

    private String dialogue;

    private String fromId; // room where the character is in

    /**
     * Constructs a single character
     * @param id of character
     * @param name of character
     * @param description of character
     * @param dialogue of chracter
     */
    public SingleCharacter(String id, String name, String description, String dialogue, String fromId){
        this.id = id;
        this.name = name;
        this.description = description;
        this.dialogue = dialogue;
        this.fromId = fromId;
    }

    /**
     * Gets the id of the character
     * @return id of the character
     */
    public String getId(){
        return this.id;
    }

    /**
     * Gets the description of the character
     * @return description of the character
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * Gets the name of the character
     * @return name of the character
     */
    public String getName(){
        return this.name;
    }

    /**
     * Gets the dialogue of the character
     * @return dialogue of the character
     */
    public String getDialogue(){
        return this.dialogue;
    }

    /**
     * Gets the from id of the character
     * @return from id of the character
     */
    public String getFromId(){
        return this.fromId;
    }

    /**
     * Returns a string version of the character
     */
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Name Of Character: ").append(name);
        str.append("\nDescription: ").append(description);
        str.append("\n").append(name).append(" says: ").append(dialogue);
        return str.toString();
    }
}
