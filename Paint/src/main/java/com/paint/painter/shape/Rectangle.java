package com.paint.painter.shape;
import ch.qos.logback.core.joran.sanity.Pair;
public class Rectangle extends Shape{
    private double width;
    private double height;

    public Rectangle(double width, double height, double x, double y, String fill, boolean draggable) {
        super();
    }

    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }


//    public Rectangle(Pair<Integer, Integer> c, double a, String col) {
//        super(c, a, col);
//    }
}
