package dev.mike.engine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Takes a json file and converts it (the json) into a string
 */
public class JSONConverter {

    /**
     * Converts json to string
     * @param filepath of json data
     * @throws IOException if file is not found
     */
    public static String convertToString(String filepath) throws IOException {
        String jsonString = new String(Files.readAllBytes(Paths.get(filepath)));
        return jsonString;
    }



}
