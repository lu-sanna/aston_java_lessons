package lesson2_7_TestNG;

public class Main {
    public static void main(String[] args) {
        // 1. Факториал
        System.out.println("== ЗАДАНИЕ 1 ==");
        System.out.println("Факториал 3: " + Factorial.factorial(6));

        // 2. Площадь треугольника
        System.out.println("\n== ЗАДАНИЕ 2 ==");
        System.out.println("Площадь треугольника (10, 5): " + TriangleArea.area(10, 5));

        // 3. Арифметические операции
        System.out.println("\n== ЗАДАНИЕ 3 ==");
        System.out.println("36 + 5 = " + Calculator.calculate(36, 5, "+"));
        System.out.println("-10 - 5 = " + Calculator.calculate(-10, 5, "-"));
        System.out.println("10 * 9 = " + Calculator.calculate(10, 9, "*"));
        System.out.println("24 / -5 = " + Calculator.calculate(24, -5, "/"));

        // 4. Сравнение чисел
        System.out.println("\n== ЗАДАНИЕ 4 ==");
        System.out.println("Сравнение 8 и 5: " + CompareNumbers.compare(8, 5));
        System.out.println("Сравнение 5 и 5: " + CompareNumbers.compare(5, 5));
        System.out.println("Сравнение -5 и 5: " + CompareNumbers.compare(-5, 5));
    }
}