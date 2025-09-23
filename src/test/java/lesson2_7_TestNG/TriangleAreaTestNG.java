package lesson2_7_TestNG;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class TriangleAreaTestNG {
    @Test
    public void testAreaValidVal(){
        assertEquals(TriangleArea.area(10,5),25);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAreaInvalidVal() {
        TriangleArea.area(-10, 5);
    }
}
