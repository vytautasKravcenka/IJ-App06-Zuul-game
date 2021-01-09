/**
 * add description here
 */
public class Item {
    private final String name;
    private String usableName;
    private String usingDescription;
    private String unableUseDescription;
    private String cantTakeDescription;
    private String canBeUsedOn;
    private Boolean takeByHand;
    private Boolean isUsable;
    private Boolean ignoreInRoom;

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

    public Boolean getTakeByHand() {
        return takeByHand;
    }

    public void setTakeByHand(Boolean takeByHand) {
        this.takeByHand = takeByHand;
    }

    public Boolean getUsable() {
        return isUsable;
    }

    public void setUsable(Boolean usable) {
        isUsable = usable;
    }

    public String getCanBeUsedOn() {
        return canBeUsedOn;
    }

    public void setCanBeUsedOn(String canBeUsedOn) {
        this.canBeUsedOn = canBeUsedOn;
    }

    public Boolean getIgnoreInRoom() {
        return ignoreInRoom;
    }

    public void setIgnoreInRoom(Boolean ignoreInRoom) {
        this.ignoreInRoom = ignoreInRoom;
    }

    public String getUsableName() {
        return usableName;
    }

    public void setUsableName(String usableName) {
        this.usableName = usableName;
    }
}
