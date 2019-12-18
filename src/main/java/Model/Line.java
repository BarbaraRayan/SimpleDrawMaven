package Model;

import View.ShapeVisitor;
import java.awt.Graphics2D;
import java.awt.Point;

public class Line extends Shape {

    private Point myStart;
    private Point myEnd;
    static int n = 0;

    public Line(Point start, Point end) {
        myStart = start;
        myEnd = end;
        n++;
    }

    @Override
    public void translateBy(int dx, int dy) {
        myStart.translate(dx, dy);
        myEnd.translate(dx, dy);
    }

    @Override
    public boolean isPickedBy(Point p) {
        return Line.segmentIsPickedBy(myStart, myEnd, p);
    }

    public static boolean segmentIsPickedBy(Point A, Point B, Point C) {
        double a, b;
        double distance;
        double dx, dy;
        double lambda;
        if (A.x != B.x) {
            a = (B.y - A.y) / (double) (B.x - A.x);
            b = (A.y * B.x - B.y * A.x) / (double) (B.x - A.x);
            dx = (C.x - a * (b - C.y)) / (1 + a * a);
            dy = (a * C.x + b + a * a * C.y) / (1 + a * a);
            distance = C.distance(dx, dy);
            lambda = (dx - A.x) / (double) (B.x - A.x);
        } else {
            distance = Math.abs(C.x - A.x);
            lambda = (C.y - A.y) / (double) (B.y - A.y);
        }
        return (distance <= 2) && (lambda >= 0) && (lambda <= 1);
    }

    public void setStart(Point myStart) {
        this.myStart = myStart;
    }

    public void setEnd(Point myEnd) {
        this.myEnd = myEnd;
    }

    public Point getStart() {
        return myStart;
    }

    public Point getEnd() {
        return myEnd;
    }

    public int getsize() {
        return n;
    }

    @Override
    public void useDrawingTool(ShapeVisitor myShapeVisitor) {
        myShapeVisitor.visitor(this);
    }

    public void draw(Graphics2D g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
