package TypewiseAlert.breach;

import org.junit.Test;

import TypewiseAlert.model.BreachType;

import static org.junit.Assert.*;

/**
 * @author Shrinidhi Muralidhar Karanam on 2021-04-12
 */
public class BreachDeciderTest {

    public static final int LOWER_LIMIT = 20;
    public static final int UPPER_LIMIT = 30;

    @Test
    public void infersBreachAsPerLimits_returnsTooLow()
    {
        assertSame(BreachType.TOO_LOW, new BreachDecider().inferBreach(12, LOWER_LIMIT, UPPER_LIMIT));
    }

    @Test
    public void inferBreachAsPerLimits_returnsTooHigh() {
        assertSame(BreachType.TOO_HIGH, new BreachDecider().inferBreach(35, LOWER_LIMIT, UPPER_LIMIT));
    }

    @Test
    public void inferBreachAsPerLimits_returnsNormal() {
        assertSame(BreachType.NORMAL, new BreachDecider().inferBreach(25, LOWER_LIMIT, UPPER_LIMIT));
    }

}