package TypewiseAlert.alert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import TypewiseAlert.model.BreachType;

import static org.junit.Assert.*;

/**
 * @author Shrinidhi Muralidhar Karanam on 2021-04-13
 */
@RunWith(Parameterized.class)
public class EmailAlertControllerTest {

    @Parameterized.Parameters
    public static Collection<Object[]> breachTypeValues () {
        BreachType[] breachTypes = BreachType.values();
        List<Object[]> data = new ArrayList<>();
        for (BreachType b: breachTypes) {
            if (b != BreachType.NORMAL) {
                data.add(new Object[]{b});
            }
        }
        return data;
    }

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