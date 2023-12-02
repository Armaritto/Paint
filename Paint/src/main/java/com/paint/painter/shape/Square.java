package com.paint.painter.shape;
import ch.qos.logback.core.joran.sanity.Pair;
public class Square extends Rectangle{

    public Square(double width, double height, double x, double y, String fill, boolean draggable) {
        super(width,height,x,y,fill,draggable);
        width=height;
    }
}
