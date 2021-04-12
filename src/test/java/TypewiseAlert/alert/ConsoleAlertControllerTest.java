package TypewiseAlert.alert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import TypewiseAlert.model.BreachType;

import static org.junit.Assert.*;

/**
 * @author Shrinidhi Muralidhar Karanam on 2021-04-13
 */
@RunWith(Parameterized.class)
public class ConsoleAlertControllerTest {


    @Parameterized.Parameters
    public static Collection<Object[]> breachTypeValues () {
        BreachType[] breachTypes = BreachType.values();
        List<Object[]> data = new ArrayList<>();
        for (BreachType b: breachTypes) {
            data.add(new Object[]{b});
        }
        return data;
    }

    private final AlertController alertController;
    private final BreachType breachType;

    public ConsoleAlertControllerTest(BreachType breachType) {
        alertController = new ConsoleAlertController();
        this.breachType = breachType;
    }

    @Test
    public void testReport() {

        String message = alertController.report(breachType);

        assertEquals(String.format("65261 : %s\n", breachType.getValue()), message);
    }
}