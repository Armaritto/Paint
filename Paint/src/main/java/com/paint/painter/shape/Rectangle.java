package com.paint.painter.shape;
public class Rectangle extends Shape{
    @Override
    public void setShape(int id, String type,String fill,double x, double y, double length, double width, double rotationAngle){
        this.setId(id);
        this.setType(type);
        this.setFill(fill);
        this.setX(x);
        this.setY(y);
        this.setVar1(length);
        this.setVar2(width);
        this.setRotationAngle(rotationAngle);
    }
    public Shape copy(){
        Rectangle rectangle = null;
        try {
            rectangle = (Rectangle) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return rectangle;
    }
//    private double width;
//    private double height;
//    public Rectangle(double x, double y, String fill, boolean draggable) {
//        super(x, y, fill, draggable);
//    }
//    public double getWidth() {
//        return width;
//    }
//    public void setWidth(double width) {
//        this.width = width;
//    }
//    public double getHeight() {
//        return height;
//    }
//    public void setHeight(double height) {
//        this.height = height;
//    }



}
