package com.paint.painter.shape;
public class Shape{
    private int id;
    private String type;
    private String fill;
    private double x;
    private double y;
    private double var1;
    private double var2;
    private double rotationAngle;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getFill() {
        return fill;
    }
    public void setFill(String fill) {
        this.fill = fill;
    }
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double getVar1() {
        return var1;
    }
    public void setVar1(double var1) {
        this.var1 = var1;
    }
    public double getVar2() {
        return var2;
    }
    public void setVar2(double var2) {
        this.var2 = var2;
    }
    public double getRotationAngle() {
        return rotationAngle;
    }
    public void setRotationAngle(double rotationAngle) {
        this.rotationAngle = rotationAngle;
    }
    public void setShape(int id, String type,String fill,double x, double y, double var1, double var2, double rotationAngle){}

//    public Shape copy(int id, String type, String fill, double x, double y, double var1, double var2, double rotationAngle){
//        shapeFactory factory = new shapeFactory();
//        Shape shape = factory.makeShape(type);
//        shape.setShape(id, type, fill, x, y, var1, var2, rotationAngle);
//        return shape;
//    }


//    private double x;
//    private double y;
//    private String fill;
//    private boolean draggable;
//    public Shape(double x, double y, String fill, boolean draggable) {
//        this.x = x;
//        this.y = y;
//        this.fill = fill;
//        this.draggable = draggable;
//    }
//    public double getX() {
//        return x;
//    }
//    public void setX(double x) {
//        this.x = x;
//    }
//    public double getY() {
//        return y;
//    }
//    public void setY(double y) {
//        this.y = y;
//    }
//    public String getFill() {
//        return fill;
//    }
//    public void setFill(String fill) {
//        this.fill = fill;
//    }
//    public boolean isDraggable() {
//        return draggable;
//    }
//    public void setDraggable(boolean draggable) {
//        this.draggable = draggable;
//    }
}

