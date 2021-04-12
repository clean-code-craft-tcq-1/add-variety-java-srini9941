package TypewiseAlert;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.*;

import TypewiseAlert.alert.AlertController;
import TypewiseAlert.alert.AlertControllerFactory;
import TypewiseAlert.breach.BreachDecider;
import TypewiseAlert.model.AlertTarget;
import TypewiseAlert.model.BatteryCharacter;
import TypewiseAlert.model.BreachType;
import TypewiseAlert.model.CoolingType;

@RunWith(MockitoJUnitRunner.class)
public class TypewiseAlertTest {

    private static final BreachType BREACH_TYPE = BreachType.TOO_LOW;
    private final AlertController alertController = new FakeAlertController();
    @Mock
    private AlertControllerFactory alertControllerFactory;
    @Mock
    private BreachDecider breachDecider;
    private TypewiseAlert typewiseAlert;

    @Before
    public void init () {
        typewiseAlert = new TypewiseAlert(alertControllerFactory, breachDecider);
    }
    @Test
    public void testTypeWiseAlert() {
        when(alertControllerFactory.getAlertController(any())).thenReturn(alertController);
        when(breachDecider.classifyTemperatureBreach(any(), anyDouble())).thenReturn(BREACH_TYPE);

        String alert = typewiseAlert.checkAndAlert(AlertTarget.TO_CONTROLLER,
            new BatteryCharacter(CoolingType.HI_ACTIVE_COOLING, "Brand"),
            -1.5
        );

        assertEquals("Reporting from fake alert controller with breach type : too low", alert);

    }

    private class FakeAlertController implements AlertController {

        @Override
        public String report(BreachType breachType) {
            return String.format("Reporting from fake alert controller with breach type : %s", breachType.getValue());
        }
    }

}
