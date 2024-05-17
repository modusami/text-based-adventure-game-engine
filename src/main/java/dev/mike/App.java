package dev.mike;

import dev.mike.commands.CommandParser;
import dev.mike.engine.GameEngine;
import dev.mike.engine.JSONConverter;
import dev.mike.engine.JSONParser;
import dev.mike.objects.*;
import dev.mike.user.Player;
import dev.mike.utility.Print;

import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Player player = new Player("player");
        try {
            GameEngine.run(player);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}