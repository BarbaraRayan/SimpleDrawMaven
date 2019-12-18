package View;

import Controller.SelectionTool;
import Controller.LineTool;
import Controller.DrawingTool;
import Controller.Drawing;
import Controller.CircleTool;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel {

    DrawingTool myDrawingTool;
    Drawing myDrawing = new Drawing();

    public DrawingPanel() {
        super();
        setBackground(java.awt.Color.white);
        myDrawingTool = new SelectionTool(this);
        activate(myDrawingTool);
    }

    public void activateSelectionTool() {
        terminate(myDrawingTool);
        myDrawingTool = new SelectionTool(this);
        activate(myDrawingTool);
        myDrawing.clearSelection();
        repaint();
    }

    public void activateCircleTool() {
        terminate(myDrawingTool);
        myDrawingTool = new CircleTool(this);
        activate(myDrawingTool);
        myDrawing.clearSelection();
        repaint();
    }

    public void activateLineTool() {
        terminate(myDrawingTool);
        myDrawingTool = new LineTool(this);
        activate(myDrawingTool);
        myDrawing.clearSelection();
        repaint();
    }

    @Override
    public void paintComponent(Graphics myGraphic) {
        super.paintComponent(myGraphic);
        Graphics2D myGrapic2 = (Graphics2D) myGraphic;
        RenderingHints qualityHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        myGrapic2.setRenderingHints(qualityHints);
        myDrawing.draw(myGrapic2);
        myDrawingTool.draw(myGrapic2);
    }

    private void terminate(DrawingTool t) {
        removeKeyListener(t);
        removeMouseListener(t);
        removeMouseMotionListener(t);
    }

    private void activate(DrawingTool t) {
        addKeyListener(t);
        addMouseListener(t);
        addMouseMotionListener(t);
    }

    public Drawing getDrawing() {
        return myDrawing;
    }

}
