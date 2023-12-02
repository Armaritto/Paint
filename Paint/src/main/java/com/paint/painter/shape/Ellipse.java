package com.paint.painter.shape;
import ch.qos.logback.core.joran.sanity.Pair;
public class Ellipse extends Shape {
    private double radiusX;
    private double radiusY;

    public Ellipse(double x, double y, String fill, boolean draggable) {
        super(x, y, fill, draggable);
    }

    public double getRadiusX() {
        return radiusX;
    }
    public void setRadiusX(double radiusX) {
        this.radiusX = radiusX;
    }
    public double getRadiusY() {
        return radiusY;
    }
    public void setRadiusY(double radiusY) {
        this.radiusY = radiusY;
    }

//    public Ellipse(Pair<Integer, Integer> c, double a, String col) {
//        super(c, a, col);
//    }
}
