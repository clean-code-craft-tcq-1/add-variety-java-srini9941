package TypewiseAlert;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import TypewiseAlert.breach.BreachDecider;
import TypewiseAlert.model.BreachType;

public class TypewiseAlertTest 
{
    @Test
    public void infersBreachAsPerLimits()
    {
      assertTrue(BreachDecider.inferBreach(12, 20, 30) ==
        BreachType.TOO_LOW);
    }
}
