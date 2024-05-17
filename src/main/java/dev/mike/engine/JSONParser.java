package dev.mike.engine;

import dev.mike.exceptions.InvalidCharacterPlacement;
import dev.mike.exceptions.InvalidItemPlacement;
import dev.mike.exceptions.InvalidRoomExit;
import dev.mike.objects.*;
import dev.mike.utility.Finder;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.List;

import java.util.ArrayList;
import java.util.function.IntFunction;

/**
 * Parses json data
 */
public class JSONParser {

    private JSONObject obj;

    /**
     * Takes in a json string and constructs an new json object.
     * @param jsonString to parse
     */
    public JSONParser(String jsonString){
        this.obj = new JSONObject(jsonString);
    }



    /**
     * gets a single item
     *  @param tempObj to get data from
     *  @param fromId that character belongs to
     * @return a single item
     */
    private Item getItem(JSONObject tempObj, String fromId){
        String itemId = tempObj.getString("id");
        String itemName = tempObj.getString("name");
        String itemDescription = tempObj.getString("description");
        return new Item(itemId, itemName, itemDescription, fromId);
    }

    /**
     * gets a single character
     * @param tempObj to get data from
     * @param fromId that character belongs to
     * @return a single character
     */
    private SingleCharacter getSingleCharacter(JSONObject tempObj, String fromId){
        String id = tempObj.getString("id");
        String name = tempObj.getString("name");
        String description = tempObj.getString("description");
        String dialogue = tempObj.getString("dialogue");

        return new SingleCharacter(id, name, description, dialogue, fromId);
    }

    /**
     * gets a single exit
     * @param tempObj to get data from
     * @param fromId that character belongs to
     * @return an exit
     */
    private Exit getExit(JSONObject tempObj, String fromId){
        Direction tempDirection = Direction.getDirectionEnum(tempObj.getString("direction"));
        String tempExitRoomId = tempObj.getString("room");
        return new Exit(fromId, tempExitRoomId, tempDirection);

    }

    /**
     * Constructs an array from a list of type T
     * @param arg a list
     * @return an array from a list of type T
     * @param <T> type of data
     */
    @SuppressWarnings("unchecked")
    private <T> T[] constructArray(List<T> arg, IntFunction<T[]> arrConstruct){
        return arg.toArray(arrConstruct.apply(0));

//        T[] arr = (T[]) new Object[arg.size()];
//        int len = arg.size();
//        for (int i = 0; i < len; i++){
//            arr[i] = arg.get(i);
//        }
//        return arr;
    }




    /**
     * Parses and gets rooms from the json object
     * @return array of rooms
     */
    private Room[] getRooms() throws InvalidItemPlacement, InvalidRoomExit, InvalidCharacterPlacement {
        JSONArray rooms = obj.getJSONArray("rooms");
        int len = rooms.length();
        Room[] roomsArr = new Room[len];

        for (int i = 0; i < len; i++){
            List<Exit> exits = new ArrayList<>();
            List<Item> items = new ArrayList<>();
            List<SingleCharacter> characters = new ArrayList<>();
            // basic data
            JSONObject temp = rooms.getJSONObject(i);
            String roomId = temp.getString("id");
            String name = temp.getString("name");
            String description = temp.getString("description");

            if (temp.has("exits")) {
                // exits
                JSONArray jsonExits = temp.getJSONArray("exits");
                int exitLength = jsonExits.length();
                for (int e_idx = 0; e_idx < exitLength; e_idx++) {
                    JSONObject tempExit = jsonExits.getJSONObject(e_idx);
                    exits.add(getExit(tempExit, roomId));
                }
            }

            if (temp.has("items")) {
                // items
                JSONArray jsonItems = temp.getJSONArray("items");
                int itemLength = jsonItems.length();
                for (int item_i = 0; item_i < itemLength; item_i++) {
                    JSONObject tempItemObj = jsonItems.getJSONObject(item_i);
                    items.add(getItem(tempItemObj, roomId));
                }
            }

            if (temp.has("characters")) {
                // characters
                JSONArray jsonCharacters = temp.getJSONArray("characters");
                int charLength = jsonCharacters.length();
                for (int char_i = 0; char_i < charLength; char_i++) {
                    JSONObject tempObj = jsonCharacters.getJSONObject(char_i);
                    characters.add(getSingleCharacter(tempObj, roomId));
                }
            }

            // turn the lists into valid array to create room object
            Item[] itemsArr = null;
            SingleCharacter[] singleCharactersArr = null;
            Exit[] exitsArr = null;
            if (!items.isEmpty()){
                itemsArr = constructArray(items, Item[]::new);
            }
            if (!characters.isEmpty()){
                singleCharactersArr = constructArray(characters, SingleCharacter[]::new);
            }
            if (!exits.isEmpty()){
                exitsArr = constructArray(exits, Exit[]::new);
            }

            roomsArr[i] = new Room(roomId, name, description, exitsArr, singleCharactersArr, itemsArr);
        }

        return roomsArr;
    }



    /**
     * Creates a single world
     * @return a world
     */
    public World getWorld() throws InvalidItemPlacement, InvalidRoomExit, InvalidCharacterPlacement {
        String name = obj.getString("world");
        String description = obj.getString("description");
        Room[] rooms = getRooms();
        World world = new World(name, description, rooms);
        return world;
    }


}
