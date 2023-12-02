package com.paint.painter.shape;
import ch.qos.logback.core.joran.sanity.Pair;
public class Circle extends Shape{
    private double radius;

    public Circle(double x, double y, String fill, boolean draggable) {
        super(x, y, fill, draggable);
    }

    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
//    public Circle(Pair<Integer, Integer> c, double a, String col) {
//        super(c, a, col);
//    }
}
