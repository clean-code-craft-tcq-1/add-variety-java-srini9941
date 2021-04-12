package TypewiseAlert.alert;

import TypewiseAlert.model.BreachType;

/**
 * @author Shrinidhi Muralidhar Karanam on 2021-04-12
 */
public class EmailAlertController implements AlertController {

    @Override
    public String report(BreachType breachType) {
        String recepient = "a.b@c.com";
        String toRecepient = String.format("To: %s\n", recepient);
        String reportMessage;
        if (breachType != BreachType.NORMAL) {
            reportMessage = "Hi, the temperature is " + breachType.getValue() + "\n";
            String reportString = toRecepient + "\n" + reportMessage;
            System.out.println(reportString);
            return reportString;
        }
        return null;
    }
}
