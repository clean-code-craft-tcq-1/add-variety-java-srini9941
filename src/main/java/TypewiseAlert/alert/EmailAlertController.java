package TypewiseAlert.alert;

import TypewiseAlert.model.BreachType;

/**
 * @author Shrinidhi Muralidhar Karanam on 2021-04-12
 */
public class EmailAlertController implements AlertController {

    @Override
    public void report(BreachType breachType) {
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
}
