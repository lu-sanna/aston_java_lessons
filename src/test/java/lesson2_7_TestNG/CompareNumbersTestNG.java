package lesson2_7_TestNG;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class CompareNumbersTestNG {
    @Test
    public void testCompareNumb(){
        assertEquals(CompareNumbers.compare(8,5),"8 больше 5");
    }

    @Test
    public void testCompareEqual(){
        assertEquals(CompareNumbers.compare(5,5),"5 равно 5");
    }

    @Test
    public void testCompareNegativeNumbers(){
        assertEquals(CompareNumbers.compare(-5,5), "-5 меньше 5");
    }
}
