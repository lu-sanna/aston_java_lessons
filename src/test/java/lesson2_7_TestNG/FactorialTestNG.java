package lesson2_7_TestNG;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class FactorialTestNG {
@Test
void FactorialPositiveNumb(){
    assertEquals(Factorial.factorial(2),2);
}
@Test
    void testFactorialZero() {
    assertEquals(Factorial.factorial(0),1);
    }

}
