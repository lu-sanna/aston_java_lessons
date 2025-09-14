package lesson2_4.task2;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(6, "Синий", "Черный");
        circle.showInfo();

        Rectangle rectangle = new Rectangle(6, 3, "Жёлтый", "Зелёный");
        rectangle.showInfo();
        Triangle triangle = new Triangle(6, 6, 6, "Серый", "Красный");
        triangle.showInfo();
    }
}
