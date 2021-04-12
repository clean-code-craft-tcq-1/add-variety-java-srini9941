package TypewiseAlert.model;

/**
 * @author Shrinidhi Muralidhar Karanam on 2021-04-12
 */
public class BatteryCharacter {

    private CoolingType coolingType;
    private String brand;

    public BatteryCharacter(
        CoolingType coolingType,
        String brand
    )
    {
        this.coolingType = coolingType;
        this.brand = brand;
    }

    public CoolingType getCoolingType() {
        return coolingType;
    }

    public void setCoolingType(CoolingType coolingType) {
        this.coolingType = coolingType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
