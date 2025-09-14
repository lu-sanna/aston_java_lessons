package lesson2_4.task2;

import lesson2_4.task2.interfaces.Area;
import lesson2_4.task2.interfaces.Perimeter;

// Класс для круга
public class Circle extends GeometricShape {
    private double radius;

    // Конструтор для создания объекта Circle

    public Circle(double radius, String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.radius = radius;
    }

    // Метод вычисляет периметр круга

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    // Метод вычисляет площадь круга

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    //Метод возвращает название фигуры
    @Override
    public String getShapeName() {
        return "Круг";
    }

    @Override
    public void showInfo() {
        System.out.println("-----------------------\nФигура:");
        System.out.println(getShapeName());
        System.out.println("Периметр: " + perimeter());
        System.out.println("Площадь: " + area());
        System.out.println("Цвет фона: " + fillColor);
        System.out.println("Цвет границы: " + borderColor);
    }
}
