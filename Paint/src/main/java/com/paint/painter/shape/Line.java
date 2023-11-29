package com.paint.painter.shape;
import ch.qos.logback.core.joran.sanity.Pair;
public class Line extends Shape{
    private Pair<Integer,Integer> startPoint;
    private Pair<Integer,Integer> endPoint;
    public Line(Pair<Integer,Integer> c , double a , String col){
        super(c,a,col);
    }
    public void setStartPoint(Pair<Integer, Integer> startPoint) {
        this.startPoint = startPoint;
    }
    public void setEndPoint(Pair<Integer, Integer> endPoint) {
        this.endPoint = endPoint;
    }
    public Pair<Integer, Integer> getStartPoint() {
        return startPoint;
    }
    public Pair<Integer, Integer> getEndPoint() {
        return endPoint;
    }
}
