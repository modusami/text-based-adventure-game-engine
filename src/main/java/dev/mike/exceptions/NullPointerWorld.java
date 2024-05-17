package dev.mike.exceptions;


public class NullPointerWorld extends Exception{

    /**
     * Takes a string argument to the exception
     * @param str arg
     */
    public NullPointerWorld(String str){
        super(str);
    }

    /**
     * Throws an exception
     */
    public NullPointerWorld(){
        super("World is null. ");
    }
}