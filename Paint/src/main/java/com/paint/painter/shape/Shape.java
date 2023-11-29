package com.paint.painter.shape;
import ch.qos.logback.core.joran.sanity.Pair;
public class Shape {
    private Pair<Integer,Integer> center;
    private double angle;
    private String color;
    public Shape(Pair<Integer,Integer> c , double a , String col){
        this.center = c;
        this.angle = a;
        this.color = col;
    }
    public void setAngle(double angle) {
        this.angle = angle;
    }
    public Pair<Integer, Integer> getCenter() {
        return center;
    }
    public void setCenter(Pair<Integer, Integer> center) {
        this.center = center;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public double getAngle() {
        return angle;
    }
    public String getColor() {
        return color;
    }
//    public void move (Pair<Integer,Integer> center){
//        setCenter(center);
//    }
}

