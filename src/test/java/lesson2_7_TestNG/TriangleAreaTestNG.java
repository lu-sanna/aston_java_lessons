package lesson2_7_TestNG;

public class TriangleAreaTestNG {
    public static double area (double a, double h) { // a - основание треугольника , h - выста треугольника
        if (a <= 0 || h <= 0) {
            throw new IllegalArgumentException("Основание и высота треугольника должны быть положительными");
        }
        return (a * h) / 2;

    }
}
