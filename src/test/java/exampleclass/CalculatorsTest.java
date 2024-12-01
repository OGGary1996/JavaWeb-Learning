package exampleclass;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorsTest {
    @Test
    public void testAdd() {
        Calculators calc1 = new Calculators();
        int result = calc1.add(1, 2);
        assertEquals(3, result);
    }

    @Test
    public void testDiv(){
        Calculators calc2 = new Calculators();
        double result = calc2.div(10, 5);
        assertEquals(2.0, result, 0.0001);
    }
}
