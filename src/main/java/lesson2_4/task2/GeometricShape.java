package lesson2_4.task2;

import lesson2_4.task2.interfaces.Area;
import lesson2_4.task2.interfaces.Perimeter;

public abstract class GeometricShape implements Perimeter, Area {
    public String fillColor;
    public String borderColor;

    public GeometricShape(String fillColor, String borderColor) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public String getFillColor() {
        return fillColor;
    }

    public String getBorderColor() {
        return borderColor;
    }
    @Override
    public abstract double area();

    @Override
    public abstract double perimeter();

    public abstract String getShapeName();

    public abstract void showInfo();
}
