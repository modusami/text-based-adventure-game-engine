package dev.mike.engine;

import dev.mike.utility.Print;

/**
 * The help menu if user types 'help'
 */
public class HelpMenu {
    public static void printHelpOptions() {
        Print.lines(50, '*');
        Print.ln("Help Options:");
        Print.lines(50, '-');
        Print.ln("Navigation:");
        Print.ln("- Move to a different room by entering the direction");
        Print.ln("  (e.g., 'north', 'south', 'east', 'west')");
        Print.ln("- Enter 'look' to examine the current room and its contents");
        Print.ln("");
        // TODO work on interaction command
        Print.ln("Interaction:");
        Print.ln("- Enter 'talk to [character name]' to initiate a conversation");
        Print.ln("  with a character");
        Print.ln("- Enter 'take [item name]' to pick up an item from the room");
//        Print.ln("- Enter 'use [item name]' to use an item from your inventory");
        Print.ln("");
        Print.ln("Inventory:");
        Print.ln("- Enter 'inventory' to view the items in your possession");
        Print.ln("- Enter 'drop [item name]' to remove an item from your inventory");
        Print.ln("");

        // POTENTIAL FUTURE COMMANDS....
//        Print.ln("Puzzles:");
//        Print.ln("- Solve puzzles by entering the correct answer or command");
//        Print.ln("- Enter 'hint' to receive a clue for the current puzzle");
//        Print.ln("");
//        Print.ln("Combat:");
//        Print.ln("- Enter 'attack' to engage in combat with an enemy");
//        Print.ln("- Enter 'flee' to attempt to escape from combat");
//        Print.ln("");
//        Print.ln("Quests:");
//        Print.ln("- Enter 'quests' to view your current quests and objectives");
//        Print.ln("- Complete quests by fulfilling the given requirements");
//        Print.ln("");
        Print.ln("Game:");
        Print.ln("- Enter 'save' to save your progress");
        Print.ln("- Enter 'load' to load a previously saved game");
        Print.ln("- Enter 'quit' to exit the game");
        Print.lines(50, '*');
    }
}
