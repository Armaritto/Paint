package com.paint.painter.shape;
public class Line extends Shape{
    @Override
    public void setShape(int id, String type,String fill,double x1, double y1, double x2, double y2, double rotationAngle){
        this.setId(id);
        this.setType(type);
        this.setFill(fill);
        this.setX(x1);
        this.setY(y1);
        this.setVar1(x2);
        this.setVar2(y2);
        this.setRotationAngle(rotationAngle);
    }
    public Shape copy(){
        Line line = null;
        try {
            line = (Line) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return line;
    }
//    private double endX;
//    private double endY;
//    public Line(double x, double y, String fill, boolean draggable) {
//        super(x, y, fill, draggable);
//    }
//    public double getEndX() {
//        return endX;
//    }
//    public void setEndX(double endX) {
//        this.endX = endX;
//    }
//    public double getEndY() {
//        return endY;
//    }
//    public void setEndY(double endY) {
//        this.endY = endY;
//    }

}
