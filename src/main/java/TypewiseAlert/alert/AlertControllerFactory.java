package TypewiseAlert.alert;

import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import TypewiseAlert.model.AlertTarget;

/**
 * @author Shrinidhi Muralidhar Karanam on 2021-04-12
 */
public class AlertControllerFactory {

    private static final Map<AlertTarget, AlertController> alertControllers = Stream.of(
        new AbstractMap.SimpleImmutableEntry<>(AlertTarget.TO_CONTROLLER, new ConsoleAlertController()),
        new AbstractMap.SimpleImmutableEntry<>(AlertTarget.TO_EMAIL, new EmailAlertController())
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public AlertController getAlertController(AlertTarget alertTarget) {
        if (alertControllers.containsKey(alertTarget)){
            return alertControllers.get(alertTarget);
        }
        return null;
    }

}
