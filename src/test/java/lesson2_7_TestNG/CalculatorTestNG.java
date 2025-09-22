package lesson2_7_TestNG;

public class CalculatorTestNG {
    public static int calculate(int a, int b, String operation){
switch (operation) {
    case "+":
        return a+b;
    case "-":
        return a-b;
    case "*":
        return a*b;
    case "/":
        if (b == 0) {
            throw new ArithmeticException("Делить на ноль нельзя!");
        }
    }
        return a/b;
    }
}
