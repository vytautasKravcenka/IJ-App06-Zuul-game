public class ItemsGenerator {
    private Item item;

    public Item createLeaf() {
        item = new Item("leaf", "", "","", true);
        return item;
    }

    public Item createCrowbar() {
        item = new Item("crowbar", "", "","" ,true);
        return item;
    }

    public Item createKey() {
        item = new Item("key", "", "","", true);
        return item;
    }

    public Item createCup() {
        item = new Item("cup", "", "", "",false);
        return item;
    }

    public Item createBroom() {
        item = new Item("broom", "", "","", true);
        return item;
    }

    public Item createAcid() {
        item = new Item("acid", "", "","", false);
        return item;
    }

    public Item createGloves() {
        item = new Item("gloves", "", "", "",true);
        return item;
    }
}
