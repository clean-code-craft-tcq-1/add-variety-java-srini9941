package TypewiseAlert.alert;

import TypewiseAlert.model.BreachType;

/**
 * Console alerter.
 *
 * @author Shrinidhi Muralidhar Karanam on 2021-04-12
 */
public class ConsoleAlertController implements AlertController {

    @Override
    public String report(BreachType breachType) {
        int header = 0xfeed;
        String reportMessage = String.format("%d : %s\n", header, breachType.getValue());
        System.out.println(reportMessage);
        return reportMessage;
    }
}
