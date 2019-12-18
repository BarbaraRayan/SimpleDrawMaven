package View;

import Model.Circle;
import Model.Group;
import Model.Line;
import Model.PolyLine;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

public final class ShapeView  extends JPanel implements ShapeVisitor  {
    DrawingPanel myDrawingPanel;
    private static JLabel text = new JLabel(" ");
    static int numberOfLines = 0;
    static int numberOfCircles = 0;
    static int numberOfGroups = 0;
    static int numberOfPolylines = 0;
    
    public ShapeView(DrawingPanel panel){
        super();
        myDrawingPanel = panel;
        super.setBackground(Color.yellow);
        informations();
    }
    
        public void informations(){
        text.setText("Ligne(s): " +numberOfLines+ "\n Cercle(s): " +numberOfCircles);
        myDrawingPanel.add(text);
    }
        
    @Override
    public void visitor(Group myGroup) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visitor(Line myLine) {
        numberOfLines = myLine.getsize();
    }

    @Override
    public void visitor(Circle myCircle) {
        numberOfCircles = myCircle.getNumber();
    }

    @Override
    public void visitor(PolyLine myPolyLine) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    
