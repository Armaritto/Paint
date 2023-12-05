package com.paint.painter.controller;
import com.paint.painter.shape.Shape;
import com.paint.painter.Operations;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.*;
@RestController
@CrossOrigin
public class MessageController {
Operations operations = new Operations();
@PostMapping(path = "/newShape")
    public Shape createNewShape(@RequestParam("id") int id , @RequestParam("type") String type, @RequestParam("fill") String fill
        , @RequestParam("x") double x, @RequestParam("y") double y, @RequestParam("var1") double var1, @RequestParam("var2") double var2, @RequestParam("rotationAngle") double rotationAngle){
        operations.createNewShape(id,type,fill,x,y,var1,var2,rotationAngle);
        return operations.draw().get(operations.draw().size()-1);
    }
@PostMapping(path = "/getArrayOfShapes")
    public ArrayList<Shape> getArrayOfShapes(){
        return operations.draw();
    }
@PostMapping(path = "/undo")
    public ArrayList<Shape> undo(){
        return operations.undo();
    }
@PostMapping(path = "/redo")
    public ArrayList<Shape> redo(){
        return operations.redo();
    }
@PostMapping(path = "/edit")
    public ArrayList<Shape> edit(@RequestParam("id") int id , @RequestParam("type") String type, @RequestParam("fill") String fill
        , @RequestParam("x") double x, @RequestParam("y") double y, @RequestParam("var1") double var1, @RequestParam("var2") double var2, @RequestParam("rotationAngle") double rotationAngle){
        return operations.edit(id,type,fill,x,y,var1,var2,rotationAngle);
    }
@PostMapping(path = "/delete")
    public ArrayList<Shape> delete(@RequestParam("id") int id){
        return operations.delete(id);
    }
@PostMapping(path = "/copy")
    public ArrayList<Shape> copy(@RequestParam("prevID") int prevID,@RequestParam("newID") int newID){
        return operations.copy(prevID,newID);
    }
@PostMapping(path = "/saveJSON")
    public String saveJSON(@RequestParam("path") String path){
        try{
            operations.saveToJson(path);
            return "Saved successfully in JSON File";
        }
        catch(Exception e){
            return "Error!";
        }
    }
@PostMapping(path = "/loadJSON")
    public ArrayList<Shape> loadJSON(@RequestParam("path") String path) throws IOException {
        return operations.loadJson(path);
    }
@PostMapping(path = "/saveXML")
    public String saveXML(@RequestParam("path") String path){
        try{
            operations.saveToXML(path);
            return "Saved successfully in XML File";
        }
        catch(Exception e){
            return "Error!";
        }
    }
@PostMapping(path = "/loadXML")
    public ArrayList<Shape> loadXML(@RequestParam("path") String path) throws IOException {
        return operations.loadXML(path);
    }
}
