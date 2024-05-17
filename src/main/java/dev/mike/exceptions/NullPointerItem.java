package dev.mike.exceptions;

public class NullPointerItem extends Exception{

    /**
     * Takes a string argument to the exception
     * @param str arg
     */
    public NullPointerItem(String str){
        super(str);
    }

    /**
     * Throws an exception
     */
    public NullPointerItem(){
        super("Item is null. ");
    }
}