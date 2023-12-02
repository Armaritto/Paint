package com.paint.painter.shape;
import ch.qos.logback.core.joran.sanity.Pair;
public class Line extends Shape{
    private double endX;
    private double endY;

    public Line(double x, double y, String fill, boolean draggable) {
        super(x, y, fill, draggable);
    }

    public double getEndX() {
        return endX;
    }
    public void setEndX(double endX) {
        this.endX = endX;
    }
    public double getEndY() {
        return endY;
    }
    public void setEndY(double endY) {
        this.endY = endY;
    }
//    public Line(Pair<Integer,Integer> c , double a , String col){
//        super(c,a,col);
//    }
//    public void setStartPoint(Pair<Integer, Integer> startPoint) {
//        this.startPoint = startPoint;
//    }
//    public void setEndPoint(Pair<Integer, Integer> endPoint) {
//        this.endPoint = endPoint;
//    }
//    public Pair<Integer, Integer> getStartPoint() {
//        return startPoint;
//    }
//    public Pair<Integer, Integer> getEndPoint() {
//        return endPoint;
//    }
}
