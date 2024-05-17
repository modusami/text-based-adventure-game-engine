package dev.mike.commands;

import dev.mike.engine.GameEngine;
import dev.mike.engine.HelpMenu;
import dev.mike.exceptions.NullPointerCharacter;
import dev.mike.exceptions.NullPointerItem;
import dev.mike.exceptions.NullPointerRoom;
import dev.mike.objects.*;
import dev.mike.utility.Finder;
import dev.mike.utility.Print;

import java.util.Scanner;

public class CommandParser {

    private final Scanner input = new Scanner(System.in);

    /**
     * Handles moving into a new room
     * @param command to execute
     * @throws NullPointerRoom if room is not found
     */
    private void direction(String command) throws NullPointerRoom {
        for (Exit exit : GameEngine.currentRoom.getExits()){
            if (exit.getDirection().direction().equals(command)){
                GameEngine.currentRoom = Finder.findRoom(GameEngine.world.getRooms(), exit.getToId());
                if (GameEngine.currentRoom != null) {
                    Print.ln("You've entered " + GameEngine.currentRoom.getName());
                    GameEngine.player.setCurrentRoomId(GameEngine.currentRoom.getId());
                }
                else{
                    throw new NullPointerRoom();
                }
            }
        }
    }

    /**
     * Handles look command
     */
    private void look(){
        Item[] items = GameEngine.currentRoom.getItems();
        if (items == null) {
            Print.ln("No items in this room.");
        } else {
            Print.ln("In this room, there are items: ");
            for (Item i : items) {
                Print.ln(i);
            }
        }

        SingleCharacter[] characters = GameEngine.currentRoom.getCharacters();
        if (characters== null) {
            Print.ln("No characters in this room.");
        } else {
            Print.ln("In this room, there are characters: ");
            for (SingleCharacter c : characters) {
                Print.ln(c.getName());
            }
        }
    }

    /**
     * Talks to a character
     * @param command to talk to
     * @throws NullPointerCharacter if character is null
     */
    private void talkTo(String command) throws NullPointerCharacter {
        int index = command.indexOf("talk to ") + "talk to ".length();
        String name = command.substring(index);
        SingleCharacter c = Finder.findCharacter(GameEngine.currentRoom, name);
        if (c == null){
            throw new NullPointerCharacter();
        }
        Print.ln(c.getDialogue());
    }

    private void takeItem(String command) throws NullPointerItem {
        int index = command.indexOf("take ") + "take ".length();
        String name = command.substring(index);
        Item item = Finder.findItem(GameEngine.currentRoom, name);
        if (item == null){
            throw new NullPointerItem();
        }
        GameEngine.player.addItems(item);
        Print.ln("Item taken.");

    }

    private void dropItem(String command) throws NullPointerItem {
        int index = command.indexOf("drop ") + "drop ".length();
        String name = command.substring(index);
        Item item = Finder.findItem(GameEngine.currentRoom, name);
        if (item == null){
            throw new NullPointerItem();
        }
        boolean deleted = GameEngine.player.removeItem(item.getId());
        if (deleted) {
            Print.ln("Item Dropped.");
        }
        else{
            Print.ln("Error dropping item");
        }

    }

    private void save(){
        boolean saved = GameEngine.savePlayerProgress();
        if (saved){
            Print.ln("Progress Saved.");
        }
        else{
            Print.ln("Error Saving Progress.");
        }

    }

    private void load(){
        boolean loaded = GameEngine.loadPlayerProgress();
        if (loaded){
            // move player to the correct room
            GameEngine.currentRoom = Finder.findRoom(GameEngine.world.getRooms(), GameEngine.player.getCurrentRoomId());
            Print.ln("Progress Loaded.");
        }
        else{
            Print.ln("Error Loading Progress.");
        }
    }


    /**
     * Takes a command and executes that command
     * @param command to execute
     */
    public void handleCommand(String command)  {
        try {
            command = command.toLowerCase();
            if (command.equals("help")) {
                HelpMenu.printHelpOptions();
            } else if (command.matches("north|west|east|south")) {
                direction(command);
            }
            else if(command.equals("look")){
                look();
            }
            else if(command.startsWith("talk to")){
                talkTo(command);
            }
            else if(command.startsWith("take")){
                takeItem(command);
            }
            else if(command.equals("inventory")){
                Print.ln(GameEngine.player);
            }
            else if(command.startsWith("drop")){
                dropItem(command);
            }
            else if(command.equals("save")){
                save();
            }
            else if(command.equals("load")){
                load();
            }
            else if(command.equals("quit")){
                System.exit(0);
            }
            else{
                Print.ln("Invalid command...");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


}
