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
public class ConsoleAlertControllerTest extends AlertControllerTest{


    private final AlertController alertController;

    public ConsoleAlertControllerTest(BreachType breachType) {
        super(breachType);
        alertController = new ConsoleAlertController();
    }

    @Test
    public void testReport() {

        String message = alertController.report(breachType);

        assertEquals(String.format("65261 : %s\n", breachType.getValue()), message);
    }
}