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
        bedroom = new Room("bedroom" ,""); // TODO: change description


        bedroom.addItemInRoom(itemsGenerator.createGloves());
    }

    private void createHallway() {
        hallway = new Room("hallway",""); // TODO: change description


        hallway.addItemInRoom(itemsGenerator.createBroom());
    }

    private void createLab() {
        lab = new Room("lab",""); // TODO: change description


        lab.addItemInRoom(itemsGenerator.createAcid());
    }

    private void createLivingRoom() {
        livingRoom = new Room("living room",""); // TODO: change description


        livingRoom.addItemInRoom(itemsGenerator.createCup());
    }

    private void createKitchen() {
        kitchen = new Room("kitchen",""); // TODO: change description

        kitchen.setLocked(true);
        kitchen.setDoorErrorMessage(""); // TODO: add text

        kitchen.addItemInRoom(itemsGenerator.createCrowbar());
    }

    private void createOutside() {
        outside = new Room("outside",""); // TODO: change description

        outside.setLocked(true);
        outside.setDoorErrorMessage(""); // TODO: add text

        outside.setExit("east", livingRoom);
    }

    private void createGarden() {
        garden = new Room("garden",""); // TODO: change description


        garden.addItemInRoom(itemsGenerator.createLeaf());
        garden.addItemInRoom(itemsGenerator.createH2OCup());
    }

    private void createBasement() {
        basement = new Room("basement",""); // TODO: change description

        basement.setLocked(true);
        basement.setDoorErrorMessage(""); // TODO: add text

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