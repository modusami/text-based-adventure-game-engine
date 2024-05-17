package dev.mike.objects;

/**
 * Represents a single Exit out of a room
 */
public class Exit {
    private String fromId; // the room in which the exit is placed
    private String toId; // the room in which the exit heads to
    private Direction dir; // the direction of the exit

    /**
     * Constructs an Exit Object
     * @param from the room in which the exit is placed
     * @param to the room in which the exit heads to
     * @param dir the direction of the exit
     */
    public Exit(String from, String to, Direction dir){
        this.fromId = from;
        this.toId = to;
        this.dir = dir;
    }


    /**
     * Gets the direction of the exit
     * @return direction of the exit
     */
    public Direction getDirection(){
        return dir;
    }

    /**
     * Gets the room where the exit is coming from
     * @return the room where exit is coming from
     */
    public String getFromId(){
        return this.fromId;
    }

    /**
     * Gets the room where the exit is going to
     * @return the room where exit is going to
     */
    public String getToId(){
        return this.toId;
    }


    /**
     * Returns string representation of an Exit
     * @return string representation of an Exit
     */
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("exit ").append(dir.direction());
        str.append(" to room id of ").append(toId);
        str.append(" coming from room id of ").append(fromId);
        return str.toString();
    }




}
