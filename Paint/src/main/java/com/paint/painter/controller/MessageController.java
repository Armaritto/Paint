package com.paint.painter.controller;

import com.paint.painter.shape.Shape;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
//@RequestMapping("/api/messages")
public class MessageController {
//    @PostMapping("/backend")
//    public HashMap<String,String> post(@RequestBody Map<String, Object> payload) {
//        HashMap<String, String> response = new HashMap<>();
//        String helloMessage = payload.get("msg").toString();
//        helloMessage += " Software Developer";
//        response.put("msg",String.valueOf(helloMessage));
//        return response;
//    }
@GetMapping("{arrayOfShapes}")
public String getArrayOfShapes(@PathVariable("first") ArrayList<Shape> shapesList) {
    // Your logic for handling GET requests for arrayOfShapes
    //put in stack
    return "Array of shapes response";
}

//when @GetMapping("undo") so pop from stack and put to a storeStack
    //when @GetMapping("redo") so pop from storeStack and put to stack
}
