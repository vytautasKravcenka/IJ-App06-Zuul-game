/**
 * add description here
 */
public class Item {
    private final String name;
    private final String usingDescription;
    private final String unableUseDescription;
    private final String cantTakeDescription;
    private Boolean takeByHand;

    public Item (String name, String trueDescription, String falseDescription, String notTakeByHands , Boolean takeByHand)
    {
        this.name = name;
        usingDescription = trueDescription;
        unableUseDescription = falseDescription;
        cantTakeDescription = notTakeByHands;
        this.takeByHand = takeByHand;
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

    public Boolean getTakeByHand() {
        return takeByHand;
    }

    public String getCantTakeDescription() {
        return cantTakeDescription;
    }
}
