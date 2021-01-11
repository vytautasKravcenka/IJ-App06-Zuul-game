/**
 * This class is the main class of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.  Users
 * can walk around some scenery. That's all. It should really be extended
 * to make it more interesting!
 * <p>
 * To play this game, create an instance of this class and call the "play"
 * method.
 * <p>
 * This main class creates and initialises all the others: it creates all
 * rooms, creates the parser and starts the game.  It also evaluates and
 * executes the commands that the parser returns.
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 * <p>
 * Modified and extended by Derek and Andrei
 */

public class Game {
    private Parser parser;
    private Room currentRoom;
    private MapGenerator mapGenerator;
    private Player player;

    public boolean wantToQuit = false;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() {
        parser = new Parser();
        //createRooms();
        mapGenerator = new MapGenerator();
        currentRoom = mapGenerator.getStartRoom();
        player = new Player();
        play();
    }

    /**
     * Main play routine.  Loops until end of play.
     */
    public void play() {
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;

        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }

        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getShortDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     *
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) {

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case LOOKAROUND:
                lookAround();
                break;

            case TAKE:
                takeItem(command);
                break;

            case USE:
                confirmItemUse(command);
                break;

            case GO:
                goRoom(command);
                break;

            case INVENTORY:
                inventory();
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
        }
        return wantToQuit;
    }

    private void inventory() {
        System.out.println(player.getItemsList());
    }

    private void confirmItemUse(Command command) {

        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Use what?");
            return;
        }

        String itemName = command.getSecondWord();

        Item item = Player.findItem(itemName);


        if (item == null) {
            System.out.println("There is no item like that in your inventory!");
            return;
        }

        useItem(item);
    }

    private void takeItem(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Take what?");
            return;
        }

        String itemName = command.getSecondWord();

        Item item = currentRoom.findItem(itemName);

        if (item == null) {
            System.out.println("There is no item with '" + itemName + "' name in this room");
        } else if (!item.getTakeByHand()) {
            System.out.println(item.getCantTakeDescription());
        } else {
            currentRoom.takeItemFromRoom(item);
            player.addItemToInventory(item);
            System.out.println(item.getName() + " is now in your inventory.");
        }

    }

    private void lookAround() {
        System.out.println(currentRoom.getLongDescription());
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the
     * command words.
     */
    private void printHelp() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /**
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else if (nextRoom.getLocked()) {
            System.out.println(nextRoom.getDoorErrorMessage());
        } else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getShortDescription());
        }
    }

    /**
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     *
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;  // signal that we want to quit
        }
    }

    public void useItem(Item item) {
        Item roomItem = currentRoom.findItem(item.getCanBeUsedOn());
        if (item.getName().equals("cup") && currentRoom.getName().equals("garden")) {
            useSink(item);
        } else if (item.getCanBeUsedOn().equals("mixer") && currentRoom.getName().equals("lab")) {
            useMixer(item);
        } else if (item.getName().equals("crowbar") && currentRoom.getName().equals("garden")) {
            unlockBasementDoor(item);
        } else if (item.getName().equals("key") && currentRoom.getName().equals("living room")) {
            unlockMainDoor(item);
        } else if (item.getName().equals("acid") && currentRoom.getName().equals("living room")) {
            unlockKitchenDoor(item);
        } else if (roomItem == null) {
            System.out.println(item.getUnableUseDescription());
        } else {
            player.removeItem(item);
            System.out.println(item.getUsingDescription());
            Item pickable = currentRoom.findItem(item.getCanBeUsedOn());
            currentRoom.takeItemFromRoom(pickable);
            player.addItemToInventory(pickable);
        }

    }

    private void unlockBasementDoor(Item item) {
        player.removeItem(item);
        currentRoom.getExit("west").setLocked(false);
        System.out.println("You successfully broke the lock! Now you can access the Basement");
    }

    private void unlockMainDoor(Item item) {
        player.removeItem(item);
        System.out.println("Congratulations you have beaten the game!");
        wantToQuit = true;
    }

    private void unlockKitchenDoor(Item item) {
        player.removeItem(item);
        currentRoom.getExit("south").setLocked(false);
        System.out.println("The handle was melted! Now you can access the kitchen");
    }

    private void useSink(Item item) {
        player.removeItem(item);
        System.out.println("You put the cup in the old sink");
        Item pickable = currentRoom.findItem("H2O_cup");
        currentRoom.takeItemFromRoom(pickable);
        System.out.println("Cup was filled with water and put back in your inventory!");
        player.addItemToInventory(pickable);
    }

    private void useMixer(Item item) {
        player.removeItem(item);

        System.out.println("Successfully added " + item.getName() + " to the mixer!");

        if (currentRoom.findItem("leaf") != null || currentRoom.findItem("H2O_cup") != null) {
            System.out.println("beep bloop blab mixer worked fine!");
            System.out.println("You made Acid and put it into your inventory");
            player.addItemToInventory(currentRoom.findItem("acid"));
        } else {
            System.out.println("seems like we need to add more products in the mixer (needs one more item)");
            currentRoom.addItemInRoom(item);
            item.setIgnoreInRoom(true);
        }
    }
}
