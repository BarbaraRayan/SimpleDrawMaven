package Controller;

import java.util.*;

import java.awt.Graphics2D;
import java.awt.Point;
import Model.Shape;
import View.ShapeDraw;
import View.ShapeView;
import View.ShapeVisitor;

public class Drawing {

    private List<Shape> myShapes = new LinkedList<Shape>();
    private ShapeView view;
    private ShapeVisitor myShapeVisitor;

    public Drawing() {
    }

    public void draw(Graphics2D g) {
        for (Shape s : myShapes) {
            s.setGraphics2D(g);
            myShapeVisitor = new ShapeDraw();
            s.useDrawingTool(myShapeVisitor);
        }
    }

    public void addShape(Shape s) {
        myShapes.add(s);
    }

    public void deleteShape(Shape s) {
        myShapes.remove(s);
    }

    public Shape pickShapeAt(Point p) {
        Shape result = null;
        for (Shape s : myShapes) {
            if (s.isPickedBy(p)) {
                result = s;
                break;
            }
        }
        return result;
    }

    public void clearSelection() {
        for (Shape s : myShapes) {
            s.setSelected(false);
        }
    }
}
