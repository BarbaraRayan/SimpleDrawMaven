package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.JApplet;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class DrawApplet extends JApplet {

    JToggleButton mySelectButton;
    JToggleButton myLineButton;
    JToggleButton myCircleButton;
    DrawingPanel myDrawingPanel;

    public DrawApplet() {
        myDrawingPanel = new DrawingPanel();
        myCircleButton = new JToggleButton("Circle");
        myLineButton = new JToggleButton("Line");
        mySelectButton = new JToggleButton("Select");
    }

    @Override
    public void init() {
        getContentPane().setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        mySelectButton.setSelected(true);
        mySelectButton.setToolTipText("Select and move shapes");
        myCircleButton.setToolTipText("Draw a Circle");
        myLineButton.setToolTipText("Draw a Line");
        getContentPane().add(buttonPanel, BorderLayout.NORTH);
        buttonPanel.add(mySelectButton, null);
        buttonPanel.add(myLineButton, null);
        buttonPanel.add(myCircleButton, null);
        getContentPane().add(myDrawingPanel, BorderLayout.CENTER);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(mySelectButton);
        buttonGroup.add(myLineButton);
        buttonGroup.add(myCircleButton);
        setSize(new Dimension(400, 300));

    }

    public DrawingPanel getMyDrawingPanel() {
        return myDrawingPanel;
    }

    public JToggleButton getMySelectButton() {
        return mySelectButton;
    }

    public JToggleButton getMyLineButton() {
        return myLineButton;
    }

    public JToggleButton getMyCircleButton() {
        return myCircleButton;
    }

}
