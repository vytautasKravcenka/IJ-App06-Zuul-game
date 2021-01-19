/**
 * Class to create all the usable items in game.
 * version 2020.01.10
 * Created by Vytautas Kravcenka
 */
public class ItemsGenerator {
    private Item item;

    public Item createLeaf() {
        item = new Item("leaf");
        item.setCantTakeDescription("The plant seems dangerous. You shouldn't take it by hands.");
        item.setTakeByHand(false);
        item.setCanBeUsedOn("mixer");
        return item;
    }

    public Item createCrowbar() {
        item = new Item("crowbar");
        item.setTakeByHand(true);
        item.setCanBeUsedOn("lock");
        return item;
    }

    public Item createKey() {
        item = new Item("key");
        item.setTakeByHand(true);
        item.setCanBeUsedOn("door");
        return item;
    }

    public Item createCup() {
        item = new Item("cup");
        item.setCantTakeDescription("You try to reach up the wardrobe but the cup is too high to reach.\n"
                + " Perhaps you should try to use something to get it.");
        item.setCanBeUsedOn("sink");
        item.setTakeByHand(false);
        return item;
    }

    public Item createH2OCup(){
        item = new Item("H2O_cup");
        item.setCantTakeDescription("Don't cheat!");
        item.setCanBeUsedOn("mixer");
        item.setTakeByHand(false);
        item.setIgnoreInRoom(true);
        return item;
    }

    public Item createBroom() {
        item = new Item("broom");
        item.setUsingDescription("You successfully used the broom to get the cup.");
        item.setTakeByHand(true);
        item.setCanBeUsedOn("cup");
        return item;
    }

    public Item createAcid() {
        item = new Item("acid");
        item.setCantTakeDescription("Don't cheat!");
        item.setCanBeUsedOn("door_handle");
        item.setTakeByHand(false);
        item.setIgnoreInRoom(true);
        return item;
    }

    public Item createGloves() {
        item = new Item("gloves");
        item.setUsingDescription("You put on the gloves and take the leaves of the plant");
        item.setTakeByHand(true);
        item.setCanBeUsedOn("leaf");
        return item;
    }
}
