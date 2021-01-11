public class ItemsGenerator {
    private Item item;

    public Item createLeaf() {
        item = new Item("leaf");
        item.setUsingDescription(""); // TODO: add "successfulUseDescription"
        item.setTakeByHand(true);
        item.setCanBeUsedOn("mixer");
        return item;
    }

    public Item createCrowbar() {
        item = new Item("crowbar");
        item.setUsingDescription(""); // TODO: add "successfulUseDescription"
        item.setTakeByHand(true);
        item.setCanBeUsedOn("lock");
        return item;
    }

    public Item createKey() {
        item = new Item("key");
        item.setUsingDescription(""); // TODO: add "successfulUseDescription"
        item.setTakeByHand(true);
        item.setCanBeUsedOn("door");
        return item;
    }

    public Item createCup() {
        item = new Item("cup");
        item.setCantTakeDescription(""); // TODO: add "cantTakeDescription"
        item.setUsingDescription(""); // TODO: add "successfulUseDescription"
        item.setCanBeUsedOn("sink");
        item.setTakeByHand(false);
        return item;
    }

    public Item createH2OCup(){
        item = new Item("H2O_cup");
        item.setCantTakeDescription("Don't cheat!"); // TODO: add "cantTakeDescription"
        item.setUsingDescription(""); // TODO: add "successfulUseDescription"
        item.setCanBeUsedOn("mixer");
        item.setTakeByHand(false);
        return item;
    }

    public Item createBroom() {
        item = new Item("broom");
        item.setUsingDescription(""); // TODO: add "successfulUseDescription"
        item.setTakeByHand(true);
        item.setCanBeUsedOn("cup");
        return item;
    }

    public Item createAcid() {
        item = new Item("acid");
        item.setCantTakeDescription(""); // TODO: add "cantTakeDescription"
        item.setUsingDescription(""); // TODO: add "successfulUseDescription"
        item.setCanBeUsedOn("door_handle");
        item.setTakeByHand(false);
        return item;
    }

    public Item createGloves() {
        item = new Item("gloves");
        item.setUsingDescription(""); // TODO: add "successfulUseDescription"
        item.setTakeByHand(true);
        item.setCanBeUsedOn("leaf");
        return item;
    }
}
