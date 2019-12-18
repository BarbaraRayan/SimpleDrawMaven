package Model;

import java.awt.Graphics2D;
import java.awt.Point;
import View.ShapeVisitor;

public abstract class Shape {

    boolean iAmSelected = false;
    private Graphics2D myGraphic;

    public boolean isSelected() {
        return iAmSelected;
    }

    public void setSelected(boolean selected) {
        iAmSelected = selected;
    }

    abstract public void translateBy(int dx, int dy);

    abstract public boolean isPickedBy(Point p);

    public abstract void useDrawingTool(ShapeVisitor d);

    public void setGraphics2D(Graphics2D myGraphic) {
        this.myGraphic = myGraphic;
    }

    public Graphics2D getGraphics2D() {
        return myGraphic;
    }

}
