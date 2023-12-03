package com.paint.painter;
import com.paint.painter.shape.Shape;
import com.paint.painter.shape.shapeFactory;
import java.util.*;
public class Operations {
    ArrayList<Shape> shapes = new ArrayList<>();
    shapeFactory factory = new shapeFactory();
    undo_redo UR = new undo_redo();
    public void createNewShape(int id, String type,String fill,double x, double y, double var1, double var2, double rotationAngle){
        Shape temp = factory.makeShape(type);
        temp.setShape(id,type,fill,x,y,var1,var2,rotationAngle);
        shapes.add(temp);
        UR.addInUndoStack(shapes);
    }
    public ArrayList<Shape> undo(){
        return UR.undo();
    }
    public ArrayList<Shape>redo(){
        return UR.redo();
    }
    public ArrayList<Shape> draw(){
        return UR.getUndoStack().peek();
    }
}
