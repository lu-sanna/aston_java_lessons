package lesson2_7_junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest {
//проверка равенства
    @Test
    void testFactorialPositiveNumb(){
        assertEquals(2, Factorial.factorial(2));
    }
    @Test
    void testFactorialZero() {
        assertEquals(1, Factorial.factorial(0));
    }
//проверка исключений
    @Test
    void testFactorialExceptionForNegativeNumb() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Factorial.factorial(-2);
        });
        assertEquals("Число должно быть целым и положительным.", exception.getMessage());
    }
}
