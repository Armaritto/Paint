package com.paint.painter.shape;
public class Square extends Shape{
    @Override
    public void setShape(int id, String type,String fill,double x, double y, double length, double width, double rotationAngle,double ScaleX, double ScaleY){
        this.setId(id);
        this.setType(type);
        this.setFill(fill);
        this.setX(x);
        this.setY(y);
        this.setVar1(length);
        this.setVar2(width);
        this.setRotationAngle(rotationAngle);
        this.setScaleX(ScaleX);
        this.setScaleY(ScaleY);
    }
}
