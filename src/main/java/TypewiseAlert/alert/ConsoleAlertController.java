package TypewiseAlert.alert;

import TypewiseAlert.model.BreachType;

/**
 * @author Shrinidhi Muralidhar Karanam on 2021-04-12
 */
public class ConsoleAlertController implements AlertController {

    @Override
    public void report(BreachType breachType) {
        int header = 0xfeed;
        System.out.printf("%i : %i\n", header, breachType);
    }
}
