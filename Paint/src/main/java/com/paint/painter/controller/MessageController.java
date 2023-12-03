package com.paint.painter.controller;
import com.paint.painter.shape.Shape;
import com.paint.painter.Operations;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@CrossOrigin
public class MessageController {
Operations operations = new Operations();
@PostMapping(path = "/newShape")
    public void createNewShape(@RequestParam("id") int id , @RequestParam("type") String type, @RequestParam("fill") String fill
        , @RequestParam("x") double x, @RequestParam("y") double y, @RequestParam("var1") double var1, @RequestParam("var2") double var2, @RequestParam("rotationAngle") double rotationAngle){
        // Your logic for handling GET requests for arrayOfShapes
        // put in stack
        operations.createNewShape(id,type,fill,x,y,var1,var2,rotationAngle);
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
}
