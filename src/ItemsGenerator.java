public class ItemsGenerator {
    private Item item;

    public Item createLeaf() {
        item = new Item("leaf");
        item.setUnableUseDescription(""); // TODO: add "unableUseDescription"
        item.setUsingDescription(""); // TODO: add "successfulUseDescription"
        item.setTakeByHand(true);
        item.setCanBeUsedOn(""); // TODO: [ IMPORTANT ] add what the item can be used on (name lab thingy)
        return item;
    }

    public Item createCrowbar() {
        item = new Item("crowbar");
        item.setUnableUseDescription(""); // TODO: add "unableUseDescription"
        item.setUsingDescription(""); // TODO: add "successfulUseDescription"
        item.setTakeByHand(true);
        item.setCanBeUsedOn("lock");
        return item;
    }

    public Item createKey() {
        item = new Item("key");
        item.setUnableUseDescription(""); // TODO: add "unableUseDescription"
        item.setUsingDescription(""); // TODO: add "successfulUseDescription"
        item.setTakeByHand(true);
        item.setCanBeUsedOn("door");
        return item;
    }

    public Item createCup() {
        item = new Item("cup");
        item.setCantTakeDescription(""); // TODO: add "cantTakeDescription"
        item.setUnableUseDescription(""); // TODO: add "unableUseDescription"
        item.setUsingDescription(""); // TODO: add "successfulUseDescription"
        item.setCanBeUsedOn("sink");
        item.setTakeByHand(false);
        return item;
    }

    public Item createH2OCup(){
        item = new Item("H2O_cup");
        item.setCantTakeDescription(""); // TODO: add "cantTakeDescription"
        item.setUnableUseDescription(""); // TODO: add "unableUseDescription"
        item.setUsingDescription(""); // TODO: add "successfulUseDescription"
        item.setCanBeUsedOn(""); // TODO: [ IMPORTANT ] add what the item can be used on (name lab thingy)
        item.setTakeByHand(false);
        return item;
    }

    public Item createBroom() {
        item = new Item("broom");
        item.setUnableUseDescription(""); // TODO: add "unableUseDescription"
        item.setUsingDescription(""); // TODO: add "successfulUseDescription"
        item.setTakeByHand(true);
        item.setCanBeUsedOn("cup");
        return item;
    }

    public Item createAcid() {
        item = new Item("acid");
        item.setCantTakeDescription(""); // TODO: add "cantTakeDescription"
        item.setUnableUseDescription(""); // TODO: add "unableUseDescription"
        item.setUsingDescription(""); // TODO: add "successfulUseDescription"
        item.setCanBeUsedOn("door_handle");
        item.setTakeByHand(false);
        return item;
    }

    public Item createGloves() {
        item = new Item("gloves");
        item.setUnableUseDescription(""); // TODO: add "unableUseDescription"
        item.setUsingDescription(""); // TODO: add "successfulUseDescription"
        item.setTakeByHand(true);
        item.setCanBeUsedOn("leaf");
        return item;
    }
}
