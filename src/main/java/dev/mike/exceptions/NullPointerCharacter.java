package dev.mike.exceptions;


public class NullPointerCharacter extends Exception{

    /**
     * Takes a string argument to the exception
     * @param str arg
     */
    public NullPointerCharacter(String str){
        super(str);
    }

    /**
     * Throws an exception
     */
    public NullPointerCharacter(){
        super("Character is null. ");
    }
}