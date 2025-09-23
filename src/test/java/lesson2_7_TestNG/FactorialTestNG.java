package lesson2_7_TestNG;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class FactorialTestNG {
    @Test
    public void FactorialPositiveNumb(){
        assertEquals(Factorial.factorial(1), 1);
        assertEquals(Factorial.factorial(2), 2);
        assertEquals(Factorial.factorial(3), 6);
        assertEquals(Factorial.factorial(4), 24);
        assertEquals(Factorial.factorial(5), 120);
    }
    @Test
    public void testFactorialZero() {
        assertEquals(Factorial.factorial(0),1); //0! = 1
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegativeNumb() {
        Factorial.factorial(-100);
    }
}
