package dev.mike.commands;

import dev.mike.objects.World;
import dev.mike.utility.Print;

/**
 * Represents prompts and inputs to do with a single World
 */
public class WorldCommand {

    /**
     * Introduces the world
     */
    public static void introduceWorld(World world){
        Print.n("\nWelcome to: " + world.getName() + " ");
        Print.n(world.getDescription() + "\n");
        Print.n("Type 'enter To Continue: ");
    }

}
