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

    public TypewiseAlert(AlertControllerFactory alertControllerFactory){
        this.alertControllerFactory = alertControllerFactory;
    }

    public BreachType classifyTemperatureBreach(
        CoolingType coolingType,
        double temperatureInC
    )
    {
        return BreachDecider.inferBreach(temperatureInC, coolingType.getLowerLimit(), coolingType.getUpperLimit());
    }

    public void checkAndAlert(
        AlertTarget alertTarget,
        BatteryCharacter batteryChar,
        double temperatureInC
    )
    {

        BreachType breachType = classifyTemperatureBreach(
            batteryChar.getCoolingType(), temperatureInC
        );

        AlertController alertController = alertControllerFactory.getAlertController(alertTarget);
        assert alertController != null;
        alertController.report(breachType);
    }

}
