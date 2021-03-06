package TypewiseAlert.alert;

import org.junit.Test;

import TypewiseAlert.model.BreachType;

import static org.junit.Assert.*;

/**
 * @author Shrinidhi Muralidhar Karanam on 2021-04-13
 */
public class EmailAlertControllerTest extends AlertControllerTest{

    private final AlertController alertController;

    public EmailAlertControllerTest(BreachType breachType) {
        super(breachType);
        alertController = new EmailAlertController();
    }

    @Test
    public void testReport() {
        String message = alertController.report(breachType);
        if (breachType == BreachType.NORMAL) {
            assertNull(message);
        } else {
            assertEquals(String.format("To: a.b@c.com\n" +
                    "\n" +
                    "Hi, the temperature is %s", breachType.getValue() + "\n"), message);
        }
    }
}