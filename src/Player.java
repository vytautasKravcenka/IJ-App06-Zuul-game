import java.util.ArrayList;

/**
 *
 */
public class Player {
    private static final ArrayList<Item> inventory = new ArrayList<>();

    public static Item findItem(String itemName) {
        for(Item item : inventory)
        {
            if(item.getName().equals(itemName)) return item;
        }
        return null;
    }

    public void addItemToInventory(Item item) {
        inventory.add(item);
        System.out.println("You picked up " + item.getName());
    }

    public void useItemFromInventory(Item item) {

    }

}
