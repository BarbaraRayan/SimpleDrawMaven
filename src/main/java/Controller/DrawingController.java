package Controller;

import View.DrawApplet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawingController {

    DrawApplet myDrawApplet;

    public DrawingController() {
        myDrawApplet = new DrawApplet();
        myDrawApplet.getMySelectButton().addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                myDrawApplet.getMyDrawingPanel().activateSelectionTool();
            }
        }
        );

        myDrawApplet.getMyLineButton().addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                myDrawApplet.getMyDrawingPanel().activateLineTool();
            }
        }
        );
        myDrawApplet.getMyCircleButton().addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                myDrawApplet.getMyDrawingPanel().activateCircleTool();
            }
        }
        );
    }

}
