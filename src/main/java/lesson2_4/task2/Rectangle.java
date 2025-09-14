package lesson2_4.task2;

// Класс для прямоугольника
public class Rectangle extends GeometricShape {

    private double width;
    private double height;

    // Конструктор для создания объекта Rectangle
    public Rectangle(double width, double height, String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.width = width;
        this.height = height;
    }

    @Override
    public double perimeter() {

        return 2 * (width + height);
    }

    @Override
    public double area() {
        return width * height;
    }
    // Метод возвращает название фигуры
    @Override
    public String getShapeName() {
        return "Прямоугольник";
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
