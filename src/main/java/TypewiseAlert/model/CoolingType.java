package TypewiseAlert.model;

/**
 * @author Shrinidhi Muralidhar Karanam on 2021-04-12
 */
public enum CoolingType {
    PASSIVE_COOLING(0, 35),
    HI_ACTIVE_COOLING(0, 45),
    MED_ACTIVE_COOLING(0, 40);

    private final int lowerLimit;
    private final int upperLimit;

    CoolingType(int lowerLimit, int upperLimit) {
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
    }

    public int getLowerLimit() {
        return lowerLimit;
    }

    public int getUpperLimit() {
        return upperLimit;
    }
}
