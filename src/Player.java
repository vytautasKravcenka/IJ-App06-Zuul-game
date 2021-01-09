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

    public String getItemsList() {
        if(inventory.size() == 0)
            return "Your inventory is empty!";
        StringBuilder itemsList = new StringBuilder("Items in your inventory: ");
        for(Item item : inventory)
        {
                itemsList.append(item.getName()).append(" ");
        }

        return itemsList.toString();
    }

    public void addItemToInventory(Item item) {
        inventory.add(item);
        System.out.println("You picked up " + item.getName());
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }
}
