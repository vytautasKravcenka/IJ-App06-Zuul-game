/**
 *      Class that creates all the rooms and connects them with exits + adds their items.
 *      version 2020.01.10
 *      Created by Vytautas Kravcenka
 */
public class MapGenerator {

    private ItemsGenerator itemsGenerator;

    private Room startRoom;
    private Room outside, bedroom, hallway, lab, kitchen, basement, garden, livingRoom;

    public MapGenerator() {
        itemsGenerator = new ItemsGenerator();
        createRooms();
        // startRoom = bedroom;  // start game in your bedroom
    }

    private void createRooms() {
        // create the rooms
        createBedroom();
        createHallway();
        createLab();
        createLivingRoom();
        createKitchen();
        createOutside();
        createGarden();
        createBasement();
        connectRooms();
    }

    private void createBedroom() {
        bedroom = new Room("bedroom", "You woke up in this bedroom. You can see a writing on the wall that says 'get out'.\n"
                + "There is a small cupboard with gloves in it in the room.");


        bedroom.addItemInRoom(itemsGenerator.createGloves());
    }

    private void createHallway() {
        hallway = new Room("hallway", "This is a long hallway with pictures and paintings on the walls\n"
                + "There is a broom wardrobe in the middle.");


        hallway.addItemInRoom(itemsGenerator.createBroom());
    }

    private void createLab() {
        lab = new Room("lab", "A room with the smell of SCIENCE! You can see a mixer in one of the corners.\n"
        + "You should try and add something in it!");


        lab.addItemInRoom(itemsGenerator.createAcid());
    }

    private void createLivingRoom() {
        livingRoom = new Room("living room", "A weird living room with lots of bookshelves.\n"
                + "There seems to be a cup on one of the tall wardrobes.");


        livingRoom.addItemInRoom(itemsGenerator.createCup());
    }

    private void createKitchen() {
        kitchen = new Room("kitchen", "The smell here is incredible but we have to stick to our mission\n"
                + " and get out of here after grabbing anything useful.");

        kitchen.setLocked(true);
        kitchen.setDoorErrorMessage("Whatever lies behind this door smells delicious!\n"
        +"A rusty handle on the door doesn't move and you can't open the door..");

        kitchen.addItemInRoom(itemsGenerator.createCrowbar());
    }

    private void createOutside() {
        outside = new Room("outside", "");

        outside.setLocked(true);
        outside.setDoorErrorMessage("The door is locked. You need a key!");

        outside.setExit("east", livingRoom);
    }

    private void createGarden() {
        garden = new Room("garden", "A little garden with very tall walls.\n"
                + "There is a sink near the house that leaks watter, maybe you should gather some of it.\n"
                + "A huge plant is growing here with leaves that look poisonous.\n"
                + "There seems to a door to enter the basement here too.");


        garden.addItemInRoom(itemsGenerator.createLeaf());
        garden.addItemInRoom(itemsGenerator.createH2OCup());
    }

    private void createBasement() {
        basement = new Room("basement", "A dark room with something shining on the ground.");

        basement.setLocked(true);
        basement.setDoorErrorMessage("There is a lock on the door. You need something to break it.");

        basement.addItemInRoom(itemsGenerator.createKey());
    }

    public Room getStartRoom() {
        return bedroom;
    }

    private void connectRooms() {
        bedroom.setExit("south", hallway);

        hallway.setExit("north", bedroom);
        hallway.setExit("east", lab);
        hallway.setExit("west", livingRoom);

        lab.setExit("west", hallway);

        livingRoom.setExit("north", garden);
        livingRoom.setExit("east", hallway);
        livingRoom.setExit("south", kitchen);
        livingRoom.setExit("west", outside);

        kitchen.setExit("north", livingRoom);

        garden.setExit("south", livingRoom);
        garden.setExit("west", basement);

        basement.setExit("east", garden);
    }
}