package com.paint.painter.shape;
public class Ellipse extends Shape {
    @Override
    public void setShape(int id, String type,String fill,double x, double y, double radius1, double radius2, double rotationAngle){
        this.setId(id);
        this.setType(type);
        this.setFill(fill);
        this.setX(x);
        this.setY(y);
        this.setVar1(radius1);
        this.setVar2(radius2);
        this.setRotationAngle(rotationAngle);
    }
}
