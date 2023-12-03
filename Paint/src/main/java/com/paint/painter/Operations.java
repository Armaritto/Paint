package com.paint.painter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.paint.painter.shape.Shape;
import com.paint.painter.shape.shapeFactory;
import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
public class Operations {
    ArrayList<Shape> shapes = new ArrayList<>();
    shapeFactory factory = new shapeFactory();
    undo_redo UR = new undo_redo();
    public ArrayList<Shape> draw(){
        return UR.getUndoStack().peek();
    }
    public void createNewShape(int id, String type,String fill,double x, double y, double var1, double var2, double rotationAngle){
        Shape temp = factory.makeShape(type);
        temp.setShape(id,type,fill,x,y,var1,var2,rotationAngle);
        shapes.add(temp);
        UR.addInUndoStack(shapes);
    }
    public ArrayList<Shape> undo(){
        try{
            return UR.undo();
        }
        catch(EmptyStackException e){
            return null;
        }
    }
    public ArrayList<Shape>redo(){
        return UR.redo();
    }
    public ArrayList<Shape> edit(int id, String type,String fill,double x, double y, double var1, double var2, double rotationAngle){
        for(int i=0; i<shapes.size(); i++){
            if(shapes.get(i).getId()==id){
                shapes.remove(i);
                createNewShape(id,type,fill,x,y,var1,var2,rotationAngle);
            }
        }
        return shapes;
    }
    public ArrayList<Shape> delete(int id){
        for(int i=0; i<shapes.size(); i++){
            if(shapes.get(i).getId()==id){
                shapes.remove(i);
                UR.addInUndoStack(shapes);
            }
        }
        return shapes;
    }
    public ArrayList<Shape> copy(int prevID, int newID){
        for(int i=0; i<shapes.size(); i++){
            if(shapes.get(i).getId()==prevID){
                createNewShape(newID,shapes.get(i).getType(),shapes.get(i).getFill(),shapes.get(i).getX(),shapes.get(i).getY(),shapes.get(i).getVar1(),shapes.get(i).getVar2(),shapes.get(i).getRotationAngle());
            }
        }
        return shapes;
    }
    public void saveToJson(String path) throws IOException {
        String json = new Gson().toJson(UR.undoStack.peek());
        File file = new File(path);
        file.createNewFile();
        FileWriter write = new FileWriter(path);
        write.write(json);
        write.close();
    }
    public ArrayList<Shape> loadJson(String path) throws IOException {
        Path p = Path.of(path);
        String json = Files.readString(p);
        Type listType = new TypeToken<ArrayList<Shape>>() {}.getType();
        shapes = new Gson().fromJson(json, listType);
        UR.undoStack.clear();
        UR.redoStack.clear();
        UR.undoStack.push(shapes);
        return shapes;
    }


}
