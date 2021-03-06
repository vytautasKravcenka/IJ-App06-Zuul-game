import java.util.ArrayList;
import java.util.Set;
import java.util.HashMap;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 *
 * @version 2020.01.10
 * @Modified by Vytautas Kravcenka
 */

public class Room 
{
    private boolean locked;
    private final String name;
    private final String description;
    private String doorErrorMessage; //Message shown when door cannot be unlocked
    // String is the key to a room in that direction
    // east would be an exit that goes to the Room
    private final HashMap<String, Room> exits = new HashMap<>();


    private final ArrayList<Item> items = new ArrayList();

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String name, String description)
    {
        this.name = name;
        this.description = description;
    }


    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor)
    {
        exits.put(direction, neighbor);
    }

    public void addItemInRoom(Item item)
    {
        //add requirements
        items.add(item);
    }

    public void takeItemFromRoom(Item item)
    {
            items.remove(item);
    }

    public Item findItem(String name)
    {
        for(Item item : items)
        {
            if(item.getName().equals(name)) return item;
        }
        return null;
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return "You are in " + name + ".\n";
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return description + ".\n" + getExitString() + ".\n" + getItemsList();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        StringBuilder returnString = new StringBuilder("Exits:");
        Set<String> keys = exits.keySet();
        for(String exit : keys)
        {
            returnString.append(" ").append(exit);
        }
        return returnString.toString();
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }

    public String getItemsList() {
        if(items.size() == 0)
            return "There seems to be no items in this room.";
        StringBuilder itemsList = new StringBuilder("Items in this room: ");
        for(Item item : items)
        {
            if(!item.getIgnoreInRoom())
            itemsList.append(item.getName()).append(" ");
        }

        return itemsList.toString();
    }

    public boolean getLocked()
    {
        return locked;
    }

    public String getDoorErrorMessage() {
        return doorErrorMessage;
    }

    public void setDoorErrorMessage(String doorErrorMessage) {
        this.doorErrorMessage = doorErrorMessage;
    }

    public String getName() {
        return name;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
}

