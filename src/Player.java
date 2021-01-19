import java.util.ArrayList;

/**
 *  player has a score and inventory to hold items
 *  version 2020.01.10
 *  Created by Vytautas Kravcenka
 */
public class Player {
    private static final ArrayList<Item> inventory = new ArrayList<>();
    private int playerStage = 0;
    private int timesWalked = 0;

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

    public int countScore()
    {
        return ((playerStage * 100) - (timesWalked * 15));
    }

    public void addPlayerStage() {
        playerStage ++;
    }

    public void addTimesWalked() {
        timesWalked ++;
    }
}
