package dev.mike.exceptions;

/**
 * Represents an invalid room exit
 */
public class InvalidRoomExit extends Exception{

    /**
     * Takes a string argument to the exception
     * @param str arg
     */
    public InvalidRoomExit(String str){
        super(str);
    }

    /**
     * Throws an exception
     */
    public InvalidRoomExit(){
        super("Invalid room exit. Ensure room has correct starting and ending room id's.");
    }
}
