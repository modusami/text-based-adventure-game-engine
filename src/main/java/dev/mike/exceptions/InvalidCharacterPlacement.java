package dev.mike.exceptions;

/**
 * Represents an invalid excpetion when a character is loaded into the wrong room
 */
public class InvalidCharacterPlacement extends Exception{

    /**
     * Takes a string argument to the exception
     * @param str arg
     */
    public InvalidCharacterPlacement(String str){
        super(str);
    }

    /**
     * Throws an exception
     */
    public InvalidCharacterPlacement(){
        super("Invalid Character Placement. Check fromId of Character. ");
    }
}