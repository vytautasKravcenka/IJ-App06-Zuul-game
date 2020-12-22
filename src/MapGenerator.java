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
        bedroom = new Room("In your bedroom");


        bedroom.addItemInRoom(itemsGenerator.createGloves());
    }

    private void createHallway() {
        hallway = new Room("in the computing admin office");


        hallway.addItemInRoom(itemsGenerator.createBroom());
    }

    private void createLab() {
        lab = new Room("in a computing lab");


        lab.addItemInRoom(itemsGenerator.createAcid());
    }

    private void createLivingRoom() {
        livingRoom = new Room("in the computing admin office");


        livingRoom.addItemInRoom(itemsGenerator.createCup());
    }

    private void createKitchen() {
        kitchen = new Room("in a lecture theater");


        kitchen.addItemInRoom(itemsGenerator.createCrowbar());
    }

    private void createOutside() {
        outside = new Room("outside the main entrance of the university");

        outside.setExit("east", livingRoom);
    }

    private void createGarden() {
        garden = new Room("in a computing lab");


        garden.addItemInRoom(itemsGenerator.createLeaf());
    }

    private void createBasement() {
        basement = new Room("in the campus pub");


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

        basement.setExit("East", garden);
    }
}