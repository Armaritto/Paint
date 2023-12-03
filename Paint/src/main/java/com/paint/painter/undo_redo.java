package com.paint.painter;
import com.paint.painter.shape.Shape;
import java.util.ArrayList;
import java.util.Stack;
public class undo_redo {
    Stack<ArrayList<Shape>> undoStack = new Stack<>();
    Stack<ArrayList<Shape>> redoStack = new Stack<>();
    public Stack<ArrayList<Shape>> getUndoStack() {
        return undoStack;
    }
    public void setUndoStack(Stack<ArrayList<Shape>> undoStack) {
        this.undoStack = undoStack;
    }
    public Stack<ArrayList<Shape>> getRedoStack() {
        return redoStack;
    }
    public void setRedoStack(Stack<ArrayList<Shape>> redoStack) {
        this.redoStack = redoStack;
    }
    public void addInUndoStack(ArrayList<Shape> newList){
        ArrayList<Shape> copy = new ArrayList<>();
        copy.addAll(newList);
        undoStack.push(copy);
    }
    public ArrayList<Shape> undo(){
        redoStack.push(undoStack.pop());
        return undoStack.peek();
    }
    public ArrayList<Shape> redo(){
        undoStack.push(redoStack.pop());
        return undoStack.peek();
    }
}
