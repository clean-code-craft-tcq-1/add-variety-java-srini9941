package TypewiseAlert.alert;

import TypewiseAlert.model.BreachType;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class AlertControllerTest {


    @Parameterized.Parameters
    public static Collection<Object[]> breachTypeValues () {
        BreachType[] breachTypes = BreachType.values();
        List<Object[]> data = new ArrayList<>();
        for (BreachType b: breachTypes) {
            data.add(new Object[]{b});
        }
        return data;
    }
}
