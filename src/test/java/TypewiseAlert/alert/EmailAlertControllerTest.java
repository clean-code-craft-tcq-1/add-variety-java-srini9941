package TypewiseAlert.alert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import TypewiseAlert.model.BreachType;

import static org.junit.Assert.*;

/**
 * @author Shrinidhi Muralidhar Karanam on 2021-04-13
 */
@RunWith(Parameterized.class)
public class EmailAlertControllerTest extends AlertControllerTest{

    private final AlertController alertController;
    private final BreachType breachType;

    public EmailAlertControllerTest(BreachType breachType) {
        alertController = new EmailAlertController();
        this.breachType = breachType;
    }

    @Test
    public void testReport() {
        String message = alertController.report(breachType);
        assertEquals(String.format("To: a.b@c.com\n" +
            "\n" +
            "Hi, the temperature is %s", breachType.getValue() + "\n"), message);
    }

    @Test
    public void testReport_whenNormal () {
        String message = alertController.report(BreachType.NORMAL);
        assertNull(message);
    }
}