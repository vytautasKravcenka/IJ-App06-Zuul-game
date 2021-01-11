/**
 * TODO: add description here
 */
public class Item {
    private final String name;
    private String canBeUsedOn;

    private String usingDescription;
    private String unableUseDescription;

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

    public String getUnableUseDescription() {
        return unableUseDescription;
    }

    public void setUnableUseDescription(String unableUseDescription) {
        this.unableUseDescription = unableUseDescription;
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
