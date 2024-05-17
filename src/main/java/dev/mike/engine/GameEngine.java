package dev.mike.engine;

import dev.mike.commands.*;
import dev.mike.exceptions.NullPointerWorld;
import dev.mike.objects.*;
import dev.mike.user.Player;
import dev.mike.utility.Finder;
import dev.mike.utility.Print;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Represents the Game Engine For The Game
 */
public class GameEngine {

    public static Player player = null;
    public static World world = null;
    public static Room currentRoom = null; // remove


    /**
     * Loads the Engine
     */
    public static void run(Player p){
        try {
            player = p;
            String jsonString = JSONConverter.convertToString("data.json");
            JSONParser parser = new JSONParser(jsonString);
            world = parser.getWorld();
            currentRoom = Finder.findRoom(world.getRooms(), "start");
            runEngine();
        }
        catch(Exception e){
            e.printStackTrace();
            System.exit(1);
        }
    }



    /**
     * Runs the game
     */
    private static void runEngine() throws NullPointerWorld{
        if (world == null){
            throw new NullPointerWorld();
        }
        Scanner input = new Scanner(System.in);
        WorldCommand.introduceWorld(world);
        String answer = input.nextLine().trim();
        if (!answer.equals("enter")){
            Print.ln("Quitting Game..."); // TODO handle action better
            System.exit(1);
        }
        CommandParser parser = new CommandParser();
        try {
            while(true) {
                String command = input.nextLine().trim();
                parser.handleCommand(command);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }


    /**
     * Saves player progess
     */
    public static boolean savePlayerProgress(){

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(player.getName() + "_progress"))){
            oos.writeObject(player);
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Loads player progess
     */
    public static boolean loadPlayerProgress(){
        try(ObjectInputStream oos = new ObjectInputStream(new FileInputStream(player.getName() + "_progress"))){
            Player temp = (Player) oos.readObject();
            if (temp != null){
                player = temp;
                return true;
            }
            else{
                throw new NullPointerException();
            }
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }

    }



}
