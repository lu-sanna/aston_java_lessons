package lesson2_7_junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest  {
    @Test
    void testCalculateAdd(){
        assertEquals(41, Calculator.calculate(36,5, "+"));
        assertEquals(-5, Calculator.calculate(-10,5, "+"));
        assertEquals(5, Calculator.calculate(0,5, "+"));
}

    @Test
    void testCalculateSubtraction(){
        assertEquals(5, Calculator.calculate(10,5, "-"));
        assertEquals(-15, Calculator.calculate(-10,5, "-"));
        assertEquals(-5, Calculator.calculate(-10,-5, "-"));
    }

    @Test
    void testCalculateMultiplication(){
        assertEquals(90, Calculator.calculate(10,9, "*"));
        assertEquals(-50, Calculator.calculate(-10,5, "*"));
        assertEquals(50, Calculator.calculate(-10,-5, "*"));
    }

    @Test
    void testCalculateDivision(){
        assertEquals(4, Calculator.calculate(24,5, "/"));
        assertEquals(-2, Calculator.calculate(-10,5, "/"));

    }

    @Test
    void testCalculateZero(){
        assertThrows(ArithmeticException.class, ()-> Calculator.calculate(10,0,"/"));
    }
}
