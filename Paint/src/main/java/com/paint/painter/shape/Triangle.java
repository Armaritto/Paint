package com.paint.painter.shape;
public class Triangle extends Shape{
    @Override
    public void setShape(int id, String type,String fill,double x, double y, double radiusInscribedCircle, double angleOfTriangle, double rotationAngle){
        this.setId(id);
        this.setType(type);
        this.setFill(fill);
        this.setX(x);
        this.setY(y);
        this.setVar1(radiusInscribedCircle);
        this.setVar2(angleOfTriangle);
        this.setRotationAngle(rotationAngle);
    }
    public Shape copy(){
        Triangle triangle = null;
        try {
            triangle = (Triangle) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return triangle;
    }
//    public Triangle(double x, double y, String fill, boolean draggable) {
//        super(x, y, fill, draggable);
//    }

}
