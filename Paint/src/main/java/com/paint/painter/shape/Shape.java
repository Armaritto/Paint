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
}

