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
    public Shape copy(){
        Ellipse ellipse = null;
        try {
            ellipse = (Ellipse) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return ellipse;
    }

//    private double radiusX;
//    private double radiusY;
//    public Ellipse(double x, double y, String fill, boolean draggable) {
//        super(x, y, fill, draggable);
//    }
//    public double getRadiusX() {
//        return radiusX;
//    }
//    public void setRadiusX(double radiusX) {
//        this.radiusX = radiusX;
//    }
//    public double getRadiusY() {
//        return radiusY;
//    }
//    public void setRadiusY(double radiusY) {
//        this.radiusY = radiusY;
//    }
}
