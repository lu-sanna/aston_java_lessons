package lesson2_7_junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
@Test
void testCalculateAdd(){
    assertEquals(41, Calculator.calculate(36,5, "+"));
}

    @Test
    void testCalculateSubtraction(){
        assertEquals(-15, Calculator.calculate(-10,5, "-"));
    }

    @Test
    void testCalculateMultiplication(){
        assertEquals(90, Calculator.calculate(10,9, "*"));
    }

    @Test
    void testCalculateDivision(){
        assertEquals(4.8, Calculator.calculate(24,5, "/"));
    }

    @Test
    void testCalculateZero(){
    assertThrows(ArithmeticException.class, ()-> Calculator.calculate(10,0,"/"));
    }
}
