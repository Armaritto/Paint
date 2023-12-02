package com.paint.painter.shape;
import ch.qos.logback.core.joran.sanity.Pair;
public class Shape {
    private double x;
    private double y;
    private String fill;

    public Shape(double x, double y, String fill, boolean draggable) {
        this.x = x;
        this.y = y;
        this.fill = fill;
        this.draggable = draggable;
    }

    private boolean draggable;

    public Shape() {

    }

    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public String getFill() {
        return fill;
    }
    public void setFill(String fill) {
        this.fill = fill;
    }
    public boolean isDraggable() {
        return draggable;
    }
    public void setDraggable(boolean draggable) {
        this.draggable = draggable;
    }


//    private Pair<Integer,Integer> center;
//    private double angle;
//    private String color;
//    public Shape(Pair<Integer,Integer> c , double a , String col){
//        this.center = c;
//        this.angle = a;
//        this.color = col;
//    }
//    public void setAngle(double angle) {
//        this.angle = angle;
//    }
//    public Pair<Integer, Integer> getCenter() {
//        return center;
//    }
//    public void setCenter(Pair<Integer, Integer> center) {
//        this.center = center;
//    }
//    public void setColor(String color) {
//        this.color = color;
//    }
//    public double getAngle() {
//        return angle;
//    }
//    public String getColor() {
//        return color;
//    }


//    public void move (Pair<Integer,Integer> center){
//        setCenter(center);
//    }
}

