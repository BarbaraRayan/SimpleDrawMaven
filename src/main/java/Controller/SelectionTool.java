package Controller;

import Model.Group;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import View.DrawingPanel;
import Model.Shape;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.List;

/**
 * The tool to select, move and delete Shapes in the Drawing
 *
 * @author Rémi Bastide
 * @version 1.0
 */
public class SelectionTool extends DrawingTool {

    private List<Shape> mySelectedShapes;
    Shape myShape = null;

    private Point myLastPoint;

    public void mousePressed(MouseEvent e) {
        Shape pickedShape = myDrawing.pickShapeAt(e.getPoint());
        myLastPoint = e.getPoint();

        if (myShape != null) {
            myShape.setSelected(false);
            mySelectedShapes.remove(myShape);
        }

        if (pickedShape != null) {
            if (myShape == pickedShape) {
                mySelectedShapes.remove(myShape);
                myShape = null;
            } else {
                pickedShape.setSelected(true);
                myShape = pickedShape;
                mySelectedShapes.add(pickedShape);
            }
        } else {
            myDrawing.clearSelection();
            mySelectedShapes.removeAll(mySelectedShapes);
            myShape = null;
        }
        myPanel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        myPanel.repaint();
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_DELETE) {
            if (mySelectedShapes != null) {
                for (Shape s : mySelectedShapes) {
                    myDrawing.deleteShape(s);
                }
                myPanel.repaint();
            }
        } else if (e.getKeyChar() == 'g' | e.getKeyChar() == 'G') {
            if (mySelectedShapes != null) {
                Group myGroup = new Group(mySelectedShapes);
                for (Shape s : mySelectedShapes) {
                    myDrawing.deleteShape(s);
                }
                this.mySelectedShapes = new LinkedList<>();
                myDrawing.addShape(myGroup);
                mySelectedShapes.add(myGroup);
                myDrawing.clearSelection();
                myGroup.setSelected(true);
                myPanel.repaint();
            }
        } else if (e.getKeyChar() == 'u' | e.getKeyChar() == 'U') {
            if (mySelectedShapes != null) {
                Group myGroup = (Group) mySelectedShapes.get(0);
                mySelectedShapes.remove(myGroup);
                myDrawing.deleteShape(myGroup);
                for (Shape s : myGroup.getListForm()) {
                    myDrawing.addShape(s);
                }
                myDrawing.clearSelection();
                myPanel.repaint();
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (mySelectedShapes != null) {
            for (Shape s : mySelectedShapes) {
                s.translateBy(
                        e.getX() - myLastPoint.x,
                        e.getY() - myLastPoint.y);
            }
            myLastPoint = e.getPoint();
            myPanel.repaint();
        }
    }

    public SelectionTool(DrawingPanel panel) {
        super(panel);
        this.mySelectedShapes = new LinkedList<>();

    }

    @Override
    public void draw(Graphics2D g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
