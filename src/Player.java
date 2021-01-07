import java.util.ArrayList;

/**
 *
 */
public class Player {
    private ArrayList<Item> inventory = new ArrayList<>();

    public void addItemToInventory(Item item) {
        inventory.add(item);
        System.out.println("You picked up " + item.getName());
    }

    public void useItemFromInventory(Item item) {

    }

}
