package lesson2_7_junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CompareNumbersTest {
    @Test
    void testCompareNumb() {
        assertEquals("8 больше 5", CompareNumbers.compare(8,5));
    }

    @Test
    void testCompareEqual(){
        assertEquals("5 равно 5", CompareNumbers.compare(5,5));
    }

    @Test
    void testCompareNegativeNumbers(){
        assertEquals("-5 меньше 5", CompareNumbers.compare(-5,5));
    }
}