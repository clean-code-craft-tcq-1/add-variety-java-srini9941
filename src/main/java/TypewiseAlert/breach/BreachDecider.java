package TypewiseAlert.breach;

import TypewiseAlert.model.BreachType;
import TypewiseAlert.model.CoolingType;

/**
 * @author Shrinidhi Muralidhar Karanam on 2021-04-12
 */
public class BreachDecider {

    public BreachType inferBreach(
        double value,
        double lowerLimit,
        double upperLimit
    )
    {
        if(value < lowerLimit) {
            return BreachType.TOO_LOW;
        }
        if(value > upperLimit) {
            return BreachType.TOO_HIGH;
        }
        return BreachType.NORMAL;
    }

    public BreachType classifyTemperatureBreach(
        CoolingType coolingType,
        double temperatureInC
    )
    {
        return inferBreach(temperatureInC, coolingType.getLowerLimit(), coolingType.getUpperLimit());
    }

}
