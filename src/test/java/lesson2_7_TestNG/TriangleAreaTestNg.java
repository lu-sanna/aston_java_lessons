package lesson2_7_TestNG;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.DataProvider;

public class TriangleAreaTestNg {
    @Test
    public void testAreaValidVal(){
        assertEquals(TriangleArea.area(10,5),25);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAreaInvalidVal() {
        TriangleArea.area(-10, 5);
    }

    @DataProvider (name = "areaData")
    public Object[][] areaData() {
        return new Object[][]{
                {10.0, 5.0, 25.0},
                {5.0, 5.0, 12.5},
                {8.0, 3.0, 12.0}
        };
    }

    @Test(dataProvider = "areaData")
    public void testCalculateAreaParameterized(double a, double h, double expected) {
        assertEquals(TriangleArea.area(a, h), expected, 0.001);
    }
}
