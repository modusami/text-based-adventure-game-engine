package dev.mike.utility;

import dev.mike.objects.Item;
import dev.mike.objects.Room;
import dev.mike.objects.SingleCharacter;

/**
 * Finds a room based on the room's attributes
 */
public class Finder {

    /**
     * gets a room based on it's id
     * @param rooms array
     * @param id of room
     * @return room based on id
     */
    public static Room findRoom(Room[] rooms, String id){
        for (Room room : rooms) {
            if (room.getId().equals(id)) {
                return room;
            }
        }
        return null;
    }

    public static Item findItem(Room room, String name){
        if (room == null){
            return null;
        }
        else{
            for (Item i : room.getItems()){
                if (i.getName().equalsIgnoreCase(name)){
                    return i;
                }
            }
        }

        return null;
    }

    public static SingleCharacter findCharacter(Room room, String name){
        SingleCharacter[] cc = room.getCharacters();
        if (cc == null){
            return null;
        }
        else{
            for (SingleCharacter c : cc){
                if (c.getName().equalsIgnoreCase(name)){
                    return c;
                }
            }
        }

        return null;
    }
}
