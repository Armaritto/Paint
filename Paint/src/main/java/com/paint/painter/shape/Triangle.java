package com.paint.painter.shape;
import ch.qos.logback.core.joran.sanity.Pair;
public class Triangle extends Shape{
    public Triangle(double x, double y, String fill, boolean draggable) {
        super(x, y, fill, draggable);
    }
//    public Triangle(Pair<Integer, Integer> c, double a, String col) {
//        super(c, a, col);
//    }
}
