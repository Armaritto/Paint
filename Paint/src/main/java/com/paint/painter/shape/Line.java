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
}
