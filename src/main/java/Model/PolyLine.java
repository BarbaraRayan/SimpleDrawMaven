package Model;

import View.ShapeVisitor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.awt.Graphics2D;
import java.awt.Point;

public class PolyLine extends Shape {

    private final List<Point> myPoints;

    public PolyLine(Collection<Point> points) {
        if (points.size() < 2) {
            throw new IllegalArgumentException("A PolyLine needs at least 2 Points");
        }
        myPoints = new ArrayList<>(points);
    }

    @Override
    public void translateBy(int dx, int dy) {
        for (Iterator<Point> it = myPoints.iterator(); it.hasNext();) {
            Point p = it.next();
            p.translate(dx, dy);
        }
    }

    @Override
    public boolean isPickedBy(Point p) {
        boolean result = false;
        Iterator<Point> points = myPoints.iterator();
        Point last = points.next();
        do {
            Point current = points.next();
            if (Line.segmentIsPickedBy(last, current, p)) {
                result = true;
                break;
            }
            last = current;
        } while (points.hasNext());
        return result;
    }

    public List<Point> getPoint() {
        return myPoints;
    }

    @Override
    public void useDrawingTool(ShapeVisitor myShapeVisitor) {
        myShapeVisitor.visitor(this);
    }

    public void draw(Graphics2D g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
