package dev.mike.utility;

/**
 * This class provides printing to the console utility methods
 */
public class Print {

    /**
     * Prints a single line of symbol to the console
     * @param numOfSymbols to print
     */
    public static void lines(int numOfSymbols, char symbol){
        for (int i = 0; i < numOfSymbols; i++){
            n(symbol);
        }

        ln("");
    }

    /**
     * This method prints a value to the console with a newline
     * @param value to print
     * @param <T> type of data for the value
     */
    public static <T> void ln(T value){
        System.out.println(value);
    }


    /**
     * This method prints a value to the console without a new line
     * @param value to print
     * @param <T> type of data for the value
     */
    public static <T> void n(T value){
        System.out.print(value);
    }
}
