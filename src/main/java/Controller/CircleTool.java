package Controller;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import Model.Circle;
import View.DrawingPanel;
import View.ShapeView;

public class CircleTool
        extends DrawingTool {

    private boolean iAmActive = false;
    private Point myCenter;
    private int myRadius;
    private ShapeView view;

    public CircleTool(DrawingPanel panel) {
        super(panel);
        view = new ShapeView(panel);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (!iAmActive) {
            iAmActive = true;
            myCenter = e.getPoint();
            myRadius = 0;
            myPanel.setCursor(
                    Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR)
            );
            myPanel.repaint();
        } else {
            iAmActive = false;
            Circle cercle = new Circle(myCenter, myRadius);
            myDrawing.addShape(cercle);
            view.visitor(cercle);
            myPanel.setCursor(Cursor.getDefaultCursor());
            myPanel.repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (iAmActive) {
            myRadius = (int) (myCenter.distance(e.getPoint()));
            myPanel.repaint();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseMoved(e);
    }

    @Override
    public void draw(Graphics2D g) {
        if (iAmActive) {
            g.setColor(Color.red);
            g.drawOval(myCenter.x - myRadius, myCenter.y - myRadius, myRadius * 2, myRadius * 2);
        }
    }
}
