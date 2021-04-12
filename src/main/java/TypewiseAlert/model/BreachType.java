package TypewiseAlert.model;


/**
 * @author Shrinidhi Muralidhar Karanam on 2021-04-12
 */
public enum BreachType {

    NORMAL("normal"),
    TOO_LOW("too low"),
    TOO_HIGH("too high");

    private final String value;

    BreachType (String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
