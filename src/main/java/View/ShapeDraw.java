package View;

import Model.Circle;
import Model.Group;
import Model.Line;
import Model.PolyLine;
import Model.Shape;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Iterator;
import java.util.List;

public class ShapeDraw implements ShapeVisitor {

    public void draw(Graphics2D g, boolean select, Point myCenter, int myRadius) {
        g.drawOval(myCenter.x - myRadius, myCenter.y - myRadius, myRadius * 2, myRadius * 2
        );
    }

    public void draw(Graphics2D g, boolean select, Point myStart, Point myEnd) {
        g.drawLine(myStart.x, myStart.y, myEnd.x, myEnd.y);
    }

    public void draw(Graphics2D g, boolean select, List<Shape> listForm) {
        for (Shape myShape : listForm) {
            myShape.setGraphics2D(g);
            myShape.useDrawingTool(this);
        }
    }

    public void drawPoints(Graphics2D g, boolean select, List<Point> myPoints) {
        Iterator<Point> points = myPoints.iterator();
        Point last = points.next();
        do {
            Point current = points.next();
            g.drawLine(last.x, last.y, current.x, current.y);
            last = current;
        } while (points.hasNext());
    }

    @Override
    public void visitor(Line myLine) {
        draw(myLine.getGraphics2D(), myLine.isSelected(), myLine.getStart(), myLine.getEnd());
    }

    @Override
    public void visitor(PolyLine myPolyLine) {
        drawPoints(myPolyLine.getGraphics2D(), myPolyLine.isSelected(), myPolyLine.getPoint());
    }

    @Override
    public void visitor(Circle myCircle) {
        draw(myCircle.getGraphics2D(), myCircle.isSelected(), myCircle.getCenter(), myCircle.getRadius());
    }

    @Override
    public void visitor(Group myGroup) {
        draw(myGroup.getGraphics2D(), myGroup.isSelected(), myGroup.getListForm());
    }
}
