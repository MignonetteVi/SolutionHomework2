```java
        package com.example.mud.controller;
import java.util.Scanner;
import com.example.mud.player.Player;

/* MUDController (Skeleton):
 * A simple controller that reads player input and orchestrates
 * basic commands like look around, move, pick up items,
 * check inventory, show help, etc.
 */
public class MUDController {
    private final Player player;
    private boolean running;

    /*
     * Constructs the controller with a reference to the current player.
     */
    public MUDController(Player player) {
        this.player = player;
        running = true;
    }

    /*
     * Main loop method that repeatedly reads input from the user
     * and dispatches commands until the game ends.
     */
    public void runGameLoop() {
        Scanner scanner = new Scanner(System.in);
        while (running) {
            System.out.print("> ");
            String input = scanner.nextLine();
            handleInput(input);
        }
        // Do not close the scanner to avoid closing System.in
    }

    /*
     * Handle a single command input (e.g. 'look', 'move forward', 'pick up sword').
     */
    public void handleInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            return;
        }
        // Split the input into command and optional argument
        String[] parts = input.trim().split(" ", 2);
        String command = parts[0].toLowerCase();
        String argument = parts.length > 1 ? parts[1].trim() : "";

        if (command.equals("look")) {
            lookAround();
        } else if (command.equals("move")) {
            if (argument.isEmpty()) {
                System.out.println("please specify a direction (e.g., move forward).");
            } else {
                move(argument);
            }
        } else if (command.equals("pick")) {
            // Expecting input in the form "pick up [item]"
            if (argument.toLowerCase().startsWith("up")) {
                pickUp(argument);
            } else {
                System.out.println("perhaps you meant 'pick up [item]'.");
            }
        } else if (command.equals("inventory")) {
            checkInventory();
        } else if (command.equals("help")) {
            showHelp();
        } else if (command.equals("quit")) {
            running = false;
            System.out.println("game over.");
        } else {
            System.out.println("unknown command. Type 'help' for a list of available commands.");
        }
    }

    /*
     * Look around the current room: describe it and show items/NPCs.
     */
    private void lookAround() {
        // For simplicity, print a placeholder message.
        System.out.println("you look around. The room appears empty and quiet.");
    }

    /*
     * Move the player in a given direction (forward, back, left, right).
     */
    private void move(String direction) {
        direction = direction.toLowerCase();
        // Allow only basic directions
        if (direction.equals("forward") || direction.equals("back") ||
                direction.equals("left") || direction.equals("right")) {
            System.out.println("you moved " + direction + ". A new area unfolds before you.");
        } else {
            System.out.println("you cannot move in that direction.");
        }
    }

    /*
     * Pick up an item (e.g. "pick up sword").
     */
    private void pickUp(String arg) {
        // Remove the prefix "up " if present
        String item = arg;
        if (item.toLowerCase().startsWith("up ")) {
            item = item.substring(3).trim();
        }
        if (item.isEmpty()) {
            System.out.println("what do you want to pick up?");
        } else {
            // Here you can add logic to check for the item's existence in the room
            System.out.println("you picked up " + item + ".");
        }
    }

    /*
     * Check the player's inventory.
     */
    private void checkInventory() {
        // For simplicity, assume the inventory is empty.
        System.out.println("your inventory is empty.");
    }

    /*
     * Show help commands
     */
    private void showHelp() {
        System.out.println("available commands:");
        System.out.println("look - examine the current room");
        System.out.println("move [direction] - move in a direction (forward, back, left, right)");
        System.out.println("pick up [item] - pick up an item");
        System.out.println("inventory - check your inventory");
        System.out.println("help - display this help message");
        System.out.println("quit - exit the game");
    }

    /*
     * (Optional) Add any other methods (e.g., attack, open door, talk, etc.)
     * if you want to extend the game logic further.
     */
}
```