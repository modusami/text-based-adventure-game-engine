package dev.mike.objects;

/**
 * Represents a single direction which serves as an exit the user can take out the room.
 */
public enum Direction {
    NORTH("north"),
    SOUTH("south"),
    WEST("west"),
    EAST("east");

    private final String direction;

    /**
     * Constructs a Direction Enum
     * @param d
     */
    Direction(String d){
        this.direction = d;
    }

    /**
     * Gets the direction of the enum
     * @return the direction of the enum
     */
    public String direction(){
        return direction;
    }

    /**
     * Gets a direction
     * @param strDirection direction of the enum
     */
    public static Direction getDirectionEnum(String strDirection){
        return switch (strDirection.toLowerCase()) {
            case "north" -> NORTH;
            case "west" -> WEST;
            case "east" -> EAST;
            case "south" -> SOUTH;
            default -> null;
        };
    }

}
