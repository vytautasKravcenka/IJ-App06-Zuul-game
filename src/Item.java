/**
 *  Item class is for information about item setting and getting.
 *  version 2020.01.10
 *  Modified by Vytautas Kravcenka
 */
public class Item {
    private final String name;
    private String canBeUsedOn;

    private String usingDescription;

    private String cantTakeDescription;

    private boolean takeByHand;
    private boolean ignoreInRoom;

    public Item (String name)
    {
        this.name = name;
    }


    public String getUsingDescription() {
        return usingDescription;
    }

    public void setUsingDescription(String usingDescription) {
        this.usingDescription = usingDescription;
    }

    public String getCantTakeDescription() {
        return cantTakeDescription;
    }

    public void setCantTakeDescription(String cantTakeDescription) {
        this.cantTakeDescription = cantTakeDescription;
    }

    public String getName() {
        return name;
    }

    public boolean getTakeByHand() {
        return takeByHand;
    }

    public void setTakeByHand(Boolean takeByHand) {
        this.takeByHand = takeByHand;
    }

    public String getCanBeUsedOn() {
        return canBeUsedOn;
    }

    public void setCanBeUsedOn(String canBeUsedOn) {
        this.canBeUsedOn = canBeUsedOn;
    }

    public boolean getIgnoreInRoom() {
        return ignoreInRoom;
    }

    public void setIgnoreInRoom(Boolean ignoreInRoom) {
        this.ignoreInRoom = ignoreInRoom;
    }
}
