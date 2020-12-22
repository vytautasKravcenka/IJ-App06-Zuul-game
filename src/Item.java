/**
 * add description here
 */
public class Item {
    private final String name;
    private final String usingDescription;
    private final String unableUseDescription;
    private Boolean fewActionsNeeded;

    public Item (String name, String trueDescription, String falseDescription, Boolean takeByHand)
    {
        this.name = name;
        usingDescription = trueDescription;
        unableUseDescription = falseDescription;
        fewActionsNeeded = takeByHand;
    }

    public String getName() {
        return name;
    }

    public String getUnableUseDescription() {
        return unableUseDescription;
    }

    public String getUsingDescription() {
        return usingDescription;
    }
}
