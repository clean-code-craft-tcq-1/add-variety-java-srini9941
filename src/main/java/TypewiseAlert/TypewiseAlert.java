package TypewiseAlert;

import TypewiseAlert.alert.AlertController;
import TypewiseAlert.alert.AlertControllerFactory;
import TypewiseAlert.breach.BreachDecider;
import TypewiseAlert.model.AlertTarget;
import TypewiseAlert.model.BatteryCharacter;
import TypewiseAlert.model.BreachType;
import TypewiseAlert.model.CoolingType;

public class TypewiseAlert {
    private final AlertControllerFactory alertControllerFactory;
    private final BreachDecider breachDecider;

    public TypewiseAlert(AlertControllerFactory alertControllerFactory, BreachDecider breachDecider){
        this.alertControllerFactory = alertControllerFactory;
        this.breachDecider = breachDecider;
    }

    public String checkAndAlert(
        AlertTarget alertTarget,
        BatteryCharacter batteryChar,
        double temperatureInC
    )
    {
        if(batteryChar != null) {
            BreachType breachType = breachDecider.classifyTemperatureBreach(
                batteryChar.getCoolingType(), temperatureInC
            );

            AlertController alertController = alertControllerFactory.getAlertController(alertTarget);
            assert alertController != null;
            return alertController.report(breachType);
        }
        return null;
    }

}
