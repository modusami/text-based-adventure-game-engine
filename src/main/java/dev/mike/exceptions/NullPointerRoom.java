package dev.mike.exceptions;


public class NullPointerRoom extends Exception{

    /**
     * Takes a string argument to the exception
     * @param str arg
     */
    public NullPointerRoom(String str){
        super(str);
    }

    /**
     * Throws an exception
     */
    public NullPointerRoom(){
        super("Room is null. ");
    }
}