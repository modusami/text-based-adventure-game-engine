package dev.mike.exceptions;

public class InvalidItemPlacement extends Exception{

    /**
     * Takes a string argument to the exception
     * @param str arg
     */
    public InvalidItemPlacement(String str){
        super(str);
    }

    /**
     * Throws an exception
     */
    public InvalidItemPlacement(){
        super("Invalid Item Placement. Check fromId of Item. ");
    }
}