package com.paint.painter.shape;
public class Triangle extends Shape{
    @Override
    public void setShape(int id, String type,String fill,double x, double y, double radiusInscribedCircle, double angleOfTriangle, double rotationAngle,double ScaleX, double ScaleY){
        this.setId(id);
        this.setType(type);
        this.setFill(fill);
        this.setX(x);
        this.setY(y);
        this.setVar1(radiusInscribedCircle);
        this.setVar2(angleOfTriangle);
        this.setRotationAngle(rotationAngle);
        this.setScaleX(ScaleX);
        this.setScaleY(ScaleY);
    }
}
