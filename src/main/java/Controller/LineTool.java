package Controller;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import View.DrawingPanel;
import Model.Line;
import View.ShapeView;

public class LineTool extends DrawingTool {

    private boolean iAmActive = false;
    private Point myInitialPoint;
    private Point myFinalPoint;
    private Line myLine;
    private ShapeView view;

    public LineTool(DrawingPanel panel) {
        super(panel);
        view = new ShapeView(panel);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (!iAmActive) {
            iAmActive = true;
            myInitialPoint = e.getPoint();
            myFinalPoint = myInitialPoint;
            myPanel.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
            myPanel.repaint();
        } else {
            iAmActive = false;
            Line ligne = new Line(myInitialPoint, myFinalPoint);
            myDrawing.addShape(ligne);
            view.visitor(ligne);
            myPanel.setCursor(Cursor.getDefaultCursor());
            myPanel.repaint();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (iAmActive) {
            myFinalPoint = e.getPoint();
            myPanel.repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseDragged(e);
    }

    @Override
    public void draw(Graphics2D g) {
        if (iAmActive) {
            g.setColor(Color.red);
            g.drawLine(myInitialPoint.x, myInitialPoint.y, myFinalPoint.x, myFinalPoint.y);
        }
    }
}
