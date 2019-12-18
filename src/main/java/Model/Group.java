package Model;

import View.ShapeVisitor;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.List;

public class Group extends Shape {

    private List<Shape> myShapeList;

    public Group(List<Shape> shapes) {
        myShapeList = shapes;
    }

    @Override
    public void setSelected(boolean select) {
        iAmSelected = select;
        for (Shape myShape : myShapeList) {
            myShape.setSelected(select);
        }
    }

    public List<Shape> getListForm() {
        return myShapeList;
    }

    public void addShape(Shape s) {
        myShapeList.add(s);
    }

    public void RemoveShape(Shape s) {
        myShapeList.remove(s);
    }

    public List<Shape> setShape() {
        return myShapeList;
    }

    @Override
    public void translateBy(int dx, int dy) {
        for (Shape s : myShapeList) {
            s.translateBy(dx, dy);
        }
    }

    @Override
    public boolean isPickedBy(Point p) {
        for (Shape s : myShapeList) {
            if (s.isPickedBy(p)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void useDrawingTool(ShapeVisitor myShapeVisitor) {
        myShapeVisitor.visitor(this);
    }

    public void draw(Graphics2D g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
