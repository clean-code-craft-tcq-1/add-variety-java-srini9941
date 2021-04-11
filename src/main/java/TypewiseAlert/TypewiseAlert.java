package TypewiseAlert;

import TypewiseAlert.breach.BreachDecider;
import TypewiseAlert.model.AlertTarget;
import TypewiseAlert.model.BreachType;
import TypewiseAlert.model.CoolingType;

public class TypewiseAlert {

    public static BreachType classifyTemperatureBreach(
        CoolingType coolingType,
        double temperatureInC
    )
    {
        return BreachDecider.inferBreach(temperatureInC, coolingType.getLowerLimit(), coolingType.getUpperLimit());
    }

    public static void checkAndAlert(
        AlertTarget alertTarget,
        BatteryCharacter batteryChar,
        double temperatureInC
    )
    {

        BreachType breachType = classifyTemperatureBreach(
            batteryChar.coolingType, temperatureInC
        );

        switch (alertTarget) {
            case TO_CONTROLLER:
                sendToController(breachType);
                break;
            case TO_EMAIL:
                sendToEmail(breachType);
                break;
        }
    }

    public static void sendToController(BreachType breachType) {
        int header = 0xfeed;
        System.out.printf("%i : %i\n", header, breachType);
    }

    public static void sendToEmail(BreachType breachType) {
        String recepient = "a.b@c.com";
        switch (breachType) {
            case TOO_LOW:
                System.out.printf("To: %s\n", recepient);
                System.out.println("Hi, the temperature is too low\n");
                break;
            case TOO_HIGH:
                System.out.printf("To: %s\n", recepient);
                System.out.println("Hi, the temperature is too high\n");
                break;
            case NORMAL:
                break;
        }
    }

    public class BatteryCharacter {

        public CoolingType coolingType;
        public String brand;
    }
}
