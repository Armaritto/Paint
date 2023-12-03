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
}
