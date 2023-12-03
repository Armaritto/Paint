package com.paint.painter.shape;
public class Square extends Shape{
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
        Square square = null;
        try {
            square = (Square) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return square;
    }
//    public Square(double x, double y, String fill, boolean draggable) {
//        super(x,y,fill,draggable);
//    }
}
