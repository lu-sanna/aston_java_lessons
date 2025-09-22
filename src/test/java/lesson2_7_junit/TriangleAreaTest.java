package lesson2_7_junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleAreaTest {
    //проверка равенства, тест валидных значений
    @Test
    void testAreaValidVal(){
        assertEquals(25.0, TriangleArea.area(10,5));
    }

    //проверка исключений, тест невалидных значений
    @Test
    void testAreaInvalidVal(){
        assertThrows(IllegalArgumentException.class, () -> TriangleArea.area(-1,5));
    }
}
