package com.paint.painter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.paint.painter.shape.Shape;
import com.paint.painter.shape.shapeFactory;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.*;
public class Operations {
    ArrayList<Shape> shapes = new ArrayList<>();
    shapeFactory factory = new shapeFactory();
    undo_redo UR = new undo_redo();
    public ArrayList<Shape> draw(){
        System.out.println(UR.getUndoStack().peek());
        return UR.getUndoStack().peek();
    }
    public void createNewShape(int id, String type,String fill,double x, double y, double var1, double var2, double rotationAngle, double ScaleX, double ScaleY){
        Shape temp = factory.makeShape(type);
        temp.setShape(id,type,fill,x,y,var1,var2,rotationAngle,ScaleX,ScaleY);
        shapes.add(temp);
        UR.addInUndoStack(shapes);
    }
    public ArrayList<Shape> undo(){
        try{
            return UR.undo();
        }
        catch(EmptyStackException e){
            return new ArrayList<Shape>();
        }
    }
    public ArrayList<Shape>redo(){
        try{
            return UR.redo();
        }
        catch(EmptyStackException e){
            return new ArrayList<Shape>();
        }
    }
    public ArrayList<Shape> edit(int id, String type,String fill,double x, double y, double var1, double var2, double rotationAngle, double ScaleX, double ScaleY){
        for(int i=0; i<shapes.size(); i++){
            if(shapes.get(i).getId()==id){
                shapes.remove(i);
                createNewShape(id,type,fill,x,y,var1,var2,rotationAngle,ScaleX,ScaleY);
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
                createNewShape(newID,shapes.get(i).getType(),shapes.get(i).getFill(),shapes.get(i).getX()+10,shapes.get(i).getY()+10,shapes.get(i).getVar1(),shapes.get(i).getVar2(),shapes.get(i).getRotationAngle(),shapes.get(i).getScaleX(),shapes.get(i).getScaleY());
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
    public void saveToXML(String path) throws IOException {
        XMLEncoder e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(path)));
        e.writeObject(UR.undoStack.peek());
        e.close();
    }
    public ArrayList<Shape> loadXML(String path) throws IOException {
        XMLDecoder d = new XMLDecoder(new BufferedInputStream(new FileInputStream(path)));
        shapes = (ArrayList<Shape>) d.readObject();
        d.close();
        UR.undoStack.clear();
        UR.redoStack.clear();
        UR.undoStack.push(shapes);
        return shapes;
    }
    public void clear(){
        UR.undoStack.push(new ArrayList<Shape>());
    }
}
