package com.paint.painter.shape;
public class Circle extends Shape{
    @Override
    public void setShape(int id, String type,String fill,double x, double y, double radius, double var2, double rotationAngle){
        this.setId(id);
        this.setType("circle");
        this.setFill(fill);
        this.setX(x);
        this.setY(y);
        this.setVar1(radius);
    }

    public Shape copy(){
        Circle circle = null;
        try {
            circle = (Circle) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return circle;
    }


//    private double radius;
//    public Circle(double x, double y, String fill, boolean draggable) {
//        super(x, y, fill, draggable);
//    }
//    public double getRadius() {
//        return radius;
//    }
//    public void setRadius(double radius) {
//        this.radius = radius;
//    }

}
