package com.paint.painter.shape;
public class shapeFactory {
    public Shape makeShape(String shapeType){
        if(shapeType.equals("ellipse")){
            return new Ellipse();
        }
        else if(shapeType.equals("circle")){
            return new Circle();
        }
        else if(shapeType.equals("rectangle")){
            return new Rectangle();
        }
        else if(shapeType.equals("square")){
            return new Square();
        }
        else if(shapeType.equals("triangle")){
            return new Triangle();
        }
        else if(shapeType.equals("line")){
            return new Line();
        }
        else{
            return null;
        }
    }
}
