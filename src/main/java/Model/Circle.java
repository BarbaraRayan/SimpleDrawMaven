package Model;

import View.ShapeVisitor;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class Circle extends Shape {

    private Point myCenter;
    private int myRadius;
    Graphics2D myGraphics;
    static int n = 0;

    public Circle(Point center, int radius) {
        myCenter = center;
        myRadius = radius;
        n++;
    }

    public void draw(Graphics2D g) {
        g.setColor(isSelected() ? Color.red : Color.black);
        g.drawOval(myCenter.x - myRadius, myCenter.y - myRadius, myRadius * 2, myRadius * 2);
    }

    @Override
    public void translateBy(int dx, int dy) {
        myCenter.translate(dx, dy);
    }

    @Override
    public boolean isPickedBy(Point p) {
        return (Math.abs(myCenter.distance(p) - myRadius) <= 2);
    }

    public Point getCenter() {
        return myCenter;
    }

    public int getRadius() {
        return myRadius;
    }

    public int getNumber() {
        return n;
    }

    @Override
    public void useDrawingTool(ShapeVisitor myShapeVisitor) {
        myShapeVisitor.visitor(this);
    }

}
