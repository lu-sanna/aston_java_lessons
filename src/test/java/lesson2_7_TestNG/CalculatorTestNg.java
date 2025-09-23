package lesson2_7_TestNG;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class CalculatorTestNg {
    //сложение
    @Test
    public void testCalculateAdd(){
       assertEquals(Calculator.calculate(36,5,"+"),41);
       assertEquals(Calculator.calculate(-10, 5, "+"), -5);
       assertEquals(Calculator.calculate(0, 5, "+"), 5);
   }

    //вычитание
   @Test
   public void testCalculateSubtraction(){
       assertEquals(Calculator.calculate(10, 5, "-"), 5);
       assertEquals(Calculator.calculate(-10, 5, "-"), -15);
       assertEquals(Calculator.calculate(-10, -5, "-"), -5);
   }

    //умножение
   @Test
   public void testCalculateMultiplication(){
       assertEquals(Calculator.calculate(10, 9, "*"), 90);
       assertEquals(Calculator.calculate(-10, 5, "*"), -50);
       assertEquals(Calculator.calculate(-10, -5, "*"), 50);
   }

    //деление
    @Test
    public void testCalculateDivision() {
        assertEquals(Calculator.calculate(24, 5, "/"), 4);
        assertEquals(Calculator.calculate(-10, 5, "/"), -2);
    }

    //деление на ноль
    @Test(expectedExceptions = ArithmeticException.class)
    public void testCalculateZero() {
        Calculator.calculate(10, 0, "/");
    }
}


