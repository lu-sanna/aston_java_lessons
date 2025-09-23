package lesson2_7_junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest  {
//проверка равенства
    @Test
    void testFactorialPositiveNumb(){
        assertEquals(1, Factorial.factorial(1));
        assertEquals(2, Factorial.factorial(2));
        assertEquals(6, Factorial.factorial(3));
        assertEquals(24, Factorial.factorial(4));
        assertEquals(120, Factorial.factorial(5));
    }

    @Test
    void testFactorialZero() {
        assertEquals(1, Factorial.factorial(0));
    } //0! = 1

    //проверка исключений
    @Test
    void testFactorialNegativeNumb() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Factorial.factorial(-2);
        });
        assertEquals("Число должно быть целым и положительным.", exception.getMessage());
    }
}
